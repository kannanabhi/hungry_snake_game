package game;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Player implements Comparable<Player> {
	private String userID, userPswd;
	private int highscore;

	//for logging in
	public Player(String userID, String userPswd) {
		this.userID = userID;
		this.userPswd = userPswd;
		this.highscore = 0;
		
	}

	//used for signup 
	public Player(String userID, String userPswd, int highscore) {
		this.userID = userID;
		this.userPswd = userPswd;
		this.highscore = highscore;
		try {
			FileWriter fw = new FileWriter("D:/pilani_files/3-1/Object oriented programming/oops_project/code_files/src/game/database.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			String in = userID + " " + userPswd + " " + Integer.toString(highscore);
//			fw.write(in);
			pw.println(in);
			pw.flush();
			
			pw.close();
			bw.close();
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
	
	public int compareTo(Player p) {
		return 0;
	}

}