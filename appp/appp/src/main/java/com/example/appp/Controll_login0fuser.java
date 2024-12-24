package com.example.appp;

import Services.Client_services;
import Services.first_screen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controll_login0fuser {

    private Stage stage;
    private Scene scene;
    @FXML
    private TextField user_mail;
    @FXML
    private PasswordField user_password;

    private static String mail0fuser;
    private static String password0fuser;
    public static void setMail0fuser(String mail){
        mail0fuser=mail;
    }
    public static String getMail0fuser(){
        return mail0fuser;
    }
    public static void setPassword0fuser(String pass){
        password0fuser=pass;
    }
    public static String getPassword0fuser(){
        return password0fuser;
    }


    public void goToMain_screen0fuser(javafx.event.ActionEvent actionEvent) throws IOException{

        setMail0fuser(user_mail.getText());
        setPassword0fuser(user_password.getText());
        first_screen.setnumber(1);
        first_screen.setline(2);
        first_screen.start();
        if (mail0fuser.isEmpty()|| ! Client_services.getUsercheck() ){
            //System.out.println("nop nop");
            user_mail.setStyle("-fx-border-color: red;");
            user_password.setStyle("-fx-border-color: red;");
            showAlert("you do not have account here as User", "Please enter a valid mail and password ");
        }
        else {

            user_mail.setStyle("-fx-border-color: green;");
            user_password.setStyle("-fx-border-color: green;");
        }
 if (!mail0fuser.isEmpty()&& Client_services.getUsercheck())   {
     String css= this.getClass().getResource("/css.css").toExternalForm();
     Parent root= FXMLLoader.load((getClass().getResource("mainScreen0fUser.fxml")));
     stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
     scene=new Scene(root);
     scene.getStylesheets().add(css);
     stage.setScene(scene);
 }
    }




















    public void backt0_user_screen(javafx.event.ActionEvent actionEvent) throws IOException {
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
     first_screen.setnumber(0);
     first_screen.setline(0);
     first_screen.start();
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
