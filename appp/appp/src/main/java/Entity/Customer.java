package Entity;


import java.util.ArrayList;

public class Customer extends user {
    private double balance;
    public cart my_cart = new cart();
    private ArrayList<String> interest = new ArrayList<>(0);//user interesting

    public Customer() {

    }

    public Customer(double balance, cart my_cart, ArrayList<String> interest) {
        this.balance = balance;
        this.my_cart = my_cart;
        this.interest = interest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getInterest() {
        return interest;
    }

    public void setInterest(String[] interest) {
        for (int i = 0; i < interest.length; i++) {
            this.interest.add(interest[i]);
        }

    }

    public void validate_balance() {

    }

}
// here the birth of my code ................