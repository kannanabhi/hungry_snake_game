package game;
import java.util.*;


public class Snake {
	private LinkedList<Square> snake;
	private int direction;
	public static final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
	
	Snake() {
		snake = new LinkedList<Square>();
		Square head = new Square(2,0);
		Square t1 = new Square(1,0);
		Square t2 = new Square(0,0);
		head.makeSNAKE();
		t1.makeSNAKE();
		t2.makeSNAKE();
		snake.add(head);
		snake.add(t1);
		snake.add(t2);
		direction = EAST;
	}

	private boolean hitBoundary(int n) {
		boolean hit = false;
		Square head = getHead();
		if (direction == EAST) {
			hit = head.getX() == n-1;
		}
		else if (direction == SOUTH) {
			hit = head.getY() == n-1;
		}
		else if (direction == NORTH)  {
			hit = head.getY() == 0;
		}
		else {
			hit = head.getX() == 0;
		}
		return hit;
	}

	private boolean hitItself() {
		boolean hit = false;
		Square head = getHead();
		int x_death, y_death;
		if (direction == EAST) {
			x_death = head.getX()+1;
			y_death = head.getY();
		}
		else if (direction == SOUTH) {
			x_death = head.getX();
			y_death = head.getY()+1;
		}
		else if (direction == NORTH)  {
			x_death = head.getX();
			y_death = head.getY()-1;
		}
		else {
			x_death = head.getX()-1;
			y_death = head.getY();
		}
		for (int i = 1; i < snake.size(); i++) {
			if (snake.get(i).getX() == x_death && snake.get(i).getY() == y_death) {
				hit = true;
				break;
			}
		}
		return hit;
	}
		
	public boolean gameOver(int n) {
		return hitBoundary(n) || hitItself();
	}
	
	public void moveOne() {
		snake.removeLast();
		Square head = this.getHead();
		if (direction == NORTH) {
			snake.addFirst(new Square(head.getX(), head.getY()-1));
		}
		else if (direction == EAST) {
			snake.addFirst(new Square(head.getX()+1, head.getY()));
		}
		else if (direction == SOUTH) {
			snake.addFirst(new Square(head.getX(), head.getY()+1));
		}
		else {
			snake.addFirst(new Square(head.getX()-1, head.getY()));
		}
	}
	
	public void growOne() {
		Square head = this.getHead();
		if (direction == NORTH) {
			snake.addFirst(new Square(head.getX(), head.getY()-1));
		}
		else if (direction == EAST) {
			snake.addFirst(new Square(head.getX()+1, head.getY()));
		}
		else if (direction == SOUTH) {
			snake.addFirst(new Square(head.getX(), head.getY()+1));
		}
		else {
			snake.addFirst(new Square(head.getX()-1, head.getY()));
		}
	}
	
	public int getDirection() { return direction; }
	public void setDirection(int direction) { this.direction = direction; }
	public LinkedList<Square> getSnake() { return snake; }
	public Square getHead() { return snake.getFirst(); }
	public int getLength() { return snake.size(); }
	
}
