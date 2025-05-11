package com.example.gerenciador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        MenuController controller = loader.getController();
        controller.setStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Menu");

    }

    public static void main(String[] args) {
        launch(args);
    }

}
