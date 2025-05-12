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
    private TableView<tableEmprestimos> tableView;
    @FXML
    private TableColumn<tableEmprestimos,Long > codLivro;

    @FXML
    private TableColumn<tableEmprestimos, String > tituloLivro;

    @FXML
    private TableColumn<tableEmprestimos, String> nomeAluno;

    @FXML
    private TableColumn<tableEmprestimos, String > matricula;
    private Stage stage;
    private Pessoa pessoa;
    ObservableList<tableEmprestimos> lista = FXCollections.observableArrayList();


    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Controle de Livro");
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

    @FXML
    public void initialize() {

        codLivro.setCellValueFactory(new PropertyValueFactory<>("cod"));
        tituloLivro.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        nomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
        matricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));



        String nome = pessoa.getNome();
        String cpf = pessoa.getCpf();
        String tel = pessoa.getTelefone();
        String email = pessoa.getEmail();
        pessoa = new Pessoa(nome, cpf, tel,  email  );

        lista.add(new tableEmprestimos(1, "exemplo1", pessoa ));
        tableView.setItems(lista);

    }
}
