package com.exemplo.dao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.exemplo.controller.ConexaoBanco;

import com.exemplo.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*try (Connection cnn = new ConexaoBanco().conectar();
             Statement stmt = cnn.createStatement()) {
            stmt.execute("SELECT setval('usuario_id_usuario_seq', (SELECT MAX(id_usuario) FROM usuario))");
            System.out.println("Sequência ajustada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        */
        try{

        Usuario usuario = new Usuario ("Janderson Martins", "Masculino", "jdhfhd" ,  "1234",551198976, LocalDate.of(2000,6,7), LocalDate.of(2026,8,27));
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println();
        dao.cadastrarUsuario(usuario);

        UsuarioDAO ud = new UsuarioDAO();
        ArrayList<Usuario> usuarios = ud.read();
        for (Usuario user : usuarios){
            System.out.println(user);
        }

        } catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}

