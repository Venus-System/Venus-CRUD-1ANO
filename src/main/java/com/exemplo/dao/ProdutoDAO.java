package com.exemplo.dao;

import com.exemplo.controller.ConexaoBanco;
import com.exemplo.model.Produto;
import com.exemplo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoDAO {
    public boolean cadastrarProduto(Produto produto) throws SQLException{
        String sql = "insert into produto (nome, marca, categoria, descricao, eh_vegano, eh_cruelty_free, pontuacao, lista_ingredientes) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection cnn= new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)){
            pstmt.setString(1,produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setString(3,produto.getCategoria());
            pstmt.setString(4, produto.getDescricao());
            pstmt.setBoolean(5, produto.getEhVegano());
            pstmt.setBoolean(6, produto.getEhCrueltyFree());
            pstmt.setInt(7, produto.getPontuacao());
            pstmt.setString(8, produto.getListaIngredientes());

            return pstmt.executeUpdate()>0;
            // o executeUpdate so vai retornar quantas linhas do banco foram alteradas, não retorna os dados inseridos.
        }
    }

    public ArrayList<Produto> read() throws SQLException {
        String sql = "select * from produto order by id_produto";
        ArrayList<Produto> produto = new ArrayList<>();

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Produto p1 = new Produto(
                    rset.getInt("id_produto"),
                    rset.getString("nome"),
                    rset.getString("marca"),
                    rset.getString("categoria"),
                    rset.getString("descricao"),
                    rset.getBoolean("eh_vegano"),
                    rset.getBoolean("eh_cruelty_free"),
                    rset.getInt("pontuacao"),
                    rset.getString("lista_ingrediente")

                );
                produto.add(p1);
            }
        } return produto;

    }

    public Produto readById(int id) throws SQLException{
        String sql = "select * from produto where id_produto = ?";
        Produto produto = null;
        //ainda sem objeto
        try(Connection cnn = new ConexaoBanco().conectar();
            PreparedStatement pstmt= cnn.prepareStatement(sql)){

            pstmt.setInt(1,id);

            try (ResultSet rset = pstmt.executeQuery()){
                //que permite a visualização das tabelas
                if(rset.next()){
                    produto = new Produto(
                            rset.getInt("id_produto"),
                            rset.getString("nome"),
                            rset.getString("marca"),
                            rset.getString("categoria"),
                            rset.getString("descricao"),
                            rset.getBoolean("eh_vegano"),
                            rset.getBoolean("eh_cruelty_free"),
                            rset.getInt("pontuacao"),
                            rset.getString("lista_ingrediente")

                            //retornará o produto com o id que está sendo procurado.
                    );
                }
            }

        } return produto;
    }
    public int update (Produto produto) throws SQLException {
        String sql = "update produto set nome =? , marca =?, categoria =?, descricao =?, eh_vegano =?, eh_cruelty_free =?, pontuacao =?, lista_ingredientes= ? where id_produto = ? ";
        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)){

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setString(3, produto.getCategoria());
            pstmt.setString(4, produto.getDescricao());
            pstmt.setBoolean(5, produto.getEhVegano());
            pstmt.setBoolean(6, produto.getEhCrueltyFree());
            pstmt.setInt(7, produto.getPontuacao());
            pstmt.setString(8, produto.getListaIngredientes());


            return pstmt.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException {
        String sql = "delete from produto where id_produto = ?";
        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)) {

            pstmt.setInt(1,id);
            return pstmt.executeUpdate();

        }
    }
}
