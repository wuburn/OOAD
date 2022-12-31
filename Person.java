import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//CAN LOGIN BUT NO MENU OR FUNCTIONS DONE

// DONE BY EMAD
public class Person  {

    private String userID;
    private String userName;
    private String userPassword;

    public Person() {}

    public Person(String userID,String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPass(String userPassword ) {
        this.userPassword = userPassword;

    }

    public String toString() {
        return "UserID  = " + userID+  " UserName = " + userName +" Password = " + userPassword ; 
    }
    public String toCSVString() {
        return userID+","+userName+","+userPassword;
    }

    // public int compareTo(Person other) {
    //     return this.userID.compareTo(other.getUserID());
    // }

    // public String toCSVString() {
    //     return userID+","+userName+","+userPassword;
    // }

    // public int compareTo(Person other) {
    //     return this.aidsName.compareTo(other.getAidsName());
    // }

    // public ArrayList<Person> readAidsFromFile(String fileName) throws IOException {
    //     //ArrayList<Person> userDet = new ArrayList<>();
    //     // read value by lines from csv file and put into a list of lines.
    //     List<String> lines = Files.readAllLines(Paths.get("./"+fileName+".csv"));
    //     for (int i = 0; i < lines.size(); i++) {
    //        // split a line by comma
    //        String[] items   = lines.get(i).split(",");
    //        String userID    = items[0];
    //        //String userName  = items[1];
    //        String passW     = items[2];

        
    //        userDet.add(new Person(userID,passW));
    //        read
    //     }

    //     return userDet;
    //  }
     public static void main(String[] args) throws IOException {

        // Person p1 = new Person();
        // Person p2 = new Person("12012","kav99");
        // ArrayList<Person> a = p1.new readAidsFromFile("admin");
        
        //boolean test = Arrays.asList().contains();
        
        //System.out.println(p1.readAidsFromFile("admin").indexOf());
        // System.out.println(p1.readAidsFromFile("admin").get(1));
        // // System.out.println(test);
        // System.out.println(p1.readAidsFromFile("admin").indexOf(p2));
        //System.out.println(a.indexOf(p));
        
     }
}
