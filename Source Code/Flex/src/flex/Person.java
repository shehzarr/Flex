package flex;
import java.util.*;

public class Person {

    public String fName;

    public String lName;

    public String cnic;

    public String password;

    public String address;

    public String phoneNo;

    public String fatherOrGuardianName;

    public String fatherOrGuardianCnic;

    public String dateOfBirth;

    public Person() {
    }
    
    public void print() {
    }

    public void changePassword() {
        
        System.out.print("Enter previous password: ");
        Scanner in = new Scanner(System.in);
        String pass = in.nextLine();
        while(true){
            if(pass.equals(this.password)==true){
            System.out.print("Enter new password: ");
            this.password=in.nextLine();
            return;
        }
            else{
                System.out.println("Previous password incorrect. Try Again.");
            }
        }
        
        
    }

    public void login() {
    }

}
