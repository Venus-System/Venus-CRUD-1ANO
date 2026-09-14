package com.exemplo.servlet;

import com.exemplo.dao.UsuarioDAO;
import com.exemplo.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {
        //transforma a classe Java comum em um Servlet

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    //O tomcat cria só uma instância do servlet e reutiliza.

    @Override  //reescreve um metodo que já existe na classe HttpServletRequest..
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            //request representa o pedido que chegou do navegador.
            //response representa a resposta que será construída.
        throws ServletException, IOException{
        try {
            ArrayList<Usuario> listaUsuarios = usuarioDAO.read();
            //busca os dados no banco através do DAO.

            request.setAttribute("usuarios", listaUsuarios);
            //lista está sendo guardada dentro do resquest usando a chava 'usuarios'.
            request.getRequestDispatcher("/lista_usuarios.jsp").forward(request, response);
            //caminho até o JSP(vitrine, a página que aparece para o usuário), o forward encaminha o pedido, mantendo os atributos.
        }catch (SQLException sqle){
            throw new RuntimeException(sqle.getMessage());

        }

    }
}
