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

public class SuccessfullLogin extends JFrame implements ActionListener{
	
	private int size = 30, speed = 140;
	
	public SuccessfullLogin(String userValue) {
		JFrame frame = new JFrame();
		//frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
		panel.setLayout(new GridLayout(0,1));

		JLabel wel_label = new JLabel("welcome " + userValue);
		panel.add(wel_label);
		
		JButton button1 = new JButton("PLAY");
		JButton button2 = new JButton("CONTROLS");
		
		button1.addActionListener(this);
		
		panel.add(button1);

		JButton b30 = new JButton("30x30");
		JButton b40 = new JButton("40x40");
		JButton b50 = new JButton("50x50");
		JButton b60 = new JButton("60x60");
		JButton b70 = new JButton("70x70");
		
		b30.addActionListener(new b30());
		b40.addActionListener(new b40());
		b50.addActionListener(new b50());
		b60.addActionListener(new b60());
		b70.addActionListener(new b70());
		
		panel.add(b30);
		panel.add(b40);
		panel.add(b50);
		panel.add(b60);
		panel.add(b70);
		
		JButton moderate = new JButton("moderate");
		JButton fast = new JButton("fast");
		JButton slow = new JButton("slow");
		
		panel.add(moderate);
		panel.add(fast);
		panel.add(slow);
		
		moderate.addActionListener(new moderate());
		fast.addActionListener(new fast());
		slow.addActionListener(new slow());
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HOMEPAGE");
		frame.pack();
		frame.setVisible(true);
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
	
	private class moderate implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			speed = 140;
		}
	}
	private class fast implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			speed = 100;
		}
	}
	private class slow implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			speed = 180;
		}
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO add option for controls
		add(new GameBoard(size, speed));
		setResizable(false);
		pack();
		setTitle("Snake");
		setLocationRelativeTo(null);
		// TODO add option to play again
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
