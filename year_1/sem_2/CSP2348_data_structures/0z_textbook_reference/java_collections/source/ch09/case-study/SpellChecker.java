import java.io.*;
import java.util.Iterator;

import WattBrown.LinkedSet;
import WattBrown.Set;

public class SpellChecker {

    private Set mainVocabulary, userVocabulary, ignoredVocabulary;

    // Constructors ...

    public SpellChecker () {
    	mainVocabulary    = new LinkedSet();
    	userVocabulary    = new LinkedSet();
    	ignoredVocabulary = new LinkedSet();
    }


    public SpellChecker (String mainfile) {
    	this();
    	loadVocabulary(mainVocabulary, mainfile);
    }


    public SpellChecker (String mainfile, String userfile) {
    	this();
    	loadVocabulary(mainVocabulary, mainfile);
    	loadVocabulary(userVocabulary, userfile);
    }


    private void loadVocabulary (Set vocabulary, String file) {
    	vocabulary.clear();
    	try {
    	    BufferedReader input = new BufferedReader(
    		    new InputStreamReader(new FileInputStream(file)));
    	    String line = input.readLine();
    	    while (line != null) {
    	        vocabulary.add(line.toLowerCase());
    	        line = input.readLine();
    	    }
    	    input.close();
    	} catch (IOException e) {
    	    System.out.println(e.getMessage());
    	}
    }


    private void saveVocabulary (Set vocabulary, String file) {
    	try {
    	    BufferedWriter output = new BufferedWriter(
    		    new OutputStreamWriter(new FileOutputStream(file)));
    	    Iterator iter = vocabulary.iterator();
    	    while (iter.hasNext()) {
    	        output.write((String) iter.next());
        		output.newLine();
    	    }
    	    output.close();
    	} catch (IOException e) {
    	    System.out.println(e.getMessage());
    	}
    }


    public void saveMainVocabulary (String file) {
    	saveVocabulary(mainVocabulary, file);
    }


    public void saveUserVocabulary (String file) {
       	saveVocabulary(userVocabulary, file);
    }


    public void loadMainVocabulary (String file) {
    	loadVocabulary (mainVocabulary, file);
    }


    public void loadUserVocabulary (String file) {
    	loadVocabulary (userVocabulary, file);
    }


    public boolean check (String word) {
    	String temp = word.toLowerCase();
    	return (mainVocabulary.contains(temp) ||
    		    userVocabulary.contains(temp) ||
    		    ignoredVocabulary.contains(temp));
    }


    public void addMainVocabulary (String word) {
    	mainVocabulary.add(word.toLowerCase());
    }


    public void addUserVocabulary (String word) {
    	userVocabulary.add(word.toLowerCase());
    }


    public void addIgnoredVocabulary (String word) {
    	ignoredVocabulary.add(word.toLowerCase());
    }

///////////////////////////////////////////////////////////////////////////////

    public static void main (String[] args) {
    	SpellChecker s = new SpellChecker();
    	s.loadMainVocabulary("main.voc");
    	s.addMainVocabulary("albatross");
    	System.out.println("Literal string: " +
    		s.check("aardvark"));
    	System.out.println("Concatentated string: " +
    		s.check("aard" + "vark"));
    	System.out.println("Via a StringBuffer: " +
    		s.check(new String(new StringBuffer("aardvark"))));
    	s.saveMainVocabulary("main.new");
    }
}
