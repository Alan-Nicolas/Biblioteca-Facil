package com.example.gerenciador;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LivroManager {
    private static LivroManager instancia;
    private final ObservableList<Livros> livros = FXCollections.observableArrayList();

    private LivroManager () {
        livros.add(new Livros("O Enigma das Sombras", "Carlos Vendetta", "1"));

    }
    public static LivroManager getInstance() {
        if (instancia == null) {
            instancia = new LivroManager();
        }
        return instancia;
    }

    public ObservableList<Livros> getLivros() {
        return livros;
    }

    public void adicionarLivro(Livros l) {
        livros.add(l);
    }
}


