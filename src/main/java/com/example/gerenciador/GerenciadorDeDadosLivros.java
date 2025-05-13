package com.example.gerenciador;

import java.util.HashSet;
import java.util.Set;

public class GerenciadorDeDadosLivros {
    private static GerenciadorDeDadosLivros instance;
    private Set<Livros> livrosCadastrados = new HashSet<>();

    private GerenciadorDeDadosLivros () {
        livrosCadastrados = new HashSet<>();
    }

    public static GerenciadorDeDadosLivros getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeDadosLivros();
        }
        return instance;
    }

    public void adicionarLivros(Livros livros) {
        livrosCadastrados.add(livros);
    }

    public Set<Livros> getLivrosCadastrados () {
        return new HashSet<>(livrosCadastrados);
    }

    public Livros buscarPorCodigo (String codLivro) {
        return livrosCadastrados.stream()
                .filter(livros -> livros.getCod().equals(codLivro))
                .findFirst()
                .orElse(null);
    }
}
