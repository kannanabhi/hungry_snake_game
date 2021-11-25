package game;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Player {
	private String userID, userPswd;

	public Player(String userID, String userPswd, boolean signup) {
		this.userID = userID;
		this.userPswd = userPswd;
		if (signup == true) {
			try {
				FileWriter fw = new FileWriter("D:/pilani_files/3-1/Object oriented programming/oops_project/code_files/src/game/database.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				String in = userID + " " + userPswd + " 0 0 0 0 0";
				pw.println(in);
				pw.flush();
				
				pw.close();
				bw.close();
				fw.close();
			} catch (IOException e) {
				System.out.println(e);
			}
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