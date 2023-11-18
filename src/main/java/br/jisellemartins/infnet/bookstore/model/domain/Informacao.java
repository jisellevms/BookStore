package br.jisellemartins.infnet.bookstore.model.domain;

public class Informacao {
    private Integer id;
    private String campo;
    private String descricao;

    @Override
    public String toString() {
        return String.format("%d - %s - %s", id, campo, descricao);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
