package com.umss.buscaminas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("buscaminas_view.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Buscaminas.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Buscaminas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}