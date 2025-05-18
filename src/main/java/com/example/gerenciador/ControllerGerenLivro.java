package com.example.gerenciador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerGerenLivro {
    @FXML
    private TextField titleF;
    @FXML
    private TextField autorF;

    @FXML
    private TextField codF;


    private Stage stage;


    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Gerenciamento de Livro");
    }

    @FXML
    private void voltarParaMenu () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        MenuController controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu");

    }


    public void adicionarLivro(){
        String titulo = titleF.getText();
        String autor = autorF.getText();
        String codigo = codF.getText();

        if(!titulo.isEmpty() && !autor.isEmpty() && !codigo.isEmpty()) {
            LivroManager.getInstance().adicionarLivro(new Livros(titulo, autor, codigo));

            limparCampos();
        }


    }

    @FXML
    private void listarLivro () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("livros.fxml"));
        Parent root = loader.load();

        ControllerTableLivro controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);


    }

    private void limparCampos() {
        titleF.clear();
        autorF.clear();
        codF.clear();
        alertaLivroCadastrado();
    }
    private void alertaLivroCadastrado() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Concluido");
        alert.setHeaderText("Livro Cadastrado");
        alert.setContentText("Livro Cadastrado com sucesso!");
        alert.show();
    }




}
