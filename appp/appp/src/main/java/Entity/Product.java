package Entity;


import java.util.ArrayList;

public class Product {
    private  String id;
    private String name ;
    private double price ;
    private String description;
    private String cat_id;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public  String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
                // the start of my code .....

    public static Product is_here(ArrayList<Product>my_product, String id) {


        for (int i = 0; i < my_product.size(); i++) {
            if (id.equals(my_product.get(i).getId()) || id.equals(my_product.get(i).getName())) {
                return my_product.get(i);
            }
        }
        return null;
    }

}