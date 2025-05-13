package com.example.gerenciador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    private GerenciadorDeDados gerenciador = GerenciadorDeDados.getInstance();



    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Cadastro de Usuario");
    }


    public void adicionar () throws IOException {
        String nome = nomeF.getText();
        String cpf = cpfF.getText();
        String tel = telF.getText();
        String email = emailF.getText();

        Pessoa pessoaNova = new Pessoa(nome, cpf, tel, email);
        gerenciador.adicionarPessoa(pessoaNova);

        nomeF.clear();
        cpfF.clear();
        telF.clear();
        emailF.clear();
        alertaCadastro();
    }

    private void alertaCadastro () {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Cadastro concluido");
        alert.setContentText("cadastro realizado com sucesso");
        alert.setOnCloseRequest(e -> {
            try {
                voltarMenu();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        alert.show();
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






