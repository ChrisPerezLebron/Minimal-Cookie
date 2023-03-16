package dev.chrisperezlebron.cookieclicker;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
@SpringBootApplication
public class CookieApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(CookieApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cookie.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(rootNode));
        stage.show();

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(CookieApplication.class.getResource("cookie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 757, 544);
        stage.setTitle("Cookie!");
        stage.setScene(scene);


        stage.show();

        */
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }

    public static void main(String[] args) {
        Application.launch(args);
        //launch();
    }
}