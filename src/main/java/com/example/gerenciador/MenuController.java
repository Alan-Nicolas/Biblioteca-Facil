package com.example.gerenciador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void irParaCadastro () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastro-usuarios.fxml"));
        Parent root = fxmlLoader.load();

        ControllerCadastroDeUsuario controller = fxmlLoader.getController();
        controller.setStage(stage);

        Scene sceneCadastro = new Scene(root);
        stage.setScene(sceneCadastro);

    }

    @FXML
    private void irParaControleDeLivro () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("controle-de-livro.fxml"));
        Parent root = loader.load();

        ControlleBookControl control = loader.getController();
        control.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void irParaEmprestimo () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("emprestimo-livro.fxml"));
        Parent root = loader.load();

        ControllerEmprestimo controller = loader.getController();
        controller.setStage(stage);


        Scene scene = new Scene(root);
        stage.setScene(scene);
    }


}
