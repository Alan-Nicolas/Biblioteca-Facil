package com.example.gerenciador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerEmprestimo {

    @FXML
    private DatePicker dataEntrega;

    @FXML
    private DatePicker dataRetirada;

    @FXML
    private ComboBox<Livros> livrosEmprestimo;

    @FXML
    private ComboBox<Usuario> nomeList;


    private Stage stage;

    public void initialize () {
        nomeList.setItems(UsuarioManager.getInstance().getUsuarios());
        livrosEmprestimo.setItems(LivroManager.getInstance().getLivros());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Emprestimo de Livro");
    }

    @FXML
    private void voltarParaMenu () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        MenuController controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }



}
