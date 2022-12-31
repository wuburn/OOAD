import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StudentP extends JFrame{

	public StudentP() {
		super("Student Page");
		setLayout(null);
		setBounds(100,100,520,520);
		Border br = BorderFactory.createLineBorder(Color.black);
        Container c = getContentPane();
		
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		
		JButton viewContent = new JButton("View Content");
        JButton viewProject = new JButton("View Project");
        JButton logOut = new JButton("Logout");
        
        viewContent.setFocusable(false);
        viewProject.setFocusable(false);
        logOut.setFocusable(false);
        
        viewContent.setBounds(10, 40, 150, 30);
        viewProject.setBounds(330, 40, 150, 30);
        logOut.setBounds(170, 40, 150, 30);
        
        panel1.add(logOut);
        panel1.add(viewContent);
        panel1.add(viewProject);
        
        panel1.setBounds(10,0,485,110);
        panel1.setBackground(LIGHT_SAI_COLOR);
        c.add(panel1);

        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new gui();
            }
        });
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	}

    public static final Color LIGHT_SAI_COLOR = new Color(19,19,70);

	 public static void main(String[] args){
	        new StudentP();
	    }
}
