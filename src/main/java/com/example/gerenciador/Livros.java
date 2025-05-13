package com.example.gerenciador;

public class Livros {
    private String cod;
    private String titulo;


    public Livros(String cod) {
        this.cod = cod;


    }

    public Livros(String cod, String titulo) {
        this.cod = cod;
        this.titulo = titulo;

    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }





}
