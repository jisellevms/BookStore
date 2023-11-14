package br.jisellemartins.infnet.bookstore.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TLivroDigital")
public class LivroDigital extends Produto {
    private int tamanho;
    @Size(min = 2, max = 100, message = "O formato deve ter entre {min} e {max} caracteres.")
    @NotNull
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'epub'")
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
