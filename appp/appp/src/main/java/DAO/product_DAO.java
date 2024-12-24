package DAO;

import Entity.Product;
import com.example.appp.Controll_MAinAdmin_screen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class product_DAO {
    private static boolean flag;
    public static void setFlag(boolean k){
        flag=k;
    }
    public static boolean getFlag(){
        return flag;
    }

    private static boolean flag2;
    public static void setFlag2(boolean k){
        flag2=k;
    }
    public static boolean getFlag2(){
        return flag2;
    }
    // Read products ......
    public ArrayList<Product> load_product_data() throws IOException {
        String line;
        ArrayList<Product>my_product=new ArrayList<>();
        FileReader read= new FileReader("products.txt");
        BufferedReader my_file = new BufferedReader(read);
        while((line=my_file.readLine())!=null){
            Product p= new Product();
            p.setId(line);
            p.setName(my_file.readLine());
            double x= Double.valueOf(my_file.readLine());
            p.setPrice(x);
            p.setDescription(my_file.readLine());
            p.setCat_id(my_file.readLine());
            my_product.add(p);
        }
        return my_product;
    }
    //Create products .......
    public void create_product(ArrayList<Product> my_product) {
        //System.out.println("\n\t\t\tCreating product.......\n ");
        Product p = new Product();
       // Scanner input = new Scanner(System.in);
        int x;
if (my_product.getLast().getId() !=null){
         x= Integer.parseInt(my_product.getLast().getId());}
else {
    x=1;

}

        p.setId(String.valueOf(++x)); // Set the ID

       // System.out.println("\nEnter the name of the new product: ");
        p.setName(Controll_MAinAdmin_screen.getName());

       // System.out.println("\nEnter product (Category) id: ");
        p.setCat_id(Controll_MAinAdmin_screen.getId());
       // input.nextLine(); // Consume leftover newline

      //  System.out.println("\nEnter product Description: ");
        p.setDescription(Controll_MAinAdmin_screen.getDes());

      //  System.out.println("\nFinally, Enter product price: ");
        p.setPrice(Controll_MAinAdmin_screen.getPrice());

        my_product.add(p);
        //System.out.println("\n\t\tLoading ...........\n");
        //System.out.println("\n\t\tThe product was added successfully :) ");
    }

    //Update products ........
    public void update_product(ArrayList<Product> my_product) {
       // Scanner input = new Scanner(System.in);
        //System.out.println("\nEnter the id or name of product to update : ");
        String id;
        id =Controll_MAinAdmin_screen.getId_last();

       setFlag(false);
        for (int i = 0; i < my_product.size(); i++) {
            if (id.equals(my_product.get(i).getId()) || id.equals(my_product.get(i).getName())) {
              //  System.out.println("\nOk , you can update it now ....\n");
               setFlag(true);
               // System.out.println("\nEnter the new name for the product : ");
                my_product.get(i).setName(Controll_MAinAdmin_screen.getName_new());
               // System.out.println("\nEnter the new id for the product : ");
               // my_product.get(i).setId(Controll_MAinAdmin_screen.getId_new());
               // System.out.println("\nEnter the new price for the product : ");
                my_product.get(i).setPrice(Controll_MAinAdmin_screen.getPro_price_new());
              //  input.nextLine();
             //   System.out.println("\nEnter the new description for the product : ");
                my_product.get(i).setDescription(Controll_MAinAdmin_screen.getPro_des_new());
               // System.out.println("\nEnter the new category code for the product :  ");
                my_product.get(i).setCat_id(Controll_MAinAdmin_screen.getCat_pro_id());
            }
        }
//        if (!flag) {
//            System.out.println("\nThis is product is not available now !!!!!\n");
//        }
    }
    //Delete product .........
    public void delete_product(ArrayList<Product> my_product) {
        //Scanner input = new Scanner(System.in);
        String word;
       // System.out.println("\nEnter the name of the product or its id : ");
        word =Controll_MAinAdmin_screen.getId_last();
        if (Product.is_here(my_product, word) == null) {
            //System.out.println("\nThe product is not here already ......");
            setFlag2(false);

        } else {
            setFlag2(true);
            my_product.remove(Product.is_here(my_product, word));
           // System.out.println("\nThe product was deleted successfully !!!!!!!!");
        }

    }





}
