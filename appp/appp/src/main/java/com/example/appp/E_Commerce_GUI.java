package com.example.appp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import Services.first_screen;

public class E_Commerce_GUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        first_screen.start();
       Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first.fxml")));

        String css= this.getClass().getResource("/css.css").toExternalForm();
        Scene scene=new Scene(root);
        Image icon = new Image("icon.png");
        scene.getStylesheets().add(css);

        stage.getIcons().add(icon);

        stage.setTitle("E_Commerce");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }



}