package com.example.gerenciador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsuarioManager {
    private static UsuarioManager instancia;
    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

    private UsuarioManager () {
        usuarios.add(new Usuario("Alan", "00450565289", "92 992863593", "alanicolax@gmail.com"));
        usuarios.add(new Usuario("Nicolas", "83526738965", "92 992863593", "nicolas@gmail.com"));
        usuarios.add(new Usuario("Mateus", "12345678910", "92 992863593", "mateus@gmail.com"));
        usuarios.add(new Usuario("Paulo", "87654321901", "92 992863593", "paulo@gmail.com"));
        usuarios.add(new Usuario("Marcos", "76387364723", "92 992863593", "marcos@gmail.com"));
    }

    public static UsuarioManager getInstance() {
        if (instancia == null) {
            instancia = new UsuarioManager();
        }
        return instancia;
    }


    public ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void atualizarUsuario (int index, Usuario usuario) {
        if (index >= 0 && index < usuarios.size()) {
        usuarios.set(index, usuario);
        }
    }

    public int buscarUsuarioPorCpf(String cpf) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

    public void deletarUsuarioPorCpf(String cpf) {
        usuarios.removeIf(usuario -> usuario.getCpf().equals(cpf));
    }

}
