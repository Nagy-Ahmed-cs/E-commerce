package DAO;

import Entity.gender;
import Entity.Customer;
import Entity.Admin;
import Entity.Product;


import java.io.*;
import java.util.ArrayList;

public class Database {



    public void exist (ArrayList<Customer>my_customer, ArrayList<Admin>my_admin, ArrayList<Product>my_product) throws IOException {
        gender male=gender.male;

        FileWriter write=new FileWriter("C:\\Users\\DELL\\IdeaProjects\\java\\appp\\admins.txt");
        BufferedWriter my_admin_file =new BufferedWriter(write);
        FileWriter write2=new FileWriter("C:\\Users\\DELL\\IdeaProjects\\java\\appp\\customers.txt");
        BufferedWriter my_client_file= new BufferedWriter(write2);
        FileWriter write3= new FileWriter("C:\\Users\\DELL\\IdeaProjects\\java\\appp\\products.txt");
        BufferedWriter my_product_file=new BufferedWriter(write3);
        for (int i=0; i< my_customer.size(); i++){
            my_client_file.write(my_customer.get(i).getUser_name()+"\n");
            my_client_file.write(my_customer.get(i).getPass_word()+"\n");
            my_client_file.write(my_customer.get(i).getEmail()+"\n");
            my_client_file.write(my_customer.get(i).getDate_of_birth()+"\n");
            my_client_file.write(String.valueOf(my_customer.get(i).getUser_gender())+"\n");
            my_client_file.write(my_customer.get(i).getAddress()+"\n");
            my_client_file.write(my_customer.get(i).getBalance()+"\n");
            ArrayList<String>client_interest=my_customer.get(i).getInterest();
            for(int j=0; j< client_interest.size();j++){
                my_client_file.write(client_interest.get(j)+",");
            }
            my_client_file.write("\n");


        }
        for(int i=0; i< my_admin.size(); i++){

            my_admin_file.write(my_admin.get(i).getUser_name()+"\n");
            my_admin_file.write(my_admin.get(i).getPass_word()+"\n");
            my_admin_file.write(my_admin.get(i).getEmail()+"\n");
            my_admin_file.write(my_admin.get(i).getDate_of_birth()+"\n");
            my_admin_file.write(my_admin.get(i).getUser_gender()+"\n");
            my_admin_file.write(my_admin.get(i).getAddress()+"\n");
            my_admin_file.write(my_admin.get(i).getWorking_hours()+"\n");
        }
        for( int i=0; i< my_product.size(); i++){
            my_product_file.write(my_product.get(i).getId() + "\n");
            my_product_file.write(my_product.get(i).getName()+"\n");
            my_product_file.write(my_product.get(i).getPrice()+"\n");
            my_product_file.write(my_product.get(i).getDescription()+"\n");
            my_product_file.write(my_product.get(i).getCat_id()+"\n");


        }
        my_client_file.flush();
        my_admin_file.flush();
        my_product_file.flush();
    }

}
