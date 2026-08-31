package com.exemplo.dao;

import com.exemplo.controller.ConexaoBanco;
import com.exemplo.model.Produto;
import com.exemplo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
/*
    public boolean cadastrarUsuario(Produto produto) throws SQLException {
        String sql = "insert into produto (nome, marca, categoria, descricao, eh_vegano, eh_cruelty_free, pontuacao, lista_ingredientes) values (?,?,?,?,?,?)";

        try (Connection cnn= new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)){
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setString(3, produto.getCategoria());
            pstmt.setString(4, produto.getDescricao());
            pstmt.setString(5, produto.getEhVegano());
            pstmt.setString(6,produto.getEhCrueltyFree());
            pstmt.setInt(7,produto.getPontuacao());
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
                Produto prod1 = new Produto(
                        rset.getInt("id_produto as Id Produto"),
                        rset.getString("nome as Nome Produto"),
                        rset.getString("marca as Marca Produto"),
                        rset.getString("categoria as Categoria Produto"),
                        rset.getString("descricao as Descricao Produto"),
                        rset.getString("eh_vegano as Eh Vegano"),
                        rset.getString("eh_cruelty_free as Eh Cruelty Free"),
                        rset.getInt("pontuacao as Pontuação Produto"),
                        rset.getString("lista_ingredientes as Lista Ingredientes Produto")

                        );
                produto.add(prod1);
            }
        } return produto;

    }

    public Produto readById(int id) throws SQLException{
        String sql = "select * from produto where id_usuario =?";
        Produto produto = null;
        //ainda sem objeto
        try(Connection cnn = new ConexaoBanco().conectar();
            PreparedStatement pstmt= cnn.prepareStatement(sql)){

            pstmt.setInt(1,id);

            try (ResultSet rset = pstmt.executeQuery()){
                //que permite a visualização das tabelas
                if(rset.next()){
                    produto = new Produto(
                            rset.getInt("id_produto as Id Produto"),
                            rset.getString("nome as Nome Produto"),
                            rset.getString("marca as Marca Produto"),
                            rset.getString("categoria as Categoria Produto"),
                            rset.getString("descricao as Descricao Produto"),
                            rset.getString("eh_vegano as Eh Vegano"),
                            rset.getString("eh_cruelty_free as Eh Cruelty Free"),
                            rset.getInt("pontuacao as Pontuação Produto"),
                            rset.getString("lista_ingredientes as Lista Ingredientes Produto")
                            //retornará o usuario com o id que está sendo procurado.
                    );
                }
            }

        } return produto;
    }
    public int alterarValores(Produto produto) throws SQLException {
        String sql = "update produto set nome = ?, marca = ?, categoria = ?, descricao = ?, eh_vegano = ?, eh_cruelty_free = ?, pontuacao = ?, lista_ingredientes = ?";
        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)){

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setString(3, produto.getCategoria());
            pstmt.setString(4, produto.getDescricao());
            pstmt.setString(5, produto.getEhVegano());
            pstmt.setString(5, produto.getEhCrueltyFree());
            pstmt.setInt(6,produto.getPontuacao());
            pstmt.setString(5, produto.getListaIngredientes());


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

 */
}
