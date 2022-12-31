


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

// ADD PROJECT AND VIEW PROJECT IS NOT DONE YET

//Done By Emad
public class AdminPage extends JFrame {

    public AdminPage(){
        super("Administrator Page");
        setLayout(null);
        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);

        JButton addStud = new JButton("Add student");
        JButton addLect = new JButton("Add lecturer");
        JButton addAdm = new JButton("Add administrator");
        JButton logOut = new JButton("Logout");
        JButton addP = new JButton("Add project");
        JButton viewP = new JButton("View Projects");

        addStud.setBounds(10, 10, 150, 30);
        addLect.setBounds(10, 50, 150, 30);
        addAdm.setBounds(170, 10, 150, 30);
        logOut.setBounds(170, 50, 150, 30);
        addP.setBounds(330, 10, 150, 30);
        viewP.setBounds(330, 50, 150, 30);


        panel1.add(addStud);
        panel1.add(addLect);
        panel1.add(addAdm);
        panel1.add(logOut);
        panel1.add(addP);
        panel1.add(viewP);

        JLabel panelTitle = new JLabel();
        JLabel enterN = new JLabel();
        JLabel sp = new JLabel("Choose the specialization : ");
        JTextField userName = new JTextField();
        JButton enter = new JButton("ENTER");
        JLabel info = new JLabel();
        JLabel info2 = new JLabel();
        JLabel info3 = new JLabel();

        String[] specialization = {"SOFTWARE ENGINEERING","CYBERSECURITY","DATA SCIENCE", "GAME DEVELOPMENT"};
        JComboBox sList = new JComboBox(specialization);

        
        userName.setBounds(10, 80, 250, 30);
        sp.setBounds(10, 120, 250, 30);
        sList.setBounds(10, 150, 250, 30);
        enter.setBounds(90, 200, 150, 30);
        info.setBounds(10, 240, 150, 30);
        info2.setBounds(10, 280, 150, 30);
        info3.setBounds(10, 320, 150, 30);

        enterN.setForeground(Color.ORANGE);
        sp.setForeground(Color.ORANGE);
        panelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitle.setForeground(Color.ORANGE);
        info.setForeground(Color.ORANGE);
        info2.setForeground(Color.ORANGE);
        info3.setForeground(Color.ORANGE);


        
        panel2.add(userName);
        panel2.add(sp);
        panel2.add(enter);
        panel2.add(info);
        panel2.add(info2);
        panel2.add(info3);

