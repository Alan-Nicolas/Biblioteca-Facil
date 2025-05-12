package com.example.gerenciador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.HashSet;

import java.util.Set;

public class ControllerCadastroDeUsuario {
    private Stage stage;
    @FXML
    private TextField nomeF;
    @FXML
    private TextField cpfF;
    @FXML
    private TextField telF;
    @FXML
    private TextField emailF;

    Set<Pessoa> listPessoa = new HashSet<>();



    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Cadastro de Usuario");
    }

    //quando no botao adiconar
    public void adicionar () {
        String nome = nomeF.getText();
        String cpf = cpfF.getText();
        String tel = telF.getText();
        String email = emailF.getText();


        listPessoa.add(new Pessoa(nome, cpf, tel, email));

        String pessoaAdicionada = "nome: "+nome+
                                    " cpf: "+ cpf+
                                    " telefone: "+tel+
                                    " email: "+email;

        nomeF.clear();
        cpfF.clear();
        telF.clear();
        emailF.clear();
        System.out.println(pessoaAdicionada);
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("emprestimo-livro.fxml"));
            Parent root = loader.load();

            ControllerEmprestimo controller = loader.getController();

        } ch*/
    }

    @FXML
    private void voltarMenu () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        MenuController controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu");
    }


}






