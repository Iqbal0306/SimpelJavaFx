package com.mavenproject3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class LoginController {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML
    private Label lblMessage;
    @FXML
    private Button btnLogin;

    @FXML
    private void login(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if ("admin".equals(username) && "123".equals(password)) {
            lblMessage.setText("Login berhasil!");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mavenproject3/test.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) txtUsername.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Aplikasi Buah");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            lblMessage.setText("Username atau password salah!");
        }
    }
}

