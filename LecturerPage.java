/* 
    - Upload content of mini project
    - Publish to registered students (Based on spec)
    - Modify Mini Project
    - View all their projects 
        1.Un/assign students to project
        2.De/Activate projects
*/

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LecturerPage extends JFrame {

    ArrayList<Project> projects;

    public LecturerPage() {
        // Set the title and layout for the JFrame
        super("Lecturer Page");
        setLayout(null);
        Border br = BorderFactory.createLineBorder(Color.black);
        Container c = getContentPane();

        // Create the two panels for the application
        JPanel panel1 = new JPanel(); // Main Menu Page
        JPanel panel2 = new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);

        // Create the buttons for panel1
        JButton uploadContent = new JButton("Upload Content");
        JButton addProject = new JButton("Add project");
        JButton editProject = new JButton("Edit project");
        JButton modifyProject = new JButton("Modify Project");
        JButton viewProject = new JButton("View Project");
        JButton logOut = new JButton("Logout");

        // Set the bounds for the buttons in panel1
        uploadContent.setBounds(10, 10, 150, 30);
        addProject.setBounds(10, 50, 150, 30);
        editProject.setBounds(170, 10, 150, 30);
        modifyProject.setBounds(170, 50, 150, 30);
        viewProject.setBounds(330, 10, 150, 30);
        logOut.setBounds(330, 50, 150, 30);

        // Add the buttons to panel1
        panel1.add(uploadContent);
        panel1.add(addProject);
        panel1.add(editProject);
        panel1.add(modifyProject);
        panel1.add(viewProject);
        panel1.add(logOut);

        // <-------------- Panel 2 -------------->
        // Create the components for panel2
        JLabel panelTitle = new JLabel();
        JLabel projectName = new JLabel("Project name: ");
        JTextField nameField = new JTextField();
        JButton enter = new JButton("ENTER");
        JLabel info = new JLabel();

        // Set the bounds for the components in panel2
        projectName.setBounds(10, 50, 150, 30);
        nameField.setBounds(160, 50, 250, 30);
        enter.setBounds(420, 50, 150, 30);
        info.setBounds(10, 90, 150, 30);

        // Set the font and color for the panelTitle label
        panelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitle.setForeground(Color.ORANGE);
        info.setForeground(Color.ORANGE);

        // Add the components to panel2
        panel2.add(projectName);
        panel2.add(nameField);
        panel2.add(enter);
        panel2.add(info);

        // Set panel2 to be not visible by default
        panel2.setVisible(false);

        // Add action listeners for the buttons in panel1
        uploadContent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Set the title for panel2 and clear the input fields
                panelTitle.setText("UPLOAD CONTENT");
                nameField.setText("");
                info.setText("");

                // Make Panel 2 visible
                panel2.setVisible(true); 

                // When the enter button is clicked, create a new project with the specified name and add it to the list of projects
                enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        String projectName = nameField.getText();
                        if (projectName.equals("")) {
                            // If the name field is empty, display an error message
                            info.setText("Please enter a project name.");
                        } else {
                            // Create a new project with the specified name and add it to the list
                            Project newProject = new Project(projectName);
                            projects.add(newProject);

                            // Display a success message
                            info.setText("Project added successfully.");
                        }
                    }
                });
            }
        });

        editProject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Set the title for panel2 and clear the input fields
                panelTitle.setText("Edit PROJECT");
                nameField.setText("");
                info.setText("");
                panel2.setVisible(true);

                // When the enter button is clicked, delete the project with the specified name
                // from the list of projects
                enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        String projectName = nameField.getText();
                        if (projectName.equals("")) {
                            // If the name field is empty, display an error message
                            info.setText("Please enter a project name.");
                        } else {
                            // Search for the project with the specified name in the list
                            Project projectToDelete = null;
                            for (Project p : projects) {
                                if (p.getProjectName().equals(projectName)) {
                                    projectToDelete = p;
                                    break;
                                }
                            }
                            if (projectToDelete == null) {
                                // If the project is not found, display an error message
                                info.setText("Project not found.");
                            } else {
                                // Delete the project from the list and display a success message
                                projects.remove(projectToDelete);
                                info.setText("Project deleted successfully.");
                            }
                        }
                    }
                });
            }
        });

        // logOut action listener : direct user back to main login page
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new gui();
            }
        });

        panel1.setBounds(10, 0, 485, 110);
        panel2.setBounds(85, 120, 330, 350);

        panel1.setBackground(LIGHT_SAI_COLOR);
        panel2.setBackground(LIGHT_SAI_COLOR);

        panel1.setBorder(br);
        panel2.setBorder(br);

        // Add the panels to the JFrame and set the size and location
        c.add(panel1);
        c.add(panel2);
        panel1.setBounds(10, 0, 485, 110);
        panel2.setBounds(85, 120, 330, 350);

        panel1.setBorder(br);
        panel2.setBorder(br);

        c.add(panel1);
        c.add(panel2);

        setBounds(100, 100, 520, 520);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // setSize(650, 250);
        // setLocation(500, 280);

        setVisible(true);
    }

    public static final Color LIGHT_SAI_COLOR = new Color(19, 19, 70);
}
