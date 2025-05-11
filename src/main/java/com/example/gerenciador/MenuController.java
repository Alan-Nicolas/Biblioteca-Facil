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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastro-usuario.fxml"));
        Parent root = fxmlLoader.load();

        ControllerCadastroDeUsuario controller = fxmlLoader.getController();
        controller.setStage(stage);

        Scene sceneCadastro = new Scene(root);
        stage.setScene(sceneCadastro);

    }


}
