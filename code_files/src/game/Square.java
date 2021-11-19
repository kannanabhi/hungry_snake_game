package game;

public class Square {

	private int x, y;
	private int type;
	public static final int BLANK = 0, SNAKE = 1, FOOD = 2;
	
	Square (int x, int y) {
		this.x = x;
		this.y = y;
		this.type = BLANK;
	}
	
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	
	public void makeBLANK() { type = BLANK; }
	public void makeSNAKE() { type = SNAKE;	}
	public void makeFOOD() { type = FOOD; }
	public int getType() { return this.type; }
	
}
