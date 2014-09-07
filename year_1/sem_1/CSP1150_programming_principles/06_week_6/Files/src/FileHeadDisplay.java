import java.util.Scanner;
import java.io.*;

/**
 * Requests input from user for filename and displays first 5 lines of that file (header).
 * If the file contains fewer than 5 lines, display all contents.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140908
 */

// see FileReadDemo.java pp. 245, and task pp. 269
public class FileHeadDisplay {
	
	static String fileName;
	static int lines = 0;
	
	// main calls methods to start program
	public static void main(String[] args) throws IOException {
		getUserInput();
		readFile();
	}
	
	/**
	 * @return Get filename from user
	 */
	static void getUserInput() {
		
		// create Scanner object for keyboard input
		Scanner kb = new Scanner(System.in);
		
		// get filename and send result to fileName
		System.out.print("Enter the filename: ");
		fileName = kb.nextLine();
		
		// close keyboard Scanner
		kb.close();
	}
	
	/**
	 * @return Counts lines in text file. If lines > 5, print 5 lines, else print all lines.
	 * @throws IOException
	 */
	static void readFile() throws IOException {
		
		// create File object to open file
		File file = new File(fileName);
		
		// if file exists, continue with program
		if(file.exists()) {
			
			// create inputFile Scanner to read file
			Scanner inputFile = new Scanner(file);
			
			// create countLines Scanner to count lines
			Scanner countLines = new Scanner(file);
			
			// count how many lines in the file
			while(countLines.hasNext()) {
				countLines.nextLine();
				lines ++;
			}
			
			// close countLines
			countLines.close();
			
			// if lines > 5
			if(lines > 5) {
				
				// print 5 lines
				for(int i = 0; i < 5; i++) {
					String readLine = inputFile.nextLine();
					System.out.println(readLine);
				}
				
			// else print all lines
			} else { 
				for(int j = 0; j < lines; j++) {
					String readLine = inputFile.nextLine();
					System.out.println(readLine);
				}
			}
	
			// close inputFile
			inputFile.close();
			
		// else file does not exist, show error message
		} else {
			System.out.println("File does not exist. Start again.");
		}
	}
}
