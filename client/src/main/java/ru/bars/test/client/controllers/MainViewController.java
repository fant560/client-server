package ru.bars.test.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ru.bars.test.client.utils.LoginManager;

public class MainViewController {

    @FXML
    private Button logoutButton;
    @FXML
    private Label sessionLabel;

    public void initialize(){}

    public void initSessionID(final LoginManager loginManager, String sessionId){
        sessionLabel.setText(sessionId);
        logoutButton.setOnAction(event -> loginManager.logout());
    }



}
