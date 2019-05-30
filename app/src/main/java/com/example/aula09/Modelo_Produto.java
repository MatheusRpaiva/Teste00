package com.example.aula09;

public class Modelo_Produto {

    private double descontoPromocao;
    private String descProduto;
    private double precProduto;
    private int idProduto;
    private String nomeProduto;
    private int idCategorita;
    private boolean ativoProduto;

    public double getDescontoPromocao() {
        return descontoPromocao;
    }

    public void setDescontoPromocao(double descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }

        public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public double getPrecProduto() {
        return precProduto;
    }

    public void setPrecProduto(double precProduto) {
        this.precProduto = precProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getIdCategorita() {
        return idCategorita;
    }

    public void setIdCategorita(int idCategorita) {
        this.idCategorita = idCategorita;
    }

    public boolean isAtivoProduto() {
        return ativoProduto;
    }

    public void setAtivoProduto(boolean ativoProduto) {
        this.ativoProduto = ativoProduto;
    }
}
