package com.example.gerenciador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerCadastroDeUsuario {
    private Stage stage;
    @FXML
    private TextField nomeF;
    @FXML
    private TextField cpfF;
    @FXML
    private TextField telF;
    @FXML
    private TextField emailF;
    private ControllerListaDeUsuarios controllerListaDeUsuarios;

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setTitle("Gerencimento de Usuario");
    }

    @FXML
    private void voltarMenu () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        MenuController controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu");
    }

    public void adicionar () throws IOException {

        String nome = nomeF.getText();
        String cpf = cpfF.getText();
        String tel = telF.getText();
        String email = emailF.getText();

        if(!nome.isEmpty() && !cpf.isEmpty() && !tel.isEmpty() && !email.isEmpty()) {
            Usuario usuario = new Usuario(nome, cpf, tel, email);
            UsuarioManager.getInstance().adicionarUsuario(usuario);

            limparCampos();
            alertaCadastro();
        }
    }

    @FXML
    private void atualizarPorCpf () {
        String buscaCpf = cpfF.getText();
        int index = UsuarioManager.getInstance().buscarUsuarioPorCpf(buscaCpf);


        if (index >= 0) {
            Usuario usuarioAtu = new Usuario(nomeF.getText(), cpfF.getText(),telF.getText(), emailF.getText());
            UsuarioManager.getInstance().atualizarUsuario(index,usuarioAtu);

            limparCampos();
        } else {
            alertaCpfNEcontrado();
        }

    }

    @FXML
    private void deletarPorCpf () {
        String buscaCpf = cpfF.getText();

        if (!buscaCpf.isEmpty()) {
            UsuarioManager.getInstance().deletarUsuarioPorCpf(buscaCpf);

            alertaUserDeleter();

            limparCampos();
        } else {
            alertaCpfNEcontrado();
        }
    }

    @FXML
    private void listar () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("usuarios.fxml"));
        Parent root = loader.load();

        ControllerListaDeUsuarios controller = loader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void alertaCadastro () {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Cadastro concluido");
        alert.setContentText("cadastro realizado com sucesso");
        alert.setOnCloseRequest(e -> {
            try {
                voltarMenu();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        alert.show();
    }

    private void alertaCpfNEcontrado () {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CPF INCORRETO");
        alert.setHeaderText("o Cpf nao encontrado");
        alert.setContentText("Digite um cpf correto!");
        alert.show();
    }

    private void alertaUserDeleter () {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("USUARIO EXCLUIDO");
        alert.setHeaderText("Usuario excluido com sucesso!");
        alert.setContentText("o user com o CPF: "+cpfF.getText()+"foi excluido!");
    }

    private void limparCampos () {
        nomeF.clear();
        cpfF.clear();
        telF.clear();
        emailF.clear();
    }
}






