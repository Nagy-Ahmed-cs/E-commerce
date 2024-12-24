package Entity;

import java.util.ArrayList;

public class cart {
    private ArrayList<Product> my_product = new ArrayList<>(0);//please do not mix between these product and our main product
    private double total_price;

    public ArrayList<Product> getMy_product() {
        return my_product;
    }

    public void setMy_product(ArrayList<Product> my_product) {
        this.my_product = my_product;
    }

    public double getTotal_price() {
        double price = 0;
        for (int i = 0; i < my_product.size(); i++) {
            price += my_product.get(i).getPrice();
        }
        return price;
    }
    public double get_total_aftrbuying (){
        return this.total_price;
    }

    public  void setTotal_price(double total) {
        total_price = total;
    }
}
//Starting my code here ..........