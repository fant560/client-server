package ru.bars.test.client.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bars.test.client.controllers.LoginController;
import ru.bars.test.client.controllers.TableController;
import ru.bars.test.client.dto.Person;
import ru.bars.test.client.services.RestDataService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager {

    @Autowired
    private RestDataService dataService;

    private Scene scene;

    public LoginManager(Scene scene){
        this.scene = scene;
    }

    public void getData(String user, String password){
        List<Person> intermediate = dataService.getData(user, password.hashCode());
        if (intermediate.isEmpty())
            showLoginScreen();
        else showMainView(intermediate);
    }


    public void logout(){
        showLoginScreen();
    }

    public void showLoginScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/login.fxml"));
            scene.setRoot(loader.load());
            LoginController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException e) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    private void showMainView(List<Person> data){
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/fxml/table.fxml"));
            scene.setRoot(loader.load());
            TableController controller = loader.getController();
            controller.fillTable(data);
        } catch (IOException e) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
