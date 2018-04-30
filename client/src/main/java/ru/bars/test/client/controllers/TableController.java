package ru.bars.test.client.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.bars.test.client.dto.Person;

import java.util.List;


public class TableController {

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

    public void initialize() {
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        patronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
    }

    public void fillTable(List<Person> data) {
        personTable.setItems(FXCollections.observableArrayList(data));
    }
}
