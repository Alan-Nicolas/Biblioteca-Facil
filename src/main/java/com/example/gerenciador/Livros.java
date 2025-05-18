package com.example.gerenciador;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Livros {
    private StringProperty titulo;
    private StringProperty autor;
    private StringProperty cod;


    public Livros(String titulo, String autor, String cod) {
        this.titulo = new SimpleStringProperty(titulo);
        this.autor = new SimpleStringProperty(autor);
        this.cod = new SimpleStringProperty(cod);
    }

    public StringProperty tituloProperty() {
        return titulo;
    }
    public StringProperty autorProperty() {
        return autor;
    }
    public StringProperty codProperty() {
        return cod;
    }


    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    public void setAutor(String autor) {
        this.autor.set(autor);
    }

    public void setCod(String cod) {
        this.cod.set(cod);
    }

    public String getTitulo() {
        return titulo.get();
    }

    public String getAutor() {
        return autor.get();
    }

    public String getCod() {
        return cod.get();
    }

    @Override
    public String toString() {
        return titulo.get();
    }
}
