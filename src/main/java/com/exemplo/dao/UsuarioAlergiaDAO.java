package com.exemplo.dao;

import com.exemplo.controller.ConexaoBanco;
import com.exemplo.model.Alergia;
import com.exemplo.model.Usuario;
import com.exemplo.model.UsuarioAlergia;
import org.postgresql.core.SqlCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;


public class UsuarioAlergiaDAO {
    public boolean inserirUsuarioAlergia(UsuarioAlergia usuarioAlergia) throws SQLException {
        String sql= "insert into usuario_alergia (dt_registro, grau, id_usuario , id_alergia) values (?,?,?,?)";

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstm = cnn.prepareStatement(sql)){
                pstm.setObject(1, usuarioAlergia.getDtRegistro());
                pstm.setInt(2,usuarioAlergia.getGrau());
                pstm.setInt(3,usuarioAlergia.getIdUsuario());
                pstm.setInt(4,usuarioAlergia.getIdAlergia());
            return pstm.executeUpdate()>0;
        }
    }

    public ArrayList<UsuarioAlergia> read() throws SQLException{
        String sql= "select*from usuario_alergia order by id_usuario_alergia";
        ArrayList<UsuarioAlergia> usuarioAlergia = new ArrayList<>();

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstmt = cnn.prepareStatement(sql);
             ResultSet rset = pstmt.executeQuery()) {
            while (rset.next()){
                UsuarioAlergia usAl = new UsuarioAlergia (
                        rset.getInt("id_usuario_alergia"),
                        rset.getObject("dt_registro", LocalDate.class),
                        rset.getInt("grau"),
                        rset.getInt("id_usuario"),
                        rset.getInt("id_alergia"));
                usuarioAlergia.add(usAl);
            }
        } return usuarioAlergia;
    }

    public Alergia readById(int id) throws SQLException{
        String sql= "select*from alergia where id_alergia = ?";
        Alergia alergia = null;

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstm = cnn.prepareStatement(sql)){
            pstm.setInt(1,id);

            try (ResultSet rset = pstm.executeQuery()) {
                if(rset.next()){
                    Alergia al1 = new Alergia(rset.getInt("id_alergia"), rset.getString("nome_alergia"));
                }
            }
        }return alergia;

    }

    public int update(UsuarioAlergia usuarioAlergia) throws SQLException{
        String sql = "update usuario_alergia set dt_registro= ?, grau = ?, id_usuario = ?, id_alergia = ? where id_usuario_alergia= ?";

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstm = cnn.prepareStatement(sql)){

            pstm.setObject(1, usuarioAlergia.getDtRegistro());
            pstm.setInt(2, usuarioAlergia.getGrau());
            pstm.setInt(3,usuarioAlergia.getIdUsuario());
            pstm.setInt(4,usuarioAlergia.getIdAlergia());

            return pstm.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException{
        String sql = "delete from usuario_alergia where id_usuario_alergia = ?";

        try (Connection cnn = new ConexaoBanco().conectar();
             PreparedStatement pstm = cnn.prepareStatement(sql)){

            pstm.setInt(1, id);
            return pstm.executeUpdate();
        }
    }

}
