package br.jisellemartins.infnet.bookstore.model.domain;

public class LivroFisico extends Produto{
    private float peso;
    private String tipoCapa;


    @Override
    public String toString() {
        return String.format("%s - %.1f gramas - %s", super.toString(), peso, tipoCapa);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTipoCapa() {
        return tipoCapa;
    }

    public void setTipoCapa(String tipoCapa) {
        this.tipoCapa = tipoCapa;
    }
}
