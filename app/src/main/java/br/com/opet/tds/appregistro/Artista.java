package br.com.opet.tds.appregistro;

/**
 * Created by Diego on 19/09/2018.
 */

public class Artista {
    private String nome;
    private String genero;

    public Artista(){}

    public Artista(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
