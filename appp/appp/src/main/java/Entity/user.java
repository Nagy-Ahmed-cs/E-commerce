package Entity;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class  user {
    private String user_name ;
    private String pass_word;
    private String date_of_birth;
    private String address;
    private String email;
    private gender user_gender;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public gender getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(gender user_gender) {
        this.user_gender = user_gender;
    }
}
