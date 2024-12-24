package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Entity.gender;
import Entity.Admin;
public class Admin_DAO {
    //Read Admins ....
    public ArrayList<Admin> load_admin_data() throws IOException {
        gender male = gender.male;
        gender female = gender.female;
        ArrayList<Admin> my_admin = new ArrayList<>();
        FileReader read = new FileReader("admins.txt");
        BufferedReader my_file = new BufferedReader(read);
        String line;
        while ((line = my_file.readLine()) != null) {
            Admin a = new Admin();
            a.setUser_name(line);
            a.setPass_word(my_file.readLine());
            a.setEmail(my_file.readLine());
            a.setDate_of_birth(my_file.readLine());
            if (my_file.readLine().equals("male")) {
                a.setUser_gender(male);
            } else {
                a.setUser_gender(female);
            }
            a.setAddress(my_file.readLine());
            int x = Integer.parseInt(my_file.readLine());
            a.setWorking_hours(x);
            my_admin.add(a);
        }
        return my_admin;
    }

}
