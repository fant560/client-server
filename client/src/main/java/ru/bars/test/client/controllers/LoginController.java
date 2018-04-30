package ru.bars.test.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bars.test.client.utils.LoginManager;

public class LoginController {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    //зачем??
    public void initialize(){}

    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction(event -> loginManager.getData(userName.getText(), password.getText()));
    }

}
