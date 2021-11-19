package game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Player {
	private String userID, userPswd;
	private int highscore;

	public Player(String userID, String userPswd) {
		this.userID = userID;
		this.userPswd = userPswd;
		System.out.println("player 1st constructor");
	}

	//used for signing up
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

	public boolean authenticate() {
		boolean flag = false;
		Scanner sc;
		try {
			sc = new Scanner(new File("D:/pilani_files/3-1/Object oriented programming/oops_project/code_files/src/game/database.txt"));
			while (sc.hasNextLine()) {
				String ln = sc.nextLine();
				String[] arr = ln.split("\\s");
				if (arr[0].equals(userID) && arr[1].equals(userPswd)) {
					flag = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}