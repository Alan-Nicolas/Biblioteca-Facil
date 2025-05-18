package com.example.gerenciador;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerTableLivro {
    @FXML
    private TableView<Livros> tableView;
    @FXML
    private TableColumn<Livros, String> tituloLivro;
    @FXML
    private TableColumn<Livros, String> autorLivro;
    @FXML
    private TableColumn<Livros, String> codLivro;


    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("table livro");
    }

    @FXML
    public void initialize() {
       codLivro.setCellValueFactory(cellData -> cellData.getValue().codProperty());
       tituloLivro.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
       autorLivro.setCellValueFactory(cellData -> cellData.getValue().autorProperty());

       tableView.setItems(LivroManager.getInstance().getLivros());
    }

    @FXML
    private void voltarCadastroLivro () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gerenciamento-livro.fxml"));
        Parent root = loader.load();
        ControllerGerenLivro controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
