package com.example.gerenciador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerEmprestimo {

    @FXML
    private TextField CodF;

    @FXML
    private TextField cpfF;

    @FXML
    private TextField userF;

    Map<String, Pessoa> pessoaEmprestimo = new HashMap<>();

    private Stage stage;

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

    @FXML
    public void adicionar () {
        String nome = userF.getText();
        String cpf = cpfF.getText();
        String cod = CodF.getText();


        pessoaEmprestimo.put(cod, new Pessoa(nome, cpf) );

        String pessoaEmprestou = "Nome: "+nome+
                                 " CPF: "+cpf+
                                 " codigo livro: "+cod;
        userF.clear();
        cpfF.clear();
        CodF.clear();
        System.out.println(pessoaEmprestou);
    }
}
