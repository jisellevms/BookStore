package br.jisellemartins.infnet.bookstore.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TLivroFisico")
public class LivroFisico extends Produto{
    private float peso;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Capa Comum'")
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
