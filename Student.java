import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// CAN LOGIN BUT NO MENU OR FUNCTIONS DONE

// DONE BY DONE
public class Student extends Person {
    private String spclization;


    public Student() {}

    public Student(String userID,String userName, String userPassword, String spclization) {
        setUserID(userID);
        setUserName(userName);
        setUserPass(userPassword);
        this.spclization = spclization;

    }

    public String getSpecial() {
        return spclization;
    }

    public String toString() {
        return "UserID  = " + getUserID() +  " Password = " + getUserPassword() + " UserName = " + getUserName() + " Specialization = " + getSpecial() ;  
    }
    public String toCSVString() {
        return getUserID()+","+getUserName()+","+getUserPassword()+","+spclization;
    }


    
}
