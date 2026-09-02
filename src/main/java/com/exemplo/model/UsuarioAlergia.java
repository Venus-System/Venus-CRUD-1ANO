package com.exemplo.model;/

public class UsuarioAlergia {

    private int idProdutoUsuario;
    private String dtRegistro;
    private int grau;
    private int idUsuario;
    private int idAlergia;

    public UsuarioAlergia(String dtRegistro, int grau, int idUsuario, int idProdutoUsuario, int idAlergia) {
        this.dtRegistro = dtRegistro;
        this.grau = grau;
        this.idUsuario = idUsuario;
        this.idProdutoUsuario = idProdutoUsuario;
        this.idAlergia = idAlergia;
    }

    public String getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(String dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProdutoUsuario() {
        return idProdutoUsuario;
    }

    public void setIdProdutoUsuario(int idProdutoUsuario) {
        this.idProdutoUsuario = idProdutoUsuario;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    @Override
    public String toString() {
        return "Id ProdutoUsuário: " + getIdProdutoUsuario() + "\n" +
                "Data Registro: " + getDtRegistro() + "\n" +
                "Grau: " + getGrau() + "\n" +
                "Id Usuário: " + getIdUsuario() + "\n" +
                "Id Alergia: " + getIdAlergia() + "\n";
    }
}
