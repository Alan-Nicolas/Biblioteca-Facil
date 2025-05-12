package com.example.gerenciador;

public class tableEmprestimos {
    private long cod;
    private String titulo;
    private Pessoa pessoa;


    public tableEmprestimos(long cod, String titulo, Pessoa pessoa) {
        this.cod = cod;
        this.titulo = titulo;
        this.pessoa = pessoa;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }





}
