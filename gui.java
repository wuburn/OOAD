import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.IOError;
import java.io.IOException;

//DONE BY EMAD
public class gui extends JFrame  {

    public gui(){
        super("Main Page");

        setLayout(null);

        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = getContentPane();

        JPanel jp = new JPanel();
        JPanel jp2 = new JPanel();
        
        jp.setLayout(null);
        jp2.setLayout(null);



        JButton lect = new JButton("Lecturer Login");
        JButton stud = new JButton("Student Login");
        JButton adm = new JButton("Administrator Login");
        JLabel lbl = new JLabel("WELCOME !!");

        lect.setFocusable(false);
        stud.setFocusable(false);
        lbl.setFocusable(false);

        lect.setBounds(10,30,150,30);
        stud.setBounds(170,30,150,30);
        adm.setBounds(90,70,150,30);
        lbl.setBounds(10,10,100,20);

        
        lbl.setForeground(Color.orange);
        lbl.setFont(new Font("Arial", Font.BOLD, 15));
    

        jp.add(lect);
        jp.add(stud);
        jp.add(adm);
        //jp.add(lbl);

        JLabel user = new JLabel();
        JLabel idLbl = new JLabel("Enter ID  ");
        JTextField id = new JTextField();
        JLabel passWord = new JLabel("Enter password  ");
        JPasswordField pass = new JPasswordField();
        JButton log = new JButton("Login");
        JLabel fail = new JLabel();

        idLbl.setBounds(20, 70, 150, 30);
        id.setBounds(20,100, 200,30 );
        passWord.setBounds(20, 160, 150, 30);
        pass.setBounds(20, 190, 200, 30);
        log.setBounds(20, 270, 150, 30);
        fail.setBounds(20, 310,300, 30);

        idLbl.setForeground(Color.ORANGE);
        id.setBackground(Color.WHITE);
        passWord.setForeground(Color.ORANGE);
        pass.setBackground(Color.WHITE);
        log.setBackground(Color.ORANGE);
        user.setFont(new Font("Arial", Font.BOLD, 20));
        user.setForeground(Color.ORANGE);
        fail.setForeground(Color.ORANGE);
        fail.setFont(new Font("Arial", Font.BOLD, 14));

        
        //jp2.add(user);
        jp2.add(idLbl);
        jp2.add(id);
        jp2.add(passWord);
        jp2.add(pass);
        jp2.add(log);
        jp2.add(fail);

        //jp2 panel only visible if buttons in jp clicked
        jp2.setVisible(false);

//==============Panel1=============================================
        lect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                user.setText("LECTURER LOGIN");
                jp2.setVisible(true);
                user.setBounds(80, 10, 200, 30);
                jp2.add(user);
                
            }

        });

        stud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                user.setText("STUDENT LOGIN");
                jp2.setVisible(true);
                user.setBounds(85, 10, 200, 30);
                jp2.add(user);

            }

        });

        adm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                user.setText("ADMINISTRATOR LOGIN");
                jp2.setVisible(true);
                user.setBounds(45, 10, 250, 30);
                jp2.add(user);

            }

        });
        // NOT PERFECT NEEDS FIXING STILL
        log.addActionListener(new ActionListener()   {
            public void actionPerformed(ActionEvent ae)  {
                try {
                    String filename = "admin";


                    if (user.getText().compareTo("STUDENT LOGIN") == 0) {
                        filename = "student";
                    }

                    else if (user.getText().compareTo("LECTURER LOGIN") == 0) {
                        filename = "lecturer";
                    }

                    readData r = new readData(filename);
                    if (r.compareUser(readData.getUserID(), readData.getUserP(), id.getText(), String.valueOf(pass.getPassword())) == false ) {
                        fail.setText("WRONG USER ID/PASSWORD. PLEASE TRY AGAIN");
                    }
                    else if (r.compareUser(readData.getUserID(), readData.getUserP(), id.getText(), String.valueOf(pass.getPassword())) == true ){
                        fail.setText("Access Granted Welcome");
                        //new AdmHome();
                        if (filename.compareTo("admin") == 0) {
                            setVisible(false);
                            new AdminPage();
                        }
                        else if (filename.compareTo("lecturer") == 0) {
                            setVisible(false);
                            new LecturerPage();
                        }
                        else if (filename.compareTo("student") == 0) {
                            setVisible(false);
                            new StudentP();
                        }

                    }
                    //System.out.println(r.compareUser(readData.getUserID(), readData.getUserP(), id.getText(), String.valueOf(pass.getPassword())));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                
                // System.out.println(user.getText());    differentiate the users
                


            
                //compare passwords
                //System.out.println(String.valueOf(pass.getPassword()).compareTo("Ron_26"));


            }

        });
        jp.setBounds(10,0,330,110);
        jp2.setBounds(10, 120, 330, 350);


        jp.setBackground(LIGHT_SAI_COLOR);
        jp2.setBackground(LIGHT_SAI_COLOR);


        jp.setBorder(br);
        jp2.setBorder(br);


        c.add(jp);
        c.add(jp2);


        setVisible(true);
        setBounds(100,100,370,520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
    }

    public static void main(String[] args) {
        
        new gui();

    }  

    public static final Color LIGHT_SAI_COLOR = new Color(19,19,70);
}