package game;
import java.util.*;

public class Snake {
	private LinkedList<Square> snake;
	private int direction;
	final int NORTH = 0,
			EAST = 1,
			SOUTH = 2,
			WEST = 3;
	
	Snake() {
		snake = new LinkedList<Square>();
		Square head = new Square(0,2);
		Square t1 = new Square(0,1);
		Square t2 = new Square(0,0);
		head.makeSNAKE();
		t1.makeSNAKE();
		t2.makeSNAKE();
		snake.add(head);
		snake.add(t1);
		snake.add(t2);
		direction = EAST;
	}

	
	public boolean hitBoundary(int n) {
		boolean hit = false;
		Square head = snake.get(0);
		if (direction == EAST) {
			hit = head.getY() == n-1;
		}
		else if (direction == SOUTH) {
			hit = head.getX() == n-1;
		}
		else if (direction == NORTH)  {
			hit = head.getX() == 0;
		}
		else {
			hit = head.getY() == 0;
		}
		return hit;
	}

	public boolean hitItself() {
		boolean hit = false;
		Square head = snake.get(0);
		int x_death, y_death;
		if (direction == EAST) {
			x_death = head.getX();
			y_death = head.getY()+1;
		}
		else if (direction == SOUTH) {
			x_death = head.getX()+1;
			y_death = head.getY();
		}
		else if (direction == NORTH)  {
			x_death = head.getX()-1;
			y_death = head.getY();
		}
		else {
			x_death = head.getX();
			y_death = head.getY()-1;
		}
		for (int i = 1; i < snake.size(); i++) {
			if (snake.get(i).getX() == x_death && snake.get(i).getY() == y_death) {
				hit = true;
				break;
			}
		}
		return hit;
	}
		
	public void moveOne() {
		
		for (Square sq : snake) {
			if (direction == EAST) {
				
			}
			else if (direction == SOUTH) {
				
			}
			else if (direction == WEST) {
				
			}
			else {
				
			}
		}
	}
	
}
