package com.talesparisotto.javapop.model;

public class Repositorio {
    private String nome;
    private String descricao;
    private int fork;
    private int strela;
    private String imagemPerfil;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFork() {
        return fork;
    }

    public void setFork(int fork) {
        this.fork = fork;
    }

    public int getStrela() {
        return strela;
    }

    public void setStrela(int strela) {
        this.strela = strela;
    }

    public String getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }
}
