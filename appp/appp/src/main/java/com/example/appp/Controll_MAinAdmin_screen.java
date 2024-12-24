package com.example.appp;

import DAO.product_DAO;
import Entity.Customer;
import Entity.Product;
import Entity.gender;

import Services.Admin_services;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.first_screen;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controll_MAinAdmin_screen {
   @FXML
    private TableView<Customer> tableView;
    @FXML

    private TextField product_name;
    @FXML
    private TableView<Product> tableView2;
    @FXML
private static TableColumn<Customer, String> c1;
    @FXML
    private static TableColumn<Customer, String> c2;
    @FXML
    private static TableColumn<Customer, String> c3;
    @FXML
    private static TableColumn<Customer, String> c4;
    @FXML
    private static TableColumn<Customer, String> c8;
    @FXML
    private static TableColumn<Customer, gender> c5;
    @FXML
    private static TableColumn<Customer, ArrayList<String>> c6;
    @FXML
    private static TableColumn<Customer, Double> c7;
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField cat_id;
    @FXML
    private TextField pro_des;
    @FXML
    private TextField pro_price;
    @FXML
    private TextField new_name;
    @FXML
    private TextField new_id;
    @FXML
    private TextField last_id;
    @FXML
    private TextField new_pro_des;
    @FXML
    private TextField new_pro_price;
    @FXML
    private TextField new_cat_id;
    private static String name;
    private static String id;
    private static String des;
    private static Double price;
    private static String name_new;
    private static String id_new;
    private static String id_last;
    private static String pro_des_new;
    private static String cat_pro_id;
    private static Double pro_price_new ;
    public static void setName(String s){
        name=s;
    }
    public static String getName(){
        return name;
    }
    public static void setId(String s){
        id=s;
    }
    public static String getId(){
        return id;
    }
    public static void setDes(String s){
        des=s;
    }
    public static String getDes(){
        return des;
    }
    public static void setprice(String s){
        price= Double.parseDouble(s);
    }
    public static double getPrice(){
        return price;
    }

    public static void setName_new(String d){
        name_new=d;
    }
    public static String getName_new(){
       return name_new;
    }
    public static void setId_last(String s){
        id_last=s;
    }
    public static String getId_last(){
        return id_last;
    }
    public static void setId_new(String s){
        id_new=s;
    }
    public static String getId_new(){
        return id_new;
    }
    public static void setPro_des_new(String g){
        pro_des_new=g;
    }
    public static String getPro_des_new(){
      return  pro_des_new;
    }
    public static void setPro_price_new(String m){
        if (m.isEmpty()){
            pro_price_new =0.0;
        }
        else {
            pro_price_new = Double.parseDouble(m);
        }
    }
    public static double getPro_price_new(){
        return pro_price_new;
    }
    public static void setCat_pro_id(String b){
        cat_pro_id=b;
    }
    public static String getCat_pro_id(){
        return cat_pro_id;
    }


    public void display_clients(javafx.event.ActionEvent actionEvent) throws IOException {

        // Create and populate the ObservableList
        ObservableList<Customer> clientList = FXCollections.observableArrayList(first_screen.getMy_customer());

        // Create a TableView
      tableView = new TableView<Customer>(clientList);

        // Create columns
        c1 = new TableColumn<>("Name");
       c1.setCellValueFactory(new PropertyValueFactory<>("user_name"));

        c2 = new TableColumn<>("Password");
       c2.setCellValueFactory(new PropertyValueFactory<>("pass_word"));

       c3= new TableColumn<>("Date of birth");
       c3.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));

        c4 = new TableColumn<>("Address");
        c4.setCellValueFactory(new PropertyValueFactory<>("address"));

        c8= new TableColumn<>("E-mail");
        c8.setCellValueFactory(new PropertyValueFactory<>("email"));

        c5 = new TableColumn<>("Gender");
       c5.setCellValueFactory(new PropertyValueFactory<>("user_gender"));

       c6= new TableColumn<>("Interest");
        c6.setCellValueFactory(new PropertyValueFactory<>("interest"));

        c7 = new TableColumn<>("Balance");
        c7.setCellValueFactory(new PropertyValueFactory<>("balance"));

        // Add columns to the TableView
        tableView.getColumns().addAll(
             c1,c2,c3,c4,c5,c6,c7,c8
        );


        String css= this.getClass().getResource("/css2.css").toExternalForm();
