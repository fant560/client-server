package ru.bars.test.client.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.bars.test.client.dto.Person;
import ru.bars.test.client.utils.LoginManager;

import java.util.List;

/**
 * Главный view
 */
public class MainViewController {

    @FXML
    private Button logoutButton;
    @FXML
    private TableColumn<String, Person> firstname;
    @FXML
    private TableColumn<String, Person> lastname;
    @FXML
    private TableColumn<String, Person> patronymic;
    @FXML
    private TableColumn<String, Person> position;
    @FXML
    private TableView<Person> personTable;

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button addButton;
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField patr;
    @FXML
    private TextField pos;


    private LoginManager loginManager;


    public void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public void initialize() {
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        patronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        position.setCellValueFactory(new PropertyValueFactory<>("position"));

        loginButton.setOnAction(event -> loginManager.getData(userName.getText(), password.getText()));
        //TODO очистить таблицу
        logoutButton.setOnAction(event -> {});
        addButton.setOnAction(event -> loginManager.save(new Person(first.getText(), last.getText(), patr.getText(), pos.getText())));
    }

    public void fillTable(List<Person> data) {
        personTable.setItems(FXCollections.observableArrayList(data));
    }



}
