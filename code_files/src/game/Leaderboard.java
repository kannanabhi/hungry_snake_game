package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class Leaderboard {
	//for updating score
	public static void updateScore(String userID, int score) {
		FileReader fr;
		try {
			fr = new FileReader("D:/pilani_files/3-1/Object oriented programming/oops_project/code_files/src/game/database.txt");
			BufferedReader file = new BufferedReader(fr);
			StringBuffer inputBuffer = new StringBuffer();
			String line;
			String toReplace = null;
			String replaceWith = null;
			while ((line = file.readLine()) != null) {
				String[] arr = line.split("\\s");
				if (arr[0].equals(userID) && Integer.parseInt(arr[2]) < score) {
//					System.out.println("condition met");
					toReplace = line;
					replaceWith = arr[0] + " " + arr[1] + " " + Integer.toString(score);
				}
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        file.close();
	        String inputStr = inputBuffer.toString();
	        
	        if (toReplace != null) {
	        	inputStr = inputStr.replace(toReplace, replaceWith);
	        	FileOutputStream fileOut = new FileOutputStream("D:/pilani_files/3-1/Object oriented programming/oops_project/code_files/src/game/database.txt");
	            fileOut.write(inputStr.getBytes());
	            fileOut.close();
	        }
	        
		} catch (Exception e) {
			System.out.println("prob reading file");
		}
		
	}
	
	public static ArrayList<String> displayScore() {
		ArrayList<String> ans = new ArrayList<String>();
		FileReader fr;
		try {
			fr = new FileReader("D:/pilani_files/3-1/Object oriented programming/oops_project/code_files/src/game/database.txt");
			BufferedReader file = new BufferedReader(fr);
			String line;
			while ((line = file.readLine()) != null) {
				String[] arr = line.split("\\s");
				ans.add(arr[0] + "--" + arr[2] + "\n");
				System.out.println(arr[0] + "--" + arr[2] + "\n");
			}
		} catch (Exception e) {
			System.out.println("prob displaying file");
		}
		return ans;
	}
}