//
        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 1200, 400);
        Stage stage=new Stage();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Clients Table");
        stage.show();
    }
    public void display_products(javafx.event.ActionEvent actionEvent) throws IOException {

        // Create and populate the ObservableList
        ObservableList<Product> producttList = FXCollections.observableArrayList(first_screen.getMy_product());

        // Create a TableView
        tableView2 = new TableView<Product>(producttList);

        // Create columns
        TableColumn<Product, String> c1 = new TableColumn<>("Name");
        c1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String>c2 = new TableColumn<>("ID");
        c2.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Product, String>c3= new TableColumn<>("Description");
        c3.setCellValueFactory(new PropertyValueFactory<>("description"));


        TableColumn<Product, String>  c8= new TableColumn<>("category_ID");
        c8.setCellValueFactory(new PropertyValueFactory<>("cat_id"));

        TableColumn<Product, Double> c7 = new TableColumn<>("Price");
        c7.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Add columns to the TableView
        tableView2.getColumns().addAll(
                c1,c2,c3,c7,c8
        );


        String css= this.getClass().getResource("/css2.css").toExternalForm();
//
        VBox vbox = new VBox(tableView2);
        Scene scene = new Scene(vbox, 800, 400);
        Stage stage=new Stage();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Product Table");
        stage.show();
    }
    public void createProduct(javafx.event.ActionEvent actionEvent) throws IOException{
        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("createProduct_screen.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }

    public void con_createProduct(javafx.event.ActionEvent actionEvent) throws IOException{
        setName(product_name.getText());
        setId(cat_id.getText());
        setDes(pro_des.getText());
        setprice(pro_price.getText());
        first_screen.setline(1);
        Admin_services.setValue(4);
        first_screen.start();
        showAlert("successful","you create new product with name : "+getName());
        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("main_screen0fAdmin.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        first_screen.setline(1);
        Admin_services.setValue(0);
        first_screen.start();

    }
    public void updateProduct(javafx.event.ActionEvent actionEvent) throws IOException{
        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("updateProduct_screen.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
    public void con_updateProduct(javafx.event.ActionEvent actionEvent) throws IOException{
        setName_new(new_name.getText());
        setId_last(last_id.getText());
        // setId_new(new_id.getText());
        setPro_des_new(new_pro_des.getText());
        if (new_pro_price.getText()==null){setPro_price_new("0");}
       else {
            setPro_price_new(new_pro_price.getText());
        }
        setCat_pro_id(new_cat_id.getText());
        first_screen.setline(1);
        Admin_services.setValue(5);
        first_screen.start();
        if (!getName_new().isEmpty()&&!getCat_pro_id().isEmpty()&&!getPro_des_new().isEmpty())
        {
    if (id_last.isEmpty()|| !product_DAO.getFlag()){
    showAlert("invalid ID","This is product is not available now !!!!!");
    last_id.setStyle("-fx-border-color: red;");
    }
        else {showAlert("successful","you update new product with name : "+getName_new());
    String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("main_screen0fAdmin.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        first_screen.setline(1);
        Admin_services.setValue(0);
        first_screen.start();}
}
else {
    showAlert("invalid data","enter valid data");
}

    }

    public void deleteProduct(javafx.event.ActionEvent actionEvent) throws IOException{
        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("deleteproductFrom_ADMIN.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);

    }
    public void c0_deleteProduct(javafx.event.ActionEvent actionEvent) throws IOException{
     setId_last(last_id.getText());
     first_screen.setline(1);
     Admin_services.setValue(6);
        first_screen.start();

        if (id_last.isEmpty()|| !product_DAO.getFlag2()){
            showAlert("invalid ID","This is product is not available now !!!!!");
            last_id.setStyle("-fx-border-color: red;");
        }
        else {showAlert("successful","you Delete product with ID : "+id_last);
            String css= this.getClass().getResource("/css.css").toExternalForm();
            Parent root= FXMLLoader.load((getClass().getResource("main_screen0fAdmin.fxml")));
            stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            scene=new Scene(root);
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            first_screen.setline(1);
            Admin_services.setValue(0);
            first_screen.start();}


    }



    public void backtofirst(javafx.event.ActionEvent actionEvent) throws IOException{
        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("first.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
    public void backtoadmin(javafx.event.ActionEvent actionEvent) throws IOException{
        first_screen.setline(1);
        Admin_services.setValue(0);
        first_screen.start();

        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("main_screen0fAdmin.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);

        alert.setContentText(message);
        alert.showAndWait();
    }
    public void exit(javafx.event.ActionEvent actionEvent) throws IOException{
        first_screen.getDatabase().exist(first_screen.getMy_customer(),first_screen.getMy_admin(),first_screen.getMy_product());
        Platform.exit();

    }

}
