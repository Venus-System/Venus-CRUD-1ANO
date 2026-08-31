package com.exemplo.dao;

import com.exemplo.controller.ConexaoBanco;
import com.exemplo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class IngredientesDAO {

    /*public boolean cadastrarIngrediente(Usuario usuario) throws SQLException {
        String sql = "insert into usuario (nome_completo, genero, email, senha, dt_nascimento, telefone) values (?,?,?,?,?,?)";

        try (Connection cnn= new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql)){
                pstmt.setInt(1, usuario.getIdUsuario());
                pstmt.setString(2,usuario.getNomeCompleto());
                pstmt.setString(3, usuario.getGenero());
                pstmt.setString(4, usuario.getEmail());
                pstmt.setString(5, usuario.getSenha());
                pstmt.setObject(6, usuario.getDtNascimento());
                pstmt.setLong(7,usuario.getTelefone());
                pstmt.setObject(8, usuario.getDtCadastro());
                return pstmt.executeUpdate()>0;
            // o executeUpdate so vai retornar quantas linhas do banco foram alteradas, não retorna os dados inseridos.
        }
    }


    /*public ArrayList<Usuario> read() throws SQLException {
        String sql = "select * from usuario order by id_usuario";
        ArrayList<Usuario> usuario = new ArrayList<>();

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()) {
                Usuario user1 = new Usuario(
                        rset.getInt("id_usuario"),
                        rset.getString("nome"),
                        rset.getString("genero"),
                        rset.getString("senha"),
                        rset.getString("email"),
                        rset.getInt("telefone"),
                        rset.getObject("dt_nascimento", LocalDate.class),
                        rset.getObject("dt_cadastro", LocalDate.class)
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
                            rset.getInt("id_usuario"),
                            rset.getString("nome"),
                            rset.getString("genero"),
                            rset.getString("senha"),
                            rset.getString("email"),
                            rset.getLong("telefone"),
                            rset.getObject("dt_nascimento", LocalDate.class),
                            rset.getObject("dt_cadastro", LocalDate.class)

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
            pstmt.setObject(5, usuario.getDtNascimento());
            pstmt.setLong(6,usuario.getTelefone());

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

     */
}
