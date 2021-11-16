package game;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SuccessFullLogin extends JFrame implements ActionListener{
	
	public SuccessFullLogin() {
		JFrame frame = new JFrame();

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));

		JButton button1 = new JButton("PLAY");
		JButton button2 = new JButton("CONTROLS");
		
		button1.addActionListener(this);
		
		panel.add(button1);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HOMEPAGE");
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		GameBoard gb = new GameBoard();
	}
}
