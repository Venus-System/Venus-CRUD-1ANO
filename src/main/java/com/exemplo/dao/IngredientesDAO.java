package com.exemplo.dao;

import com.exemplo.controller.ConexaoBanco;
import com.exemplo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientesDAO {

    public boolean cadastrarUsuario(Usuario usuario) throws SQLException {
        String sql = "insert into usuario (nome_completo, genero, email, senha, dt_nascimento, telefone) values (?,?,?,?,?,?)";

        try (Connection cnn= new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)){
            pstmt.setString(1,usuario.getNomeCompleto());
            pstmt.setString(2, usuario.getGenero());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getSenha());
            pstmt.setString(5, usuario.getDtNascimento());
            pstmt.setInt(6,usuario.getTelefone());

            return pstmt.executeUpdate()>0;
            // o executeUpdate so vai retornar quantas linhas do banco foram alteradas, não retorna os dados inseridos.
        }
    }

    public ArrayList<Usuario> read() throws SQLException {
        String sql = "select * from usuario order by id_usuario";
        ArrayList<Usuario> usuario = new ArrayList<>();

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Usuario user1 = new Usuario(
                        rset.getInt("id_usuario as Id Usuario"),
                        rset.getString("nome as Nome Completo"),
                        rset.getString("senha as Senha"),
                        rset.getString("email as Email"),
                        rset.getString("dt_nascimento as Data Nascimento"),
                        rset.getInt("telefone as Telefone"),
                        rset.getString("dt_cadastro as Data Cadastro")
                );
                usuario.add(user1);
            }
        } return usuario;

    }

    public Usuario readById(int id) throws SQLException{
        String sql = "select * from usuario where id_usuario =?";
        Usuario usuario = null;
        //ainda sem objeto
        try(Connection cnn = new ConexaoBanco().conectar();
            PreparedStatement pstmt= cnn.prepareStatement(sql)){

            pstmt.setInt(1,id);

            try (ResultSet rset = pstmt.executeQuery()){
                //que permite a visualização das tabelas
                if(rset.next()){
                    usuario = new Usuario(
                            rset.getInt("id_usuario as Id Usuario"),
                            rset.getString("nome as Nome Completo"),
                            rset.getString("senha as Senha"),
                            rset.getString("email as Email"),
                            rset.getString("dt_nascimento as Data Nascimento"),
                            rset.getInt("telefone as Telefone"),
                            rset.getString("dt_cadastro as Data Cadastro")

                            //retornará o usuario com o id que está sendo procurado.
                    );
                }
            }

        } return usuario;
    }
    public int alterarValores(Usuario usuario) throws SQLException {
        String sql = "update usuario set nome_completo = ?, genero = ?, email = ?, senha = ?, dt_nascimento = ?, telefone = ?";
        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)){

            pstmt.setString(1, usuario.getNomeCompleto());
            pstmt.setString(2, usuario.getGenero());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getSenha());
            pstmt.setString(5, usuario.getDtNascimento());
            pstmt.setInt(6,usuario.getTelefone());

            return pstmt.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException {
        String sql = "delete from usuario where id_usuario = ?";
        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)) {

            pstmt.setInt(1,id);
            return pstmt.executeUpdate();

        }
    }
}
