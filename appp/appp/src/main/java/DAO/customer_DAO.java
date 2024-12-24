package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.gender;
import Entity.Customer;
import com.example.appp.Controll_mainUser_screen;
import com.example.appp.Controll_sign_screen;


public class customer_DAO {
    private static boolean flag;
    public static void setFlag(boolean s){
        flag=s;
    }
    public static boolean getflag(){
        return flag;
    }

    //Read Clients......
    public  ArrayList<Customer> load_customer_data() throws IOException {
        gender x1=gender.male;
        gender female=gender.female;
        ArrayList<Customer>my_customer=new ArrayList<>();
        FileReader read=new FileReader("customers.txt");
        BufferedReader my_file= new BufferedReader(read);
        String line;
        while((line = my_file.readLine()) != null){
            Customer s= new Customer();
            s.setUser_name(line);
            s.setPass_word(my_file.readLine());
            s.setEmail(my_file.readLine());
            s.setDate_of_birth(my_file.readLine());
            //s.setUser_gender(gender.valueOf(my_file.readLine()));
            if(my_file.readLine().equals("male")){
                s.setUser_gender(x1);
            }
            else {
                s.setUser_gender(female);
            }
            s.setAddress(my_file.readLine());
            double x= Double.parseDouble(my_file.readLine());
            s.setBalance(x);
            String [] customer_interest=my_file.readLine().split(",");
            s.setInterest(customer_interest);
            my_customer.add(s);
            //System.out.println(s.getUser_gender());
        }

        return my_customer;

    }
    // Create Clients
    public void create_account(ArrayList<Customer>my_customer){

       // Scanner input= new Scanner(System.in);
       // System.out.println("\n\tCreating new account on our market :) \n\n");
        Customer s= new Customer();
        //System.out.println("\n\t\tEnter your name : ");
        s.setUser_name(Controll_sign_screen.getName());
       // System.out.println("\n\t\tEnter your email : ");
        s.setEmail(Controll_sign_screen.getmail());
       // int counter=0;
       String word;
        String line;
        //do {
          //  System.out.println("\n\t\tEnter your pin code : ");
            word = Controll_sign_screen.getPass();
           // System.out.println("\n\t\tPlease Enter pass for the second time to confirm : ");
            line = Controll_sign_screen.getC_pass();
            if(line.equals(word)){
                s.setPass_word(word);

            }
//            else {
//                counter++;
//                System.out.println("\nYou have ("+(3-counter)+") Trails ...  \n");
//            }

        //}while(counter<3);
//        if(counter==3){
//            return ;
//        }

       //// System.out.println("\n___________________________________\n");
       // System.out.println("\n\t\toptional data .... ");
       // System.out.println("\nEnter your address : ");
        s.setAddress(Controll_sign_screen.getAddres());
      //  System.out.println("\nEnter your date of birth (DD-MM-YY) : ");
        s.setDate_of_birth(Controll_sign_screen.getDate());
       // System.out.println("\nEnter your balance : ");
        s.setBalance(Controll_sign_screen.getBalanc());
      //  System.out.println("\nDo u have any interest in any product (yes/no) : ");
       // if(input.next().equals("yes")){
            //do{
              //  System.out.println("\nOkay , Enter the name or type of your favourite product : ");
                s.getInterest().add(Controll_sign_screen.getInter());
            //    System.out.println("\nDo u want to continue ? (y/n) : ");
          //  }while(input.next().equals("y"));
        //}
       if (s.getInterest()==null){
            s.getInterest().add("no thing till now !!!!!");
        }
        s.setUser_gender(gender.valueOf(Controll_sign_screen.getGender()));
        my_customer.add(s);

        ///System.out.println("gooooooooooooooooooooooooooooood");
    }

    //Update Client......
    public void update_customer(ArrayList<Customer>my_customer) {
      //  Scanner input = new Scanner(System.in);
      //  System.out.println("\n\t\tUpdating Client data.....\n");
       // System.out.println("\n\t\tEnter your current name : ");
        String word;
        word = Controll_mainUser_screen.getName_current();
      //  System.out.println("\n\t\tEnter your current pin code : ");
        String new_word;
        new_word = Controll_mainUser_screen.getPassword_current();
        for (int i = 0; i < my_customer.size(); i++) {
            if (my_customer.get(i).getUser_name().equals(word) && my_customer.get(i).getPass_word().equals(new_word)) {
                setFlag(true);
              //  System.out.println("\n\t\tOkay , you can change your account now ...\n");
               // System.out.println("\n\t\tEnter your new name : ");
                word = Controll_mainUser_screen.getName_new();
                my_customer.get(i).setUser_name(word);
               // System.out.println("\n\t\tEnter new pin code : ");
                new_word = Controll_mainUser_screen.getPassword_new();
                my_customer.get(i).setPass_word(new_word);
                //here I update only name and pass word because I was so tired ......
                break;
            }
        }
    }
    //delete client  ........
   public void log_out(Customer my_client, ArrayList<Customer>my_customer){
        my_customer.remove(my_client);
   }

}
