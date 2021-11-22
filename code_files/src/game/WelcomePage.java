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
	
    JFrame frame;
    JPanel panel;
    
	public WelcomePage() {
		frame = new JFrame();
		//frame.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
		panel.setLayout(new GridLayout(0,1));
		panel.setBackground(Color.BLACK);
		
		JLabel label = new JLabel("WELCOME TO HUNGRY SNAKE GAME!!");
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		userLabel = new JLabel("Username");  
        userLabel.setForeground(Color.WHITE);
        
        textField1 = new JTextField(15);
        
        passLabel = new JLabel("Password");  
        passLabel.setForeground(Color.WHITE);
        
        textField2 = new JPasswordField(15); 
        
        b1 = new JButton("SUBMIT"); 
        panel.add(userLabel);      
        panel.add(textField1);     
        panel.add(passLabel);      
        panel.add(textField2);     
        panel.add(b1); 
        b1.addActionListener(this);
        
        JButton signup = new JButton("SIGNUP");
        panel.add(signup);
        signup.addActionListener(new SignUp());
        
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(1600, 1600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HUNGRY SNAKE GAME");
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String userValue = textField1.getText();          
        String passValue = textField2.getText();          
        
        Player p = new Player(userValue, passValue);
        
        //TODO: connect to LeaderBoard class to verify credentials
        if (p.authenticate() == true) {  
            SuccessfullLogin page = new SuccessfullLogin(userValue);  
    
//            JLabel wel_label = new JLabel("Welcome: "+userValue);  
//            page.getContentPane().add(wel_label);  
        }  
        else{  
            //TODO: throw exception  
//            System.out.println("Pleasevalid username and password"); 
        	JLabel l = new JLabel("Please enter valid username and password");
        	l.setForeground(Color.WHITE);
        	panel.add(l);
        	
        	frame.add(panel);
        	frame.setVisible(true);
        }  
	}
	
	private class SignUp extends JPanel implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frame = new JFrame();
			
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
			panel.setLayout(new GridLayout(0,1));
			panel.setBackground(Color.BLACK);
			
			JLabel label = new JLabel("Signup Page");
			label.setForeground(Color.WHITE);
			panel.add(label);
			
			userLabel = new JLabel();  
	        userLabel.setText("Username");
	        userLabel.setForeground(Color.WHITE);
	        
	        JTextField textField1 = new JTextField(15);
	        
	        passLabel = new JLabel();  
	        passLabel.setText("Password");
	        passLabel.setForeground(Color.WHITE);
	        
	        JTextField textField2 = new JPasswordField(15); 
	        
	        b1 = new JButton("SUBMIT"); 
	        b1.addActionListener(new RegisterPlayer(textField1, textField2));
	        panel.add(userLabel);      
	        panel.add(textField1);     
	        panel.add(passLabel);      
	        panel.add(textField2);     
	        panel.add(b1); 
	        
	        frame.add(panel, BorderLayout.CENTER);
			frame.setSize(1600, 1600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("SIGNUP");
			frame.pack();
			frame.setVisible(true);
		}
		
		private class RegisterPlayer implements ActionListener {
			JTextField t1, t2;
			public RegisterPlayer(JTextField t1, JTextField t2) {
				this.t1 = t1;
				this.t2 = t2;
			}
			public void actionPerformed(ActionEvent arg0) {
				String userID = t1.getText();
				String pswd = t2.getText();
				Player p = new Player(userID, pswd, 0);
			}
		}
	
	}
	
}
