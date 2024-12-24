package com.example.appp;
import DAO.customer_DAO;
import Entity.Customer;
import Entity.Product;
import Entity.cart;
import Entity.gender;
import Services.Cart_service;
import Services.Client_services;
import Services.first_screen;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controll_mainUser_screen {
    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableView<Product> tableView2;
    @FXML
    private TableView<cart> cartTableView;
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
    @FXML
    private static TableColumn<cart, String> c11;
    @FXML
    private static TableColumn<cart, String> c22;

    @FXML
    private TextField current_name;
    @FXML
    private TextField current_password;
    @FXML
    private TextField new_name;
    @FXML
    private TextField new_password;
    private static String name_current;
    private static String password_current;
    private static String name_new;
    private static String password_new;

    public static void setName_current(String s){
        name_current=s;
    }
    public static String getName_current(){
        return name_current;
    }
    public static void setPassword_current(String s){
        password_current=s;
    }
    public static String getPassword_current(){
        return password_current;
    }
    public static void setName_new(String s){
        name_new=s;
    }
    public static String getName_new(){
        return name_new;
    }
    public static void setPassword_new(String s){
        password_new=s;
    }
    public static String getPassword_new(){
        return password_new;
    }
private static String iditem;
    private static String iditem_delete;
    private static double amount;

    public static String getIditem_delete() {
        return iditem_delete;
    }

    public static void setIditem_delete(String iditem_delete) {
        Controll_mainUser_screen.iditem_delete = iditem_delete;
    }

    public static Double getAmount() {
        return amount;
    }

    public static void setAmount(double amo) {
        amount = amo;
    }

    public static String getIditem() {
        return iditem;
    }

    public static void setIditem(String iditem) {
        Controll_mainUser_screen.iditem = iditem;
    }

    private Stage stage;
    private Scene scene;

    public void goToChecktoupdate(javafx.event.ActionEvent actionEvent)throws IOException {
        String css = this.getClass().getResource("/css.css").toExternalForm();
        Parent root = FXMLLoader.load((getClass().getResource("update_profile.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }

    public void confirm_update(javafx.event.ActionEvent actionEvent)throws IOException {
        setName_new(new_name.getText());
        setPassword_new(new_password.getText());
        setName_current(current_name.getText());
        setPassword_current(current_password.getText());
        Client_services.setOption(1);
        first_screen.setnumber(1);
        first_screen.setline(2);
        first_screen.start();
        if (!getName_new().isEmpty()||!getPassword_new().isEmpty()){
        if (customer_DAO.getflag()) {
            showAlert("Successful update", "your current name is : " + getName_current() + "  After update is : " + getName_new());
            String css = this.getClass().getResource("/css.css").toExternalForm();
            Parent root = FXMLLoader.load((getClass().getResource("mainScreen0fUser.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(css);
            stage.setScene(scene);
        }
        else {
            showAlert("invalid name && password","this account not exit ");
            current_name.setStyle("-fx-border-color: red;");
            current_password.setStyle("-fx-border-color: red;");
        }}
        else {
            showAlert("invalid name && password"," please enter a valid name and password");
            new_name.setStyle("-fx-border-color: red;");
            new_password.setStyle("-fx-border-color: red;");
            if (customer_DAO.getflag()) {
                showAlert("Successful update", "your current name is : " + getName_current() + "  After update is : " + getName_new());
                String css = this.getClass().getResource("/css.css").toExternalForm();
                Parent root = FXMLLoader.load((getClass().getResource("mainScreen0fUser.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add(css);
                stage.setScene(scene);
            }
            else {
                showAlert("invalid name && password","this account not exit ");
                current_name.setStyle("-fx-border-color: red;");
                current_password.setStyle("-fx-border-color: red;");
            }
        }
    }
    public void display_account(javafx.event.ActionEvent actionEvent) throws IOException {


        // Create and populate the ObservableList
        ObservableList<Customer> clientList = FXCollections.observableArrayList(first_screen.getCustomer());

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
        Scene scene = new Scene(vbox, 960, 100);
        Stage stage=new Stage();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Clients Table");
        stage.show();
    }
    public void display_products0fuser(javafx.event.ActionEvent actionEvent) throws IOException {

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
        Scene scene = new Scene(vbox, 600, 400);
        Stage stage=new Stage();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Product Table");
        stage.show();
    }

    public void display_CArt(javafx.event.ActionEvent actionEvent) throws IOException {


        // Create and populate the ObservableList
        ObservableList<Product> carttList = FXCollections.observableArrayList(first_screen.getCustomer().my_cart.getMy_product());

        // Create a TableView
        tableView2 = new TableView<Product>(carttList);

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
        Label total = new Label();
        total.setStyle("-fx-font-size: 18px;  /* Font size */\n" +
                "    -fx-font-family: \"Arial\";  /* Font family */\n" +
                "    -fx-font-weight: bold;  /* Bold text */\n" +
                "    -fx-text-fill: #2c3e50;  /* Text color (dark blue-gray) */\n" +
                "    -fx-padding: 10 20;  /* Padding around the text */\n" +
                "    -fx-background-color: #ecf0f1;  /* Light gray background */\n" +
                "    -fx-background-radius: 5;  /* Rounded corners */\n" +
                "    -fx-border-color: #3498db;  /* Blue border color */\n" +
                "    -fx-border-width: 2;  /* Border width */\n" +
                "    -fx-border-radius: 5;  /* Border radius (rounded corners) */\n" +
                "    -fx-alignment: center;  /* Align text to the center */\n");
        total.setText("    Total price is : "+String.valueOf(first_screen.getCustomer().my_cart.get_total_aftrbuying()));



         //Add columns to the TableView
        tableView2.getColumns().addAll(
                c1,c2,c3,c7,c8
        );



        String css= this.getClass().getResource("/css2.css").toExternalForm();
//
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(tableView2,total);
        Scene scene = new Scene(vbox, 600, 400);
        Stage stage=new Stage();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Product Table");
        stage.show();
    }

    public void addItem(javafx.event.ActionEvent actionEvent) throws IOException {


        TextField idField = new TextField();
        idField.setPromptText("Enter Product ID");


        TextField amountField = new TextField();
        amountField.setPromptText("Enter Amount");


        Button addButton = new Button("Add to Cart");
        String css= this.getClass().getResource("/css2.css").toExternalForm();
        VBox vbox = new VBox(60,idField,amountField,addButton);

        Scene scene = new Scene(vbox, 300, 400);
        Stage stage=new Stage();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Add item");
        stage.show();
        Cart_service c3=new Cart_service();

        addButton.setOnAction(e -> {
            String s=new String(idField.getText());
            String w=new String(amountField.getText());
            if (s.isEmpty()||w.isEmpty()){
                showAlert("please enter valid data","enter correct id & amount");
            }

         else {
                setIditem(idField.getText());
                setAmount(Double.parseDouble(amountField.getText()));
                c3.add_item(first_screen.getMy_product(), first_screen.getCustomer().my_cart);
                if (!Cart_service.isFlag() || getAmount() < 0) {
                 showAlert("Invalid Input", "Please enter a valid product ID and amount.");
             } else {
                    showAlert("add succsess", "product with id : " + getIditem() + " is added");
                    stage.close();
                }
            }




            idField.clear();
            amountField.clear();
        });


    }
    public void deleteItem(javafx.event.ActionEvent actionEvent) throws IOException {


        TextField idField2 = new TextField();
        idField2.setPromptText("Enter Product ID");

        Button addButton = new Button("delete from the Cart");
        String css= this.getClass().getResource("/css2.css").toExternalForm();
        VBox vbox = new VBox(60,idField2,addButton);

        Scene scene = new Scene(vbox, 300, 400);
        Stage stage=new Stage();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Clients Table");
        stage.show();

        Cart_service c10= new Cart_service();
        addButton.setOnAction(e -> {
if (first_screen.getCustomer()==null){showAlert("char is empty","add to cart first");
stage.close();}
else {
            if (first_screen.getCustomer().my_cart.getTotal_price()==0) {
                showAlert("the cart is empty", "Please add first to cart to delete ");
            }
            else {
                setIditem_delete(idField2.getText());
                c10.delete_from_cart(first_screen.getCustomer().my_cart);
                showAlert("delete succsess", "product with id : "+getIditem()+" is deleted");
                stage.close();
            }}





            idField2.clear();

        });




    }
    public void pay(javafx.event.ActionEvent actionEvent) throws IOException {
        if(first_screen.getCustomer()==null||first_screen.getCustomer().my_cart.get_total_aftrbuying()==0){
            showAlert("you do not need to pay any thing","add to cart first to pay");

        }
        else if (first_screen.getCustomer().getBalance() <first_screen.getCustomer().my_cart.get_total_aftrbuying()){{
            showAlert("Sorry , you do not have enough money to pay :(","Delete some Items from your Cart please !!!!!");
            TextField idField2 = new TextField();
            idField2.setPromptText("Enter Product ID");

            Button addButton = new Button("delete from the Cart");
            String css= this.getClass().getResource("/css2.css").toExternalForm();
            VBox vbox = new VBox(60,idField2,addButton);

            Scene scene = new Scene(vbox, 300, 400);
            Stage stage=new Stage();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.setTitle("Clients Table");
            stage.show();

            Cart_service c10= new Cart_service();
            addButton.setOnAction(e -> {
                if (first_screen.getCustomer()==null){showAlert("char is empty","add to cart first");
                    stage.close();}
                else {
                    if (first_screen.getCustomer().my_cart.getTotal_price()==0) {
                        showAlert("the cart is empty", "Please add first to cart to delete ");
                    }
                    else {
                        setIditem_delete(idField2.getText());
                        c10.delete_from_cart(first_screen.getCustomer().my_cart);
                        showAlert("delete succsess", "product with id : "+getIditem()+" is deleted");
                        stage.close();
                    }}





                idField2.clear();

            });




        }}
        else {

        Stage stage1=new Stage();
        // Title Label
        Label titleLabel = new Label("Payment Screen");
        titleLabel.setId("title-label");

        // Total Price Label
        Label totalPriceLabel = new Label("Total Price: "+first_screen.getCustomer().my_cart.get_total_aftrbuying()); // Replace with your actual price
        totalPriceLabel.setId("total-price-label");

        // Input Field for Payment Amount


        // Pay Button
        Button payButton = new Button("Pay Now");
        payButton.setId("pay-button");

        // Success Message
        Label successMessage = new Label();
        successMessage.setId("success-message");


            // Button Action
        payButton.setOnAction(event -> {


            first_screen.getCustomer().setBalance(first_screen.getCustomer().getBalance() - (first_screen.getCustomer().my_cart.get_total_aftrbuying()));


          showAlert("Payment Successful!","Payment Successful!");
            stage1.close();
        });

        // Layout
        VBox root = new VBox(40, titleLabel, totalPriceLabel, payButton, successMessage);
        root.setAlignment(Pos.CENTER);
        root.setId("pay-screen");

        // Scene and CSS
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add("css.css"); // Link the CSS file
        // Stage Setup
        stage1.setTitle("Pay Screen");
        stage1.setScene(scene);
        stage1.show();
    }}

    public void backTomain(javafx.event.ActionEvent actionEvent)throws IOException{
        setName_new(new_name.getText());
        setPassword_new(new_password.getText());
        first_screen.setnumber(1);
        first_screen.setline(2);
        first_screen.start();
        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("mainScreen0fUser.fxml")));
        stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
    public void backTofirst(javafx.event.ActionEvent actionEvent)throws IOException{

        String css= this.getClass().getResource("/css.css").toExternalForm();
        Parent root= FXMLLoader.load((getClass().getResource("first.fxml")));
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);

        alert.setContentText(message);
        alert.showAndWait();
    }

}
