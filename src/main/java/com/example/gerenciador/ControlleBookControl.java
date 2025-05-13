package com.example.gerenciador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlleBookControl {

    @FXML
    private TableView<Livros> tableView;
    @FXML
    private TableColumn<Livros,String > codLivro;

    @FXML
    private TableColumn<Livros, String > tituloLivro;

    @FXML
    private TableColumn<Livros, String> nomeAluno;

    @FXML
    private TableColumn<Livros, String > matricula;
    private Stage stage;
    ObservableList<Livros> lista = FXCollections.observableArrayList();


    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Controle de Livro");
    }
    @FXML
    public void initialize(){
        codLivro.setCellValueFactory((new PropertyValueFactory<>("codLivro")));
        tituloLivro.setCellValueFactory((new PropertyValueFactory<>("tituloLivro")));
        nomeAluno.setCellValueFactory((new PropertyValueFactory<>("nomeAluno")));
        matricula.setCellValueFactory((new PropertyValueFactory<>("matricula")));

        tableView.setItems(lista);
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

}
