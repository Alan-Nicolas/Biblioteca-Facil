package com.example.gerenciador;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerListaDeUsuarios {
    @FXML
    private TableView<Usuario> tableView;
    @FXML
    private TableColumn<Usuario, String> cpfTab;

    @FXML
    private TableColumn<Usuario, String> emailTab;

    @FXML
    private TableColumn<Usuario, String> nomeTab;

    @FXML
    private TableColumn<Usuario, String> telTab;

    private Stage stage;


    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Lista de Usuariosd");
    }

    @FXML
    public void initialize () {
        nomeTab.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        cpfTab.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
        telTab.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTel()));
        emailTab.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));


        tableView.setItems(UsuarioManager.getInstance().getUsuarios());


    }

    public void atualizarTabela() {
        tableView.refresh();
    }

    @FXML
    private void voltarCadastro () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro-usuarios.fxml"));
        Parent root = loader.load();

        ControllerCadastroDeUsuario controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
