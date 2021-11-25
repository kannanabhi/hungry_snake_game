package game;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SuccessfullLogin extends JFrame implements ActionListener{
	
	private int size = 30, speed = 140;
	
	public SuccessfullLogin(String userValue) {
		JFrame frame = new JFrame();

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
		panel.setLayout(new GridLayout(0,1));

		JLabel wel_label = new JLabel("welcome " + userValue);
		panel.add(wel_label);
		
		JButton button1 = new JButton("PLAY");
		
		button1.addActionListener(this);
		
		panel.add(button1);
		
		JLabel board_size = new JLabel("BOARD SIZE");
		panel.add(board_size);

		JRadioButton b30 = new JRadioButton("30x30", true);
		JRadioButton b40 = new JRadioButton("40x40");
		JRadioButton b50 = new JRadioButton("50x50");
		JRadioButton b60 = new JRadioButton("60x60");
		JRadioButton b70 = new JRadioButton("70x70");
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(b30);
		group1.add(b40);
		group1.add(b50);
		group1.add(b60);
		group1.add(b70);
		
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
		
		JLabel speed_label = new JLabel("SPEED");
		panel.add(speed_label);
		
		JRadioButton moderate = new JRadioButton("moderate", true);
		JRadioButton fast = new JRadioButton("fast");
		JRadioButton slow = new JRadioButton("slow");
		
		ButtonGroup group = new ButtonGroup();
		group.add(moderate);
		group.add(fast);
		group.add(slow);
		
		panel.add(moderate);
		panel.add(fast);
		panel.add(slow);
		
		moderate.addActionListener(new moderate());
		fast.addActionListener(new fast());
		slow.addActionListener(new slow());
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setTitle("HOMEPAGE");
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		add(new GameBoard(size, speed));
		setResizable(false);
		pack();
		setTitle("Snake");
		setLocationRelativeTo(null);
		setVisible(true);
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
}
