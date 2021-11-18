package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements ActionListener{
	
	private final int B_WIDTH, B_HEIGHT, ALL_DOTS, DOT_SIZE = 10, DELAY = 140;
    private Image ball, apple, head;
    private int size;
    
    private int x, y;
    
    private Timer timer;
    private boolean gameOver;
    
    Square[][] board;
    Snake snek;
    
    public GameBoard() {
    	this(30);
    }
    public GameBoard(int size) {
    	this.size = size;
    	//TODO: implement difficulty level
    	
    	B_WIDTH = DOT_SIZE * size;
    	B_HEIGHT = DOT_SIZE * size;
    	ALL_DOTS = size*size;
    	System.out.println("Gameboard initial size: " + ALL_DOTS);
    	
    	board = new Square[size][size];
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) {
    			board[i][j] = new Square(i, j);
    		}
    	} 
    	
    	//snek = new Snake();
    	
    	//implement GUI
    	initializeBoard();
    }
    
    private void initializeBoard() {
    	
    	addKeyListener(new TAdapter());
    	setBackground(Color.BLACK);
    	setFocusable(true);
    	
    	setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
    	loadImages();
    	initializeGame();
    }
    
    private void loadImages() {
    	ImageIcon iid = new ImageIcon("src/game/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/game/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/game/head.png");
        head = iih.getImage();
    }
    
    private void initializeGame() {
    	snek = new Snake();
    	generateFood();
    	
    	gameOver = false;
    	timer = new Timer(DELAY, this);
    	timer.start();
    }
    
    private void generateFood() {
		do {
			x = (int) (Math.random() * size);
			y = (int) (Math.random() * size);
		} while (board[x][y].getType() != Square.BLANK);
		
		board[x][y].makeFOOD();
	}
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
    	if (gameOver == false) {
    		g.drawImage(apple, x*DOT_SIZE, y*DOT_SIZE, this);
    		
    		LinkedList<Square> arr = snek.getSnake();
    		for (int i = 0; i < arr.size(); i++) {
    			Square current = arr.get(i);
    			if (i == 0) { 
    				g.drawImage(head, current.getX()*DOT_SIZE, current.getY()*DOT_SIZE, this); 
				}
    			else { 
    				g.drawImage(ball, current.getX()*DOT_SIZE, current.getY()*DOT_SIZE, this); 
				}
    		}
    		
    		Toolkit.getDefaultToolkit().sync();
    	} else {
    		gameOver(g);
    	}
    }
    
    private void gameOver(Graphics g) {
    	String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }
    
    private void checkIfEaten() {
    	Square head = snek.getHead();
    	if (x == head.getX() && y == head.getY()) {
    		board[x][y].makeBLANK();
    		snek.growOne();    		
    		generateFood();
    	}
    }
    
    private void checkGameOver() { 
    	if (snek.gameOver(size) == true) {
    		gameOver = true;
    		timer.stop();
    	}
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (gameOver == false) {
    		this.checkIfEaten();
    		this.checkGameOver();
    		snek.moveOne();
    	}
    	repaint();
    }
    
    private class TAdapter extends KeyAdapter {
    	public void keyPressed(KeyEvent arg0) {
    		int key = arg0.getKeyCode();
    		int direction = snek.getDirection();
    		
    		if ((key == KeyEvent.VK_LEFT) && (direction != Snake.EAST)) {
                snek.setDirection(Snake.WEST);
                System.out.println("left + " + snek.getDirection());
            }

    		else if ((key == KeyEvent.VK_RIGHT) && (direction != Snake.WEST)) {
    			snek.setDirection(Snake.EAST);
            }
    		
    		else if ((key == KeyEvent.VK_UP) && (direction != Snake.SOUTH)) {
    			snek.setDirection(Snake.NORTH);
            }
    		
    		else if ((key == KeyEvent.VK_DOWN) && (direction != Snake.NORTH)) {
    			snek.setDirection(Snake.SOUTH);
    			System.out.println("down");
            }
    		
    	}
    }
}
