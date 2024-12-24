package Services;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Admin;
import Entity.Product;
import Entity.Customer;
import DAO.product_DAO;
import com.example.appp.Controll_AfterAdmin_screen;



public class Admin_services implements Ecommerce {
    private static boolean admincheck;
    public static void setAdmincheck(boolean b){
        admincheck=b;

    }
    public static boolean getAdmincheck(){
        return admincheck;
    }

    public static Admin admin_log_in(ArrayList<Admin> my_admin){
        //System.out.println("\nAdmin log in screen .....\n");

        String line1;
        String line2;
       // Scanner input = new Scanner(System.in);
       // System.out.println("\nEnter your email : ");
        line1 = Controll_AfterAdmin_screen.getMail0fadmin();
       // System.out.println("\nEnter your pass word : ");
        line2 = Controll_AfterAdmin_screen.getPassword0fadmin();
        //System.out.println( Controll_AfterAdmin_screen.getMail0fadmin());
if (line1==null||line2==null){
    setAdmincheck(false);
    return null;
}
 else{       for (Admin admin : my_admin) {
            if (line1.equals(admin.getEmail()) && line2.equals(admin.getPass_word())) {
                setAdmincheck(true);
                return admin;

            }
        }
        setAdmincheck(false);
        return null;
    }}
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
    public void show_clients(ArrayList<Customer> my_customer) {
        System.out.println("\n We have " + my_customer.size() + " Client(s). ");
        for (int i = 0; i < my_customer.size(); i++) {
            System.out.println("\nCustomer no." + (i + 1));
            System.out.println(my_customer.get(i).getUser_name() + "  :  " + my_customer.get(i).getEmail() +
                    "  :  " + my_customer.get(i).getBalance() + " :  "
                    + my_customer.get(i).getAddress() + "  :  " + my_customer.get(i).getDate_of_birth());
            System.out.println("\n" + my_customer.get(i).getUser_name() + "'s interests are : ");
            ArrayList<String> interest = my_customer.get(i).getInterest();
            for (int j = 0; j < interest.size(); j++) {
                System.out.print(interest.get(j) + " || ");
            }
            System.out.println("\n====================================\n");
        }
        System.out.println("\n\n");
    }

private static int value;
    public static void setValue(int x){
        value=x;
    }




//    public int market_option(){
//        System.out.println("\n\t\t\tWelcome our great admin ........\n\n");
//        int value;
//        Scanner input= new Scanner(System.in);
//        do {
//            System.out.println("\t\t\tHere our admin services . ");
//            System.out.println("\n______________________________________________\n");
//            System.out.println("\t\t\t\t[1] show all clients .  ");
//            System.out.println("\t\t\t\t[2]Show Our Products .");
//            System.out.println("\t\t\t\t[3] create category . ");
//            System.out.println("\t\t\t\t[4] Create product . ");
//            System.out.println("\t\t\t\t[5] Update product . ");
//            System.out.println("\t\t\t\t[6] delete product . ");
//            System.out.println("\t\t\t\t[0] Return to the main screen . ");
//            System.out.println("\n______________________________________________\n");
//            System.out.print("\n\t\t\t\tEnter number from above ? ");
//            value=input.nextInt();
//            if(value>7||value<0){
//                System.out.println("\nPlease , Enter a valid number !!!!!!\n");
//            }
//        }while(value>7||value<0);
//        return value;
//    }
    public void admin_function(ArrayList<Admin>my_admin, ArrayList<Customer>my_customer, ArrayList<Product>my_product) throws IOException {
        Admin a= new Admin();
       // System.out.println("\nWelcome our Admin .....\n");
        int new_number;

       // do {

            new_number=value;
            switch (new_number) {

                case 1:
                    this.show_clients(my_customer);
                    break;
                case 2:
                    this.show_products(my_product);
                      break;
                case 4:
                    product_DAO p10=new product_DAO();
                    p10.create_product(my_product);
                    break;
                case 5:
                    product_DAO p= new product_DAO();
                    p.update_product(my_product);
                    break;
                case 6:
                    product_DAO p1=new product_DAO();
                    p1.delete_product(my_product);
                    break;

                case 0:
                   // System.out.println("Returning to the main screen .....\n");
                    break;

            }
       // }while(new_number!=0);
    }
}
