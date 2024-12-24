package Services;

import java.util.ArrayList;

import Entity.cart;
import Entity.Customer;
import Entity.Product;
import com.example.appp.Controll_mainUser_screen;

import java.util.Scanner;

public class Cart_service {
    private static boolean flag;

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Cart_service.flag = flag;
    }

    public void add_item(ArrayList<Product> my_product, cart my_cart) {
        //System.out.println("\n\t\t\t\t\t\tBuying new product here :) \n");
        //System.out.print("\nEnter the name or id  of the product you want to buy : ");
        String line;
        //  Scanner input=new Scanner(System.in);
        line = Controll_mainUser_screen.getIditem();
        Product p = Product.is_here(my_product, line);
        if (p == null) {
            setFlag(false);
            //System.out.println("\n\t\tThis is item is not here .......\n");
        } else {
            setFlag(true);
            double amount;
            // System.out.print("\nEnter the amount of this product : " );
            amount = Controll_mainUser_screen.getAmount();
            p.setAmount(amount);


            my_cart.setTotal_price( (p.getPrice()*amount)+my_cart.get_total_aftrbuying());
            my_cart.getMy_product().add(p);
            //System.out.println("Amount: " + amount);
         //   System.out.println("Product Price: " + p.getPrice());
//System.out.println("Calculated Price: " + (amount * p.getPrice()));

        }
        // System.out.println("\n\t\t\t\t\tOkay it was added let's go and explore our products ...");

    }

    public void delete_from_cart(cart my_cart) {
        // Scanner input= new Scanner (System.in);
        //System.out.println("\n\t\t\t\tdeletion from your cart here ........");
        if (my_cart.getTotal_price() == 0) {
            // System.out.println("\n\t\t\tYou don not have any product to remove from you cart . ");
        } else {
            String line;
            boolean flag = false;
            //do {
            //  System.out.println("\t\t\t\t\tthis is you cart ");
            // System.out.println("\n\t\t\t\t\t==============");
//                for (Product p : my_cart.getMy_product()) {
//                    System.out.println("\t\t\t\t\t"+p.getName());
//                }
            //  System.out.println("\n\t\t\t\t\t==============");
            // System.out.println("\n\t\t\tThese are your product here choose one from them : ");
            line = Controll_mainUser_screen.getIditem_delete();
            for (Product p : my_cart.getMy_product()) {
                if (p.getId().equals(line)) {
                    flag = true;
                    my_cart.getMy_product().remove(p);
                    my_cart.setTotal_price(my_cart.get_total_aftrbuying() - (p.getPrice()* p.getAmount()));
                    break;
                }
            }
            // }while(!flag);
            //  System.out.println("\n\t\t\tThe product was deleted successfully check your cart now !!!!!!\n");
        }

    }

    public void payment(cart my_cart, Customer c) {
        if (my_cart.getTotal_price() == 0) {
            System.out.println("\n\t\t\t\t\tYou did not buy any thing until now ......\n");

        } else {
            if (c.getBalance() < my_cart.getTotal_price()) {
                System.out.println("\n\t\t\t\t\t\t\t\tSorry , you do not have enough money to pay :( \n");
                System.out.println("\t\t\t\t\t\t\t\tDelete some Items from your Cart please !!!!!");
                return ;
            }
            Scanner input = new Scanner(System.in);
            double price;
            //    do{
            System.out.println("\nYour finance is : " + my_cart.getTotal_price() + " \n");
            System.out.print("\nPlease pay here : ");
            price = input.nextDouble();
            if (price != my_cart.getTotal_price()) {
                System.out.println("\nPlease , Enter the correct price !!!!!!!!\n");
            }
            //  }while(price!=my_cart.getTotal_price());
            c.setBalance(c.getBalance() - price);
        }
    }
}
