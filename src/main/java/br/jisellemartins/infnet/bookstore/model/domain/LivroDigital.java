package br.jisellemartins.infnet.bookstore.model.domain;

public class LivroDigital extends Produto {
    private int tamanho;
    private String formato;

    @Override
    public String toString() {
        return String.format("%s - %d KB - %s", super.toString(), tamanho, formato);
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
