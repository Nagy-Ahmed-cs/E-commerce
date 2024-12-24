package Services;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.Customer;
import DAO.customer_DAO;
import Entity.Product;
import Entity.cart;
import com.example.appp.Controll_login0fuser;

import javax.swing.text.html.parser.Entity;

public class Client_services implements Ecommerce {
    private static int option;
    public static void setOption(int y){
        option=y;
    }
    public static int getOption(){
        return option;
    }

    private static boolean usercheck;
    public static void setUsercheck(boolean d){
        usercheck=d;


    }
    public static boolean getUsercheck(){
        return usercheck;
    }

    public static Customer log_in(ArrayList<Customer> my_customer) {
        //System.out.println("\n\t\tLog In Screen ......\n");
        String line1;
        String line2;
        //Scanner input = new Scanner(System.in);
      // System.out.println("\nEnter your email : ");
        line1 = Controll_login0fuser.getMail0fuser();
        //System.out.println(line1);
       // System.out.println("\nEnter your pass word : ");
        line2 = Controll_login0fuser.getPassword0fuser();
        for (Customer customer : my_customer) {
            if (line1.equals(customer.getEmail()) && line2.equals(customer.getPass_word())) {
                setUsercheck(true);
                return customer;
            }
        }
        setUsercheck(false);
        return null;
    }
    public void show_customer_data(Customer c ){
        System.out.println("\n\t\tYour Current data here ......\n");
        System.out.println(c.getUser_name()+"  :  "+c.getEmail()+"  :  "+c.getBalance()+" :  "+c.getAddress()
                +"  :  "+c.getDate_of_birth());
        System.out.println("\nYour interest :) ");
        System.out.println("\n");
        for (int i = 0; i< c.getInterest().size(); i++){
            System.out.print(c.getInterest().get(i)+" || ");
        }
        System.out.println("\n\n");
    }
    @Override
    public void show_products(ArrayList<Product>my_product){
        System.out.println("\nWe have "+my_product.size()+" product(s) now . ");
        for (Product product : my_product) {
            System.out.println("\n_____________________________________\n");
            System.out.println(product.getCat_id() + " : " + product.getName()
                    + "  :  " + product.getId() + "  :  " + product.getPrice() + "\n======================\n " +
                    product.getDescription());
        }

    }
    public void show_customer_cart(cart my_cart){
        if(my_cart.getTotal_price()==0){
            System.out.println("\n\t\t\t\t\tYour cart is empty let's buy anything :) \n");
        }
        else {
            ArrayList<Product>my_cart_product=my_cart.getMy_product();
//            for (int i=0; i<my_cart_product.size();i++){
//                System.out.println("\nProduct no."+ (i+1) +" : "+my_cart_product.get(i).getId()
//                        +"  :  "+my_cart_product.get(i).getName()+"  :  "+my_cart_product.get(i).getDescription()
//                        +"  :  "+my_cart_product.get(i).getPrice());
//            }
           System.out.println("\n\nAnd your total price is : "+my_cart.getTotal_price()+"\n\n\n");
        }
    }



//    public int market_option(){
//        System.out.println("\n\t\t\t\t\t\t=========================");
//        System.out.println("\n\t\t\t\t\t\tWelcome to our market :) \n");
//        System.out.println("\t\t\t\t\t\t=========================");
//        int number;
//        do {
//            System.out.println("\t\t\t\t\t\t\t[1] Update your profile .");
//            System.out.println("\t\t\t\t\t\t\t[2] Show your Account . ");
//            System.out.println("\t\t\t\t\t\t\t[3] Show our product . ");
//            System.out.println("\t\t\t\t\t\t\t[4] show your cart . ");
//            System.out.println("\t\t\t\t\t\t\t[5] Add to the cart . ");
//            System.out.println("\t\t\t\t\t\t\t[6] Remove from the cart . ");
//            System.out.println("\t\t\t\t\t\t\t[7] Pay your bill . ");
//            System.out.println("\t\t\t\t\t\t\t[8] Log out . ");
//            System.out.println("\t\t\t\t\t\t\t[0] first Menu . ");
//            System.out.println("\n\t\t\t\t\t\t=========================");
//            System.out.print("\n\t\t\t\t\tEnter number from above (1->8) : ");
//            Scanner input = new Scanner(System.in);
//            number = input.nextInt();
//            if(number>8||number<0){
//                System.out.print("\nWrong input Enter again !!!!! ");
//            }
//        }while(number<0||number>8);
//        return number;
//    }
    public void client_function(ArrayList<Customer> my_customer, ArrayList<Product>my_product, Customer c2){
        int number;
       // do{
            number=getOption();
            switch (number){
                case 1:
                    customer_DAO c=new customer_DAO();
                    c.update_customer(my_customer);
                    break;
//                case 2:
//                    this.show_customer_data(c2);
//                    break;
//                case 3:
//                    this.show_products(my_product);
//                    break;
                case 4:

                   // System.out.println("\n\t\t\t\t\tClient Cart .........\n");
                    this.show_customer_cart(c2.my_cart);
                    break;
                case 5:
                    Cart_service c3=new Cart_service();
                    c3.add_item(my_product,c2.my_cart);
                    break;
                case 6:
                    Cart_service c10= new Cart_service();
                    c10.delete_from_cart(c2.my_cart);
                    break;
                case 7:
                    Cart_service c5= new Cart_service();
                    c5.payment(c2.my_cart,c2);
                    break;
                case 8:
                    customer_DAO c4=new customer_DAO();
                    c4.log_out(c2,my_customer);
                    break;
//                case 0:
//                    System.out.println("\nReturning to the main screen ... ");
//                    break;
            }

      //  }while(number!=0&&number!=8);
    }
}
