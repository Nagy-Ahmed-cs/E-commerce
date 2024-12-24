package com.example.appp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Services.first_screen;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import Services.first_screen;
import Services.Client_services;

public class Controll {


    private Stage stage;
    private Scene scene;
    private Parent root;




    public void first_screen(javafx.event.ActionEvent actionEvent) throws IOException {
        first_screen.setnumber(0);
        String css= this.getClass().getResource("/css.css").toExternalForm();

        Parent root= FXMLLoader.load((getClass().getResource("first.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }

    public void admin_screen(javafx.event.ActionEvent actionEvent) throws IOException {
        first_screen.setline(1);

        String css= this.getClass().getResource("/css.css").toExternalForm();

        Parent root= FXMLLoader.load((getClass().getResource("admin_screen.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();


        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }


    public void user_screen(javafx.event.ActionEvent actionEvent) throws IOException {
        first_screen.setline(2);
        first_screen.start();

        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("user_screen.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }

    public void exit(javafx.event.ActionEvent actionEvent) throws IOException{
        first_screen.getDatabase().exist(first_screen.getMy_customer(),first_screen.getMy_admin(),first_screen.getMy_product());
        Platform.exit();

    }
    public void login_user_screen(javafx.event.ActionEvent actionEvent) throws IOException {
        first_screen.setline(2);


        String css= this.getClass().getResource("/css.css").toExternalForm();

        Parent root= FXMLLoader.load((getClass().getResource("login_user.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        first_screen.start();
    }
    public void signup_user_screen(javafx.event.ActionEvent actionEvent) throws IOException {
        first_screen.setnumber(2);
        String css= this.getClass().getResource("/css.css").toExternalForm();

        Parent root= FXMLLoader.load((getClass().getResource("signup_screen.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }







}
