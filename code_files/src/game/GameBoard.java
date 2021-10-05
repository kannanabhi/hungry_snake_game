package game;
//import java.util.*;
import java.lang.Math;

public class GameBoard {

	private Square[][] board;
	private Snake snek = new Snake();
	
	
	GameBoard() {
		this(15);
	}
	GameBoard(int n) {
		board = new Square[n][n];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				board[x][y] = new Square(x, y);
			}
		}
	}
	
	public boolean isBoundary(Square sq) {
		if (sq.getX() == 0 || sq.getX() == board.length-1 
				|| sq.getY() == 0 || sq.getY() == board.length-1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void generateFood() {
		int x, y;
		do {
			x = (int) (Math.random() * board.length);
			y = (int) (Math.random() * board.length);
		} while (board[x][y].getType() != 0);
		
		board[x][y].makeFOOD();
	}
	
	public boolean gameOver() {
		return snek.hitBoundary(board.length) || snek.hitItself();
	}

	

	public void displayGameBoard() {
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
