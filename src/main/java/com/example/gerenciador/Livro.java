package com.example.gerenciador;

import javafx.stage.Stage;

public class Livro {
    private long cod;
    private String titulo;
    private String autor;
    private String editora;
    private boolean emprestado;

    public Livro(long cod, String titulo, String autor, String editora, boolean emprestado) {
        this.cod = cod;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.emprestado = emprestado;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
