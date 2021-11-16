package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class WelcomePage extends JPanel implements ActionListener {

	JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
	
	public WelcomePage() {
		JFrame frame = new JFrame();

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.setBackground(Color.BLACK);
		
		JLabel label = new JLabel("WELCOME TO HUNGRY SNAKE GAME!!");
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		userLabel = new JLabel();  
        userLabel.setText("Username");
        userLabel.setForeground(Color.WHITE);
        
        textField1 = new JTextField(15);
        
        passLabel = new JLabel();  
        passLabel.setText("Password");
        passLabel.setForeground(Color.WHITE);
        
        textField2 = new JPasswordField(15); 
        
        b1 = new JButton("SUBMIT"); 
        panel.add(userLabel);    //set username label to panel  
        panel.add(textField1);   //set text field to panel  
        panel.add(passLabel);    //set password label to panel  
        panel.add(textField2);   //set text field to panel  
        panel.add(b1);           //set button to panel  
		
        b1.addActionListener(this); 
        
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(1600, 1600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HUNGRY SNAKE GAME");
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered pasword from the textField2  
        
        if (userValue.equals("test1@gmail.com") && passValue.equals("test")) {  //if authentic, navigate user to a new page  
            
            //create instance of the NewPage  
            SuccessFullLogin page = new SuccessFullLogin();  
              
            //make page visible to the user  
            page.setVisible(true);  
              
            //create a welcome label and set it to the new page  
            JLabel wel_label = new JLabel("Welcome: "+userValue);  
            page.getContentPane().add(wel_label);  
        }  
        else{  
            //show error message  
            System.out.println("Please enter valid username and password");  
        }  
	}
	
}
