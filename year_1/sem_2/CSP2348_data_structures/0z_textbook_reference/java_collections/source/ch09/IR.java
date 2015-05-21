import java.io.*;

import WattBrown.*;
import java.util.Iterator;

public class IR {

    private static String readWord
    				(InputStreamReader input)
    				throws IOException {
    	// Read the next word from the stream input.  Skip any preceding white
    	// space or punctuation. Return null if no word remains to be read from
    	// input.
    	char c;
    	for ( ; ; ) {
    		int i = input.read();
    		if (i < 0)  return null;
    		c = (char) i;
    		if (Character.isLetter(c))  break;
    	}
    	StringBuffer s = new StringBuffer();
    	for ( ; ; ) {
    		s.append(c);
    		int i = input.read();
    		if (i < 0)  break;
    		c = (char) i;
    		if (! Character.isLetter(c))  break;
    	}
    	return new String(s);
    }

    private static Set readAllWords
    				(String docname) {
    	// Return the set of all words occurring in the document named docname.
    	Set docwords = new ArraySet(100);
    	try {
    	    InputStreamReader input =
    	        new InputStreamReader(
    		    new FileInputStream(new File(docname)));
    	    for (;;) {
    		String word = readWord(input);
    		if (word == null)  break;
    		    docwords.add(word.toLowerCase());
    	    }
    		input.close();
    	}
    	catch (FileNotFoundException e) {  }
    	catch (IOException e) {  }
    	return docwords;
    }

    public static final int
    		NONE = 0, SOME = 1, ALL = 2;

    public static int score (Set docwords, Set keywords) {
    	// Determine whether docwords contains all, some, or none of the
    	// words in keywords.
    	if (docwords.containsAll(keywords))
    		return ALL;
    	else if (! disjoint(docwords, keywords))
    		return SOME;
    	else
    		return NONE;
    }

    private static boolean disjoint (Set docwords, Set keywords) {
    	Iterator iter = keywords.iterator();
    	while (iter.hasNext()) {
    	    if (docwords.contains(iter.next()))
    	        return false;
    	}
    	return true;
    }

    public static void main (String[] args) {
    	Set docwords = readAllWords(args[0]);
    	System.out.println("docwords: " + docwords);
    	System.out.println();
    	Set keywords = new ArraySet(10);
    	for (int i = 1; i < args.length; i++)
    		keywords.add(args[i]);
    	System.out.println("keywords: " + keywords);
    	System.out.println();
    	System.out.println("score:    " + score(docwords, keywords));
    }

}
