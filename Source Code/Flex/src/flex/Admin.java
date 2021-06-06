package flex;

import java.util.*;

public class Admin extends Person {

    static String currentSemester = "Fall 2019";
    static int feepercredit = 7000;

    public Admin() {
    }

    public void print() {
    }

    static void setCurrentSemester(String temp) {
        Admin.currentSemester = temp;
    }

}
