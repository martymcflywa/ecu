import java.util.Scanner;
import java.io.*;

/**
 * A program to count the number of lines, words and characters in a text file.
 * Student to complete.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140908
 */

public class WordCount {
	
	// declaring variables to store counts
	static int wordCount = 0;
	static int lineCount = 0;
	static int charCount = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
       
		// get the filename
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the name of the file: ");
        String filename = keyboard.next();
        
        // close keyboard Scanner
        keyboard.close();
        
        // call methods
        lines(filename);
        words(filename);
        characters(filename);
        
	}
	
    /**
     * Count the number of lines in a file, and print out the result.
     * Don't forget to close the file when done.
     */
    public static void lines(String filename) throws FileNotFoundException {
    	
    	// open file
    	File file = new File(filename);
    	
    	// if file exists, continue with program
    	if(file.exists()) {
    		
	    	// create lineScan Scanner
	    	Scanner lineScan = new Scanner(file);
	    	
	    	// count lines
	    	while(lineScan.hasNext()) {
	    		lineScan.nextLine();
	    		lineCount++;
	    	}
	    	
	    	// print line count result
	    	System.out.println("This file contains " + lineCount + " lines");
	    	
	    	// close lineScan Scanner
	    	lineScan.close();
	    	
	    // else file does not exist, show error message
    	} else {
    		System.out.println("File does not exist! Start again.");
    	}
    }
    
    /**
     * Count the number of words in a file, and print out the result.
     * Don't forget to close the file when done.
     */
    public static void words(String filename) throws FileNotFoundException {
    	
    	// open file
    	File file = new File(filename);
    	
    	// if file exists, continue with program - else defined by lines()
    	if(file.exists()) {
    		
	    	// create wordScan Scanner
	    	Scanner wordScan = new Scanner(file);
	    	
	    	// count words
	    	while(wordScan.hasNext()) {
	    		wordScan.next();
	    		wordCount++;
	    	}
	    	
	    	// print word count result
	    	System.out.println("This file contains " + wordCount + " words");
	    	
	    	// close wordScan Scanner
	    	wordScan.close();
    	}
    }
    
    /**
     * Count the number of characters in a file, and print out the result.
     * Don't forget to close the file when done.
     */
    public static void characters(String filename) throws FileNotFoundException {
    	
    	// open file
    	File file = new File(filename);
    	
    	// if file exists, continue with program - else defined by lines()
    	if(file.exists()) {
    		
	    	// create charScan Scanner
	    	Scanner charScan = new Scanner(file);
	    	
	    	// count characters
	    	while(charScan.hasNext()) {
	    		String line = charScan.nextLine();
	    		charCount += line.length();
	    	}
	    	
	    	// print letter count result
	    	System.out.println("This file contains " + charCount + " characters");
	    	
	    	// close charScan Scanner
	    	charScan.close();
    	}
    }
}
