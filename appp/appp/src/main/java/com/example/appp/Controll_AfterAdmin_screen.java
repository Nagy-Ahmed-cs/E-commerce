package com.example.appp;

import Entity.Customer;
import Entity.gender;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Services.Admin_services;
import Services.first_screen;
import java.io.IOException;
import java.util.ArrayList;

public class Controll_AfterAdmin_screen {
    @FXML
    private AnchorPane clients;
    @FXML
    private TextField admin_mail;
    @FXML
    private PasswordField admin_password;
    private Stage stage;
    private Scene scene;

    private static String mail0fadmin;
    private static String password0fadmin;
    public static void setMail0fadmin(String mail){
        mail0fadmin=mail;
    }
    public static String getMail0fadmin(){
        return mail0fadmin;
    }
    public static void setPassword0fadmin(String pass){
        password0fadmin=pass;
    }
    public static String getPassword0fadmin(){
        return password0fadmin;
    }

    public void go_toMain_screenof_admin(javafx.event.ActionEvent actionEvent) throws IOException{
       // String css= this.getClass().getResource("/css.css").toExternalForm();
        setMail0fadmin(admin_mail.getText());
        setPassword0fadmin(admin_password.getText());
        first_screen.setline(1);
        first_screen.start();
        if (mail0fadmin.isEmpty()||!Admin_services.getAdmincheck()) {
            admin_mail.setStyle("-fx-border-color: red;");
            admin_password.setStyle("-fx-border-color: red;");
            showAlert("you do not have account here as ADMIN", "Please enter a valid mail and password ");

        } else if(Admin_services.getAdmincheck()){
            admin_mail.setStyle("-fx-border-color: green;");
            admin_password.setStyle("-fx-border-color: green;");
            String css= this.getClass().getResource("/css.css").toExternalForm();

            Parent root= FXMLLoader.load((getClass().getResource("main_screen0fAdmin.fxml")));
            stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            scene=new Scene(root);
            scene.getStylesheets().add(css);
            stage.setScene(scene);

        }


    }
    public void gotofirst_screen(javafx.event.ActionEvent actionEvent) throws IOException {
       first_screen.setline(1);
        Admin_services.setValue(0);
        first_screen.start();
        String css= this.getClass().getResource("/css.css").toExternalForm();

        Parent root= FXMLLoader.load((getClass().getResource("first.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
    public void exit(javafx.event.ActionEvent actionEvent) throws IOException{
        first_screen.getDatabase().exist(first_screen.getMy_customer(),first_screen.getMy_admin(),first_screen.getMy_product());
        Platform.exit();

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);

        alert.setContentText(message);
        alert.showAndWait();
    }


}
