package com.example.gerenciador;

import java.util.HashSet;
import java.util.Set;

public class GerenciadorDeDados {
    private static GerenciadorDeDados instance;
    private Set<Pessoa> pessoasCadastradas;

    private GerenciadorDeDados () {
        pessoasCadastradas = new HashSet<>();

    }

    public static GerenciadorDeDados getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeDados();
        }
        return instance;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoasCadastradas.add(pessoa);
    }
    public Set<Pessoa> getPessoasCadastradas () {
        return new HashSet<>(pessoasCadastradas);
    }

    public Pessoa buscarPorCpf(String cpf) {
        return pessoasCadastradas.stream()
                .filter(pessoa -> pessoa.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

}
