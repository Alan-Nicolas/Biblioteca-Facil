package com.example.gerenciador;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
    private StringProperty nome;
    private StringProperty cpf;
    private StringProperty tel;
    private StringProperty email;

    public Usuario(String nome, String cpf, String tel, String email) {
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.tel = new SimpleStringProperty(tel);
        this.email = new SimpleStringProperty(email);
    }

    @Override
    public String toString() {
        return nome.get();
    }

    public StringProperty nomeProperty () {
        return nome;
   }
   public StringProperty cpfProperty () {
        return cpf;
   }
   public StringProperty telProperty () {
        return tel;
   }
   public StringProperty emailProperty () {
        return email;
   }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCpf() {
        return cpf.get();
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
