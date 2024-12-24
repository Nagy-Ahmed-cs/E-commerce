package Services;

import DAO.*;
import Entity.Customer;
import Entity.Admin;
import Entity.Product;
import DAO.Admin_DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class first_screen {
    private static int line ;
    private static int number ;
   private static ArrayList<Admin> my_admin;
   private static ArrayList<Customer> my_customer ;
    private static ArrayList<Product> my_product ;
    private static Customer customer;
    private static Database database;

    public static Database getDatabase() {
        return database;
    }

    public static void setDatabase(Database database) {
        first_screen.database = database;
    }

    public static void setCustomer(Customer c){
        customer=c;
    }
    public static Customer getCustomer(){
        return customer;
    }
    public static void setMy_admin(ArrayList<Admin> my_adming){
        my_admin=my_adming;
    }
    public static ArrayList<Admin> getMy_admin(){
        return my_admin;
    }
    public static void setMy_customer(ArrayList<Customer> my_customerrr){
        my_customer=my_customerrr;
    }
    public static ArrayList<Customer> getMy_customer(){
        return my_customer;
    }
    public static void setMy_product(ArrayList<Product> my_productttt){
        my_product=my_productttt;
    }
    public static ArrayList<Product> getMy_product(){
        return my_product;
    }



    public static void setline(int x){
        line=x;
    }
    public static void setnumber(int t){
        number=t;
    }

// public static int  role(int x) {
//       int  line=x;
////        do {
////           // System.out.println("\n\t\t\t\t\tAre you Admin or Client ? ");
//////            System.out.println("\n\t\t\t\t\t[1] Admin , [2] Client , [0] Exist \n");
//////            System.out.print("\t\t\t\t\t\tEnter your choice : ");
//////            Scanner input = new Scanner(System.in);
////        //    line = input.nextInt();
////            if(line>2||line<0){
////                System.out.println("\n\t\t\tPLease Enter a valid number again !!!!!!!\n");
////            }
////        }while(line<0||line>2);
//        return line;
//    }
//public static int option(int x) {
// int value=x;
////        Scanner input = new Scanner(System.in);
////        do {
////            System.out.println("\t\t\t\t\t\t\t\t=================");
////            System.out.println("\n\t\t\t\t\t\t\t\tOur Screen ...\n");
////            System.out.println("\t\t\t\t\t\t\t\t=================");
////            System.out.println("\n\t\t\t\t\t\t\t\t[1] Log in . ");
////            System.out.println("\n\t\t\t\t\t\t\t\t[2] Create new Account . ");
////            System.out.println("\n\t\t\t\t\t\t\t\t[0] First Screen . ");
////            System.out.println("\t\t\t\t\t\t\t\t=================");
////            System.out.print("\n\n\t\t\t\t\tEnter your choice : ");
////            value = input.nextInt();
////        } while (value < 0 || value > 3);
//        return value;
//  }
    public static void start() throws IOException {
        Database d= new Database();
        Admin_DAO admin=new Admin_DAO();
        customer_DAO client= new customer_DAO();
        product_DAO product= new product_DAO();

//        ArrayList<Admin> my_admin = admin.load_admin_data();
//        ArrayList<Customer> my_customer = client.load_customer_data();
//        ArrayList<Product> my_product =product.load_product_data();
        setMy_admin(admin.load_admin_data());
        setMy_customer(client.load_customer_data());
        setMy_product(product.load_product_data());
        setDatabase(d);
       // do {
           // line = role();
            switch (line) {

                case 1:

                    Admin a = Admin_services.admin_log_in(getMy_admin());
                    //System.out.println(a);
                    if (a != null) {
                        Admin_services a1= new Admin_services();

                        a1.admin_function(getMy_admin(), getMy_customer(), getMy_product());

                    } else {
                        //System.out.println("\n\t\t\tYou do not have account here ...\n");
                        //start();
                    }
                    break;
                case 2:
                   // do {
                        //number = option();
                        switch (number) {
                            case 1:

                                Customer c = Client_services.log_in(my_customer);


                                if (c != null) {
                                    setCustomer(c);
                                    Client_services c1= new Client_services();
                                    c1.client_function(my_customer, my_product,c);}
//                                } else {
//                                    //System.out.println("\nSorry , you do not have an account here ...\n");
//                                    //System.out.println("\nWould you like to create new account ? (y/n) : ");
//                                    //Scanner input = new Scanner(System.in);
//                                     {
//                                        customer_DAO c2= new customer_DAO();
//                                        c2.create_account(my_customer);
//                                    }
//                                }
                                break;
                            case 2:
                                customer_DAO c1 = new customer_DAO();
                                c1.create_account(my_customer);
                              //  number = option();
                                break;
                            case 0:

                                break;
                        }

                   // } while (number != 0);
                    break;
                case 0:
                   // System.out.println("\nThank you for your time .......\n");
                    break;
            }
       // }while(line!=0);

        d.exist(my_customer,my_admin,my_product);
    }




}
