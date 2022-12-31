import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

public class test {
  public static void main(String[] args) {
    // Create a new JFrame
    JFrame frame = new JFrame("File Upload Example");

    // Create a new button that opens the file chooser when clicked
    JButton chooseFileButton = new JButton("Choose File");
    chooseFileButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // Set the file chooser to only allow the selection of PDF files
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));

        // Show the file chooser and get the user's selection
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
          // The user selected a file, get it
          File selectedFile = fileChooser.getSelectedFile();

          // Print out the path of the selected file
          System.out.println("Selected file: " + selectedFile.getAbsolutePath());

          // Now you can do something with the selected file, such as upload it to a server
        }
      }
    });
    

    // Add the button to the frame and show the frame
    frame.add(chooseFileButton);
    frame.pack();
    frame.setVisible(true);
  }
}

