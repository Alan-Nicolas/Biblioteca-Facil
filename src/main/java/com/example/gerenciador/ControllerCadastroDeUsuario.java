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
    private TextField matriculaF;

    Set<Pessoa> listPessoa = new HashSet<>();



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //quando no botao adiconar
    public void adicionar () {
        String nome = nomeF.getText();
        String matricula = matriculaF.getText();

        listPessoa.add(new Pessoa(nome, matricula));

        String pessoaAdicionada = "nome: "+nome+ " matricula: "+matricula;

        nomeF.clear();
        matriculaF.clear();
        System.out.println(pessoaAdicionada);
    }

    @FXML
    private void voltarMenu () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        MenuController controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }


}






