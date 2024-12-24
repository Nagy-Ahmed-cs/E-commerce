package com.example.appp;


import DAO.customer_DAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import Services.first_screen;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Controll_sign_screen {

    @FXML
  private  TextField name1;
    @FXML
  private PasswordField password;
    @FXML
    private TextField address;
    @FXML
  private  PasswordField co_password;
    @FXML
private   TextField mail;
    @FXML
  private    TextField interest;
    @FXML
 private    TextField balance;
    @FXML
  private  DatePicker date;
    @FXML
    private RadioButton male;
    @FXML
    private  RadioButton female;
    @FXML
    ToggleGroup toggleGroup = new ToggleGroup();


    private Stage stage;
    private Scene scene;
    private static String name;
    private static String mail1;
    private static  String pass;
    private static  String addres;
    private static  String c_pass;
    private static  String inter;
    private static   double balanc;
    private static  String dat;
    private static String gender;
    public static void setGender(String s){
        gender=s;
    }
    public static String getGender(){
        return gender;
    }

    public static void setName(String s){
        name=s;
    }
    public static String getName(){
        return name;
    }
    public static void setmail(String s){
        mail1=s;
    }
    public static String getmail(){
        return mail1;
    }
    public static void setAddres(String s){
        addres=s;
    }
    public static String getAddres(){
        return addres;
    }
    public static void setPass(String s){
        pass=s;
    }
    public static String getPass(){
        return pass;
    }
    public static void setC_pass(String s){
      c_pass=s;
    }
    public static String getC_pass(){
        return c_pass;
    }
    public static void setInter(String s){
        inter=s;
    }
    public static String getInter(){
        return inter;
    }
    public static void setBalanc(String s){
        balanc= Double.parseDouble( s);
    }
    public static double getBalanc(){
        return balanc;
    }
    public static void setDate(String s){
        dat=s;
    }
    public static String getDate(){
        return dat;
    }



    public void start_after_signup(ActionEvent actionEvent) throws IOException {

        setAddres(address.getText());
        LocalDate localDate=date.getValue();
        setBalanc(balance.getText());
        setInter(interest.getText());
        first_screen.setnumber(2);
        first_screen.setline(2);

        if(localDate != null){
            setDate(localDate.toString());
//            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-mm-yyyy");
//            setDate(localDate.format(dateTimeFormatter));
        }
        else {
            date.setStyle("-fx-border-color: red;");
            showAlert("invalid date : ","please chooce date");
        }
        if (male.isSelected() &&!female.isSelected()){
            setGender("male");
        } else if (female.isSelected() &&!male.isSelected()) {
            setGender("female");

        }
        else {
            showAlert("choose gender","not gender choosed");
        }


        if (getGender()!=null&&!(female.isSelected() &&male.isSelected())&&!dat.isEmpty()) {
            showAlert("successful signup","please login now ");
            first_screen.setline(2);


            String css= this.getClass().getResource("/css.css").toExternalForm();

            Parent root= FXMLLoader.load((getClass().getResource("login_user.fxml")));
            stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            scene=new Scene(root);
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            first_screen.start();

}}

    public void op_to_signup(ActionEvent actionEvent) throws IOException {
        boolean f1,f2,f3,f4;
        String css= this.getClass().getResource("/css.css").toExternalForm();

        setName(name1.getText());
        if (name.isEmpty() ) {
            name1.setStyle("-fx-border-color: red;");
            showAlert("Invalid Name", "Please enter a valid name ");
            f1=false;
        } else {
            name1.setStyle("-fx-border-color: green;");
            f1=true;
        }
        setmail(mail.getText());
        if (mail1.isEmpty() ||!(isValidEmail(getmail())) ) {
            mail.setStyle("-fx-border-color: red;");
            showAlert("Invalid Mail ", "Please enter a valid mail :(");
            f2=false;
        } else {
            mail.setStyle("-fx-border-color: green;");
            f2=true;
        }
        setPass(password.getText());
        if (pass.isEmpty() || pass.length()<8) {
            password.setStyle("-fx-border-color: red;");
            showAlert("Invalid Password", "Please enter a valid password contain 8 or more character");
            f3=false;
        } else {
            password.setStyle("-fx-border-color: green;");
            f3=true;
        }
        setC_pass(co_password.getText());
        if (c_pass.isEmpty() || !c_pass.equals(pass)) {
            co_password.setStyle("-fx-border-color: red;");
            showAlert("the password do not match ", "Please enter a the same password that contain 8 or more character");
            f4=false;
        } else {
          co_password.setStyle("-fx-border-color: green;");
            f4=true;
        }
if (f1&&f2&&f3&&f4)
{

        Parent root= FXMLLoader.load((getClass().getResource("op_to_signup.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
}
else {

}
    }


    private boolean isValidEmail(String email) {
        // Define the regex for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }






    public void back_Touser_screen(ActionEvent actionEvent) throws IOException {
        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("user_screen.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
    public void back_Tosignup_user_screen(ActionEvent actionEvent) throws IOException {
        Stage stage1=new Stage();
        String css= this.getClass().getResource("/css.css").toExternalForm();

        Parent root= FXMLLoader.load((getClass().getResource("signup_screen.fxml")));
       stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
//        name1.setText(getName());
//        mail.setText(getmail());
//        password.setText(getPass());
//        co_password.setText(getC_pass());

        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
    public void exit(ActionEvent actionEvent) throws IOException{
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