        //panel 2 only visible if buttons in jp clicked
        panel2.setVisible(false);
        panel3.setVisible(false);

//==============Panel 2=============================================
        addLect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                userName.setText("");
                info.setText("");
                sList.setVisible(false);
                sp.setVisible(false);
                panelTitle.setText("NEW LECTURER");
                enterN.setText("Lecturer name : ");
                panel2.setVisible(true);
                enterN.setBounds(10, 50, 150, 30);
                panelTitle.setBounds(90, 10, 200, 30);
                panel2.add(enterN);
                panel2.add(panelTitle);

                
            }

        });

        addAdm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                userName.setText("");
                info.setText("");
                sList.setVisible(false);
                sp.setVisible(false);
                panelTitle.setText("NEW ADMINISTRATOR");
                enterN.setText("Admin name : ");
                panel2.setVisible(true);
                enterN.setBounds(10, 50, 150, 30);
                panelTitle.setBounds(60, 10, 300, 30);
                panel2.add(enterN);
                panel2.add(panelTitle);
                
            }

        });

        addStud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                userName.setText("");
                info.setText("");
                panelTitle.setText("NEW STUDENT");
                enterN.setText("Student name : ");
                panel2.setVisible(true);
                enterN.setBounds(10, 50, 150, 30);
                panelTitle.setBounds(90, 10, 300, 30);
                panel2.add(enterN);
                panel2.add(panelTitle);
                panel2.add(sList);
                sList.setVisible(true);
                sp.setVisible(true);
                
            }

        });

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                

                try {
                    String fileName = "";
                    String randID = "";
                    String randpass = "";
                    int min = 0;
                    int max = 0;
                    if (enterN.getText().compareTo("Admin name : ") == 0)  {
                        fileName = "admin";
                        min = 10000;
                        max = 19999;
                    }
                    else if (enterN.getText().compareTo("Lecturer name : ") == 0)  {
                        fileName = "lecturer";
                        min = 20000;
                        max = 29999;
                    }
                    else if (enterN.getText().compareTo("Student name : ") == 0)  {
                        fileName = "student";
                        min = 30000;
                        max = 39999;
                    }

                    readData r = new readData(fileName);
              
                    
                    if (r.compareName(readData.getUserN(), userName.getText().toUpperCase()) == true) {
                        info.setText("NAME ALREADY EXIST");
                        info2.setText("");
                        info3.setText("");
                        readData.getPerson().clear();
                        readData.getStudent().clear();
   
                    }

                    else if (userName.getText().isEmpty()){
                        info.setText("PLEASE TYPE THE NAME !!");
                        info2.setText("");
                        info3.setText("");
                        readData.getPerson().clear();
                        readData.getStudent().clear();
                    
                    }
                    else if (r.compareName(readData.getUserN(), userName.getText().toUpperCase()) == false){
                        info.setText("Name = "+userName.getText().toUpperCase());
                        while (r.compareID(readData.getUserID(), r.getRandID(min,max)) != true){
                            randID = r.getRandID(min,max);
                            info2.setText("User ID = " + randID);

                        }
                        randpass = r.getPass();
                        info3.setText("Password = " + randpass);


                        if (fileName.compareTo("lecturer") == 0 || fileName.compareTo("admin") == 0) {
                            readData.getPerson().add(new Person(randID,userName.getText().toUpperCase() , randpass));
                            //person.add(new Person(info2.getText(),info.getText() , info3.getText()));
                            readData.saveUserToFile(readData.getPerson(), fileName);
                        }

                        else if (fileName.compareTo("student") == 0 ) {
                            readData.getStudent().add(new Student(randID,userName.getText().toUpperCase() , randpass, specialization[sList.getSelectedIndex()] ));
                            //person.add(new Person(info2.getText(),info.getText() , info3.getText()));
                            readData.saveStudToFile(readData.getStudent(), fileName);
                        }


                        

                        

                        
                        //info.setText("Name = " + userName.getText() + "\n" + "UserId = 1201010\n" + "Password = hrsh9h");
                    }

                    

                    // System.out.println("Name = " + info.getText() + "\nUserID = " + info2.getText() + "\nPassword = " + 
                    // info3.getText());


                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }

        });


        addAdm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                userName.setText("");
                info.setText("");
                sList.setVisible(false);
                sp.setVisible(false);
                panelTitle.setText("NEW ADMINISTRATOR");
                enterN.setText("Admin name : ");
                panel2.setVisible(true);
                enterN.setBounds(10, 50, 150, 30);
                panelTitle.setBounds(60, 10, 300, 30);
                panel2.add(enterN);
                panel2.add(panelTitle);
                
            }

        });

        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new gui();
 
            }

        });

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.out.println("Closed");
                //setVisible(false);
                new gui();

               
                
                //e.getWindow().dispose();
                
            }
            
        });


// //==============Panel3=============================================
//         addStud.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent ae) {
//                 panelTitle.setText("NEW STUDENT");
//                 enterN.setText("Student name : ");
//                 panel3.setVisible(true);
//                 panel2.setVisible(false);
//                 enterN.setBounds(10, 50, 150, 30);
//                 panelTitle.setBounds(90, 10, 200, 30);
//                 panel3.add(enterN);
//                 panel3.add(panelTitle);
//                 panel3.add(enter);

                
//             }

//         });
        //panel2.add(lbl);
        // panel2.add(lbl);
        // panel2.add(txt);
        // panel2.add(combo);

        panel1.setBounds(10,0,485,110);
        panel2.setBounds(85, 120, 330, 350);
        panel3.setBounds(85, 120, 330, 350);


        panel1.setBackground(LIGHT_SAI_COLOR);
        panel2.setBackground(LIGHT_SAI_COLOR);
        panel3.setBackground(LIGHT_SAI_COLOR);


        panel1.setBorder(br);
        panel2.setBorder(br);
        panel3.setBorder(br);


        c.add(panel1);
        c.add(panel2);
        c.add(panel3);


        setVisible(true);
        setBounds(100,100,520,520);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public static final Color LIGHT_SAI_COLOR = new Color(19,19,70);


    public static void main(String[] args) {
        new AdminPage();
    }


    
}
