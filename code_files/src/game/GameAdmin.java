package game;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class GameAdmin extends JPanel implements ActionListener {

	JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
    static String userValue;
    static int board_size;
	//converted to static
    
    JFrame frame;
    JPanel panel;
    
	public GameAdmin() {
		frame = new JFrame();
		
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
        
        JButton btn = new JButton("DISPLAY LEADERBOARD");
        panel.add(btn);
        btn.addActionListener(new ShowLeaderboard());
        
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(1600, 1600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HUNGRY SNAKE GAME");
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		userValue = textField1.getText();          
        String passValue = textField2.getText();          
        
        Player p = new Player(userValue, passValue, false);
        
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
		
    private class ShowLeaderboard implements ActionListener {
    	static int size;
    	
    	public void actionPerformed(ActionEvent arg0) {
    		JFrame f1 = new JFrame();
    		JPanel p1 = new JPanel();
    		p1.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
    		ButtonGroup g = new ButtonGroup();
    		
    		p1.add(new JLabel("SELECT A BOARD SIZE"));
    		
    		JRadioButton b30 = new JRadioButton("30x30");
    		JRadioButton b40 = new JRadioButton("40x40");
    		JRadioButton b50 = new JRadioButton("50x50");
    		JRadioButton b60 = new JRadioButton("60x60");
    		JRadioButton b70 = new JRadioButton("70x70");
    		
    		g.add(b30);
    		g.add(b40);
    		g.add(b50);
    		g.add(b60);
    		g.add(b70);
    		
    		b30.addActionListener(new b30());
    		b40.addActionListener(new b40());
    		b50.addActionListener(new b50());
    		b60.addActionListener(new b60());
    		b70.addActionListener(new b70());
    		
    		JButton view = new JButton("VIEW");
    		view.addActionListener(new View());
    		
    		p1.add(b30);
    		p1.add(b40);
    		p1.add(b50);
    		p1.add(b60);
    		p1.add(b70);
    		p1.add(view);
    		f1.add(p1);
    		
    		f1.add(p1, BorderLayout.CENTER);
    		f1.setSize(400, 600);
//    		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		f1.setTitle("Leaderboard Size Selection");
    		f1.pack();
    		f1.setVisible(true);    		
    	}
    	private class View implements ActionListener {
    		public void actionPerformed(ActionEvent arg0) {
    			ArrayList<String> ans = Leaderboard.displayScore(size);
        		JFrame f = new JFrame();
        		JPanel p = new JPanel();

        		p.setBorder(BorderFactory.createEmptyBorder(75,75,75,75));
        		for (String s : ans) {
        			JLabel l = new JLabel(s);
        			p.add(l);
        		}
        		
        		f.add(p, BorderLayout.CENTER);
        		f.setSize(400, 600);
        		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		f.setTitle("Leaderboard Display");
        		f.pack();
        		f.setVisible(true);
    		}
    	}
    	private class b30 implements ActionListener {
    		public void actionPerformed(ActionEvent arg0) {
    			size = 30;
    		}
    	}
    	private class b40 implements ActionListener {
    		public void actionPerformed(ActionEvent arg0) {
    			size = 40;
    		}
    	}
    	private class b50 implements ActionListener {
    		public void actionPerformed(ActionEvent arg0) {
    			size = 50;
    		}
    	}
    	private class b60 implements ActionListener {
    		public void actionPerformed(ActionEvent arg0) {
    			size = 60;
    		}
    	}
    	private class b70 implements ActionListener {
    		public void actionPerformed(ActionEvent arg0) {
    			size = 70;
    		}
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
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				Player p = new Player(userID, pswd, true);
			}
		}
	}
	
	public static void updateScore(int newScore, int size) {
		//use Leaderboard method
//		System.out.println(newScore);
		Leaderboard.updateScore(userValue, newScore, size);
	}
}
