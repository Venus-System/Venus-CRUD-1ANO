package com.exemplo.model;

public class IngredienteAnalise {
    private int idIngredienteAnalise;
    private int idIngrediente;

    public IngredienteAnalise(int idIngredienteAnalise, int idIngrediente) {
        this.idIngredienteAnalise = idIngredienteAnalise;
        this.idIngrediente = idIngrediente;
    }

    public int getIdIngredienteAnalise() {
        return idIngredienteAnalise;
    }

    public void setIdIngredienteAnalise(int idIngredienteAnalise) {
        this.idIngredienteAnalise = idIngredienteAnalise;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    @Override
    public String toString() {
        return "Id IngredienteAnálise: " + getIdIngredienteAnalise() + "\n" +
                "Id Ingrediente: " + getIdIngrediente() + "\n";
    }
}