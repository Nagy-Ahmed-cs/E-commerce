package Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Admin extends user {
    private int working_hours;

    public int getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(int working_hours) {
        this.working_hours = working_hours;
    }
}