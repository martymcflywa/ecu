import java.io.*;

public class Spell {

    // Use our spell checker class to emulate the Unix spell command, i.e.,
    // read the words of an input text file, and output the list of words
    // not in the vocabulary.


    private static String readWord (BufferedReader input) {

        StringBuffer sb = new StringBuffer();
    	try {
    	    int ch = input.read();

    	    // Skip any non-letters on the input...
    	    while (ch != -1 && ! Character.isLetter((char) ch))
                    ch = input.read();

    	    // Read letters up to the first non-letter to form a word...
    	    while (ch != -1 && Character.isLetter((char) ch)) {
    	        sb.append(Character.toLowerCase((char) ch));
    	        ch = input.read();
    	    }
    	} catch (IOException e) {
    	    return null;
    	}

    	if (sb.length() > 0)
    	    return new String(sb);
    	else
    	    return null;
        }


    public static void main (String[] args) {
    	SpellChecker checker = new SpellChecker("main.hamlet", "user.hamlet");

    	try {
    	    BufferedReader text = new BufferedReader(
    		    new InputStreamReader(new FileInputStream(args[0])));
    	    String word = readWord(text);
    	    while (word != null) {
    		if (! checker.check(word))  System.out.println(word);
    		word = readWord(text);
    	    }
    	    text.close();
    	} catch (IOException e) {
    	    System.out.println(e.getMessage());
    	}
    }

}
