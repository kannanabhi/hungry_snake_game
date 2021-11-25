package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class Leaderboard {
	public static void updateScore(String userID, int score, int size) {
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
				if (arr[0].equals(userID)) {
					if (size == 30) {
						if (Integer.parseInt(arr[2]) < score) {
							System.out.println("condition met");
							toReplace = line;
							replaceWith = arr[0] + " " + arr[1] + " " + Integer.toString(score) + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6];
 						}
					}
					else if (size == 40) {
						if (Integer.parseInt(arr[3]) < score) {
							toReplace = line;
							replaceWith = arr[0] + " " + arr[1] + " " + arr[2] + " " + Integer.toString(score) + " " + arr[4] + " " + arr[5] + " " + arr[6]; 
 						}
					}
					else if (size == 50) {
						if (Integer.parseInt(arr[4]) < score) {
							toReplace = line;
							replaceWith = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + Integer.toString(score) + " " + arr[5] + " " + arr[6];
 						}
					}
					else if (size == 60) {
						if (Integer.parseInt(arr[5]) < score) {
							toReplace = line;
							replaceWith = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + Integer.toString(score) + " " + arr[6];
 						}
					}
					else {
						if (Integer.parseInt(arr[6]) < score) {
							toReplace = line;
							replaceWith = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + Integer.toString(score);
 						}
					}
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
	
	public static ArrayList<String> displayScore(int size) {
		ArrayList<String> ans = new ArrayList<String>();
		FileReader fr;
		try {
			fr = new FileReader("D:/pilani_files/3-1/Object oriented programming/oops_project/code_files/src/game/database.txt");
			BufferedReader file = new BufferedReader(fr);
			String line;
			while ((line = file.readLine()) != null) {
				String[] arr = line.split("\\s");
				if (size == 30) {
					ans.add(arr[0] + "--" + arr[2] + "\n");
				}
				else if (size == 40) {
					ans.add(arr[0] + "--" + arr[3] + "\n");
				}
				else if (size == 50) {
					ans.add(arr[0] + "--" + arr[4] + "\n");
				}
				else if (size == 60) {
					ans.add(arr[0] + "--" + arr[5] + "\n");
				}
				else {
					ans.add(arr[0] + "--" + arr[6] + "\n");
				}
			}
		} catch (Exception e) {
			System.out.println("prob displaying file");
		}
		return ans;
	}
}
