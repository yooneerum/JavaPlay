package com.example.halligalli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HalliGalliApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HalliGalliApplication.class.getResource("halligalliMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 850);
        stage.setTitle("Halli Galli");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}