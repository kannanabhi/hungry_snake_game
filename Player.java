package game;

import java.io.FileWriter;
import java.io.IOException;

public class Player {
	private String userID, userPswd;
	private int highscore;
	
	public Player(String userID, String userPswd, int highscore) {
		this.userID = userID;
		this.userPswd = userPswd;
		this.highscore = highscore;
		try {
			FileWriter fw = new FileWriter("database.txt");
			String in = userID + " " + userPswd + " " + Integer.toString(highscore);
			fw.write(in);
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
//	public boolean verifyCred(String userPswd) {
//		return userPswd.equals(this.userPswd);
//	}
//	public String getUserID() { return userID; }
	
	 
}
