import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// DONE BY EMAD
public class readData  {
    public static String fileName;
    protected static ArrayList<String> user = new ArrayList<>();
    protected static ArrayList<String> userP = new ArrayList<>();
    protected static ArrayList<String> userN = new ArrayList<>();
    private static ArrayList<String> spclization = new ArrayList<>();
    private static ArrayList<Person> p = new ArrayList<>();
    private static ArrayList<Student> s = new ArrayList<>();
    

    //private static final String SAMPLE_CSV_FILE_PATH = "./admin.csv";
    public readData() {}
    

    public readData(String fileName) throws IOException{
        this.fileName = fileName;
        String spcl = "";


        List<String> lines = Files.readAllLines(Paths.get("./"+fileName+".csv"));
        for (int i = 0; i < lines.size(); i++) {
            String[] items = lines.get(i).split(",");
            String userID = items[0];
            String userName = items[1];
            String passW = items[2];
            if (fileName.compareTo("student") == 0) {
                spcl = items[3];
                spclization.add(spcl);
                s.add(new Student(userID, userName, passW, spcl));

            }




            user.add(userID);
            userP.add(passW);
            userN.add(userName);


            

            p.add(new Person(userID,userName,passW));



           
            // System.out.println(userName);
            // System.out.println(passW);
        }

        

 


    }



    public static ArrayList<String> getUserID () {

        return user;
    }

    public static ArrayList<String> getUserP () {

        return userP;
    }

    public static ArrayList<Person> getPerson(){
        return p;
    }

    public static ArrayList<Student> getStudent(){
        return s;
    }



    public static ArrayList<String> getUserN () {

        return userN;
    }




    public static void saveUserToFile(ArrayList<Person> d1, String filename) throws IOException 
    {
        // read donors.csv into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d1.size(); i++)
            sb.append (d1.get(i).toCSVString() + "\n");
        Files.write(Paths.get("./"+fileName+".csv"), sb.toString().getBytes());

        //d1.clear();

        
    }
    public static void saveStudToFile(ArrayList<Student> d2, String filename) throws IOException 
    {
        // read donors.csv into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d2.size(); i++)
            sb.append (d2.get(i).toCSVString() + "\n");
        Files.write(Paths.get("./"+fileName+".csv"), sb.toString().getBytes());

        //d1.clear();

        
    }

    public boolean compareUser(ArrayList<String> u, ArrayList<String> p, String ID, String pass) {
        boolean check = false;
        int index = -1;
        if (u.indexOf(ID) != -1) {
            index = u.indexOf(ID);
            if (p.get(index).compareTo(pass) == 0) {
                check = true;                
            }

        }
        return check;


    }
    public boolean compareID(ArrayList<String> u, String id) {
        boolean check = false;
        
        if(u.indexOf(id) != -1) {
            check = true;
        }
        else {
            check = false;
        }

        return check;



    }

    public boolean compareName(ArrayList<String> u, String nm) {
        boolean check = false;
        
        if(u.indexOf(nm) != -1) {
            check = true;
        }
        else {
            check = false;
        }

        return check;



    }

    public String getPass() {
        char[] Cletter = {'A', 'B', 'C', 'D', 'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',
    'V','W','X','Y','Z'};

        char[] Sletter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w',
        'x','y','z'};

        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};

        char[] symbol = {'!','@','#','$','%','&','*','-','_','+','='};
        // int min = 10000;
        // int max = 19999;


        // char random = (symbol[new Random().nextInt(symbol.length)]);
        // System.out.println(random);
        String pass = "";

        for (int i = 0; i < 2; i++) {
            pass +=  (Sletter[new Random().nextInt(Sletter.length)]);

        }

        for (int i = 0; i < 3; i++) {
            pass +=  (Cletter[new Random().nextInt(Cletter.length)]);

        }

        pass += (symbol[new Random().nextInt(symbol.length)]);
        pass += (numbers[new Random().nextInt(numbers.length)]);
        pass += (numbers[new Random().nextInt(numbers.length)]);


        return pass;
        
    }

    public String getRandID(int min, int max) {

        int b = (int)(Math.random()*(max-min+1)+min); 


        return Integer.toString(b);


    }







    public static void main(String[] args) throws IOException{
        // readStud r =  new readStud("student");

        

        // System.out.println(r.getStudent());




        // int b = (int)(Math.random()*(max-min+1)+min); 

        // System.out.println(b);
        //new readData("admin");
        //System.out.println("HI");
        // readData r = new readData("admin");
        // Person p1 = new Person("12012", "kav99");

        // System.out.println(r.getPerson());
        // System.out.println(p1);
        //r.getUserID();
        //System.out.println(r.compareUser(getUserID(), getUserP(), "12011", "Ron_26"));

    }    


        

        
    


    
}


// class readStud extends readData{
//     private static ArrayList<String> special = new ArrayList<>();
//     private static ArrayList<Student> s = new ArrayList<>();


//     public readStud(String fileName) throws IOException {
//         super(fileName);
//         //TODO Auto-generated constructor stub
//         List<String> lines = Files.readAllLines(Paths.get("./"+fileName+".csv"));
//         for (int i = 0; i < lines.size(); i++) {
//             String[] items = lines.get(i).split(",");
//             String userID = items[0];
//             String userName = items[1];
//             String passW = items[2];
//             String spcl = items[3];



//             user.add(userID);
//             userP.add(passW);
//             userN.add(userName);


            

//             s.add(new Student(userID,userName,passW,spcl));



           
//             //System.out.println(s.toString());
//             //System.out.println(getStudent());
//             // System.out.println(passW);
//         }


//     }
//     public static ArrayList<String> getSpecialization() {
//         return special;
//     }

//     public ArrayList<Student> getStudent(){
//         return s;
//     }





// }