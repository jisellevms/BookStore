package br.jisellemartins.infnet.bookstore.model.domain;

public class Produto {
    private int codigo;
    private String descricao;
    private float preco;
    private boolean estoque;
    private String titulo;
    private int qtdPaginas;

    @Override
    public String toString() {
        return String.format("%d - %s - %s - R$ %.2f - Estoque: %s  - %d páginas",codigo, titulo, descricao, preco, estoque? "Sim":"Não", qtdPaginas);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }
}
