package ru.bars.test.client.application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import ru.bars.test.client.services.RestDataService;
import ru.bars.test.client.utils.LoginManager;

@SpringBootApplication
@ComponentScan("ru.bars.test.client")
public class Application extends ClientApplication{
    /**
     * Сначала поднимается контекст спринговый, потом запуск основного потока клиентского приложения
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new StackPane());
        LoginManager loginManager = new LoginManager(scene);
        loginManager.setDataService(context.getBean(RestDataService.class));
        loginManager.showLoginScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
