package ru.bars.test.client.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import ru.bars.test.client.controllers.MainViewController;
import ru.bars.test.client.dto.Person;
import ru.bars.test.client.services.RestDataService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager {
    //@Autowired
    //но тогда еще и Scene пытается инжектить
    private RestDataService dataService;
    //кеш
    private List<Person> cache = new ArrayList<>();

    private Scene scene;
    public LoginManager(Scene scene){
        this.scene = scene;
    }

    public void setDataService(RestDataService dataService) {
        this.dataService = dataService;
    }

    public void getData(String user, String password){
        System.out.println(dataService.getClass().getSimpleName());
        List<Person> intermediate = dataService.getData(user, password);
        cache.addAll(intermediate);
        showMainView();
    }

    public void save(Person person){
        dataService.save(person);
        cache.add(person);
        showMainView();
    }

    private void showMainView(){
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/fxml/main.fxml"));
            scene.setRoot(loader.load());
            MainViewController controller = loader.getController();
            controller.setLoginManager(this);
            controller.fillTable(cache);
        } catch (IOException e) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
