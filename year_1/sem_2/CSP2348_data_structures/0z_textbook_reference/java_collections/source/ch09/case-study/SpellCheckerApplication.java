import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;

public class SpellCheckerApplication extends JFrame
	    implements WindowListener, ActionListener {

    private SpellChecker spellChecker;
    private String currentWord;
    private Reader input;
    private Writer output;

    public SpellCheckerApplication (Reader input, Writer output) {
	    spellChecker = new SpellChecker("main.hamlet", "user.hamlet");
        this.input   = input;
        this.output  = output;
        createGUI();
    }

    private JTextArea contextArea;
    private JTextField correctionField;
    private JButton[] theButtons;

    private void createGUI () {
	    contextArea = new JTextArea("", 5, 50);
	    contextArea.setEnabled(false);
        JScrollPane sp = new JScrollPane(contextArea);

	    JPanel p = new JPanel(new GridLayout(1, 5));
        theButtons = new JButton[] {
            new JButton("Ignore"),
            new JButton("Ignore all"),
            new JButton("Add to user"),
            new JButton("Add to main"),
            new JButton("Change")};

        for (int i = 0; i < theButtons.length; i++) {
	        p.add(theButtons[i]);
	        theButtons[i].addActionListener(this);
	    }

	    correctionField = new JTextField("");

	    getContentPane().add(sp, "Center");
        getContentPane().add(p, "South");
	    getContentPane().add(correctionField, "North");

	    setTitle("Interactive spelling checker");
	    addWindowListener(this);
	    pack();
    }

///////////////////////////////////////////////////////////////////////////////

    public void actionPerformed (ActionEvent e) {
	    JButton b = (JButton) e.getSource();
	    int current = 0;
	    for (current = 0; current < theButtons.length; current++)
	        if (b == theButtons[current])  break;
	        switch (current) {
                case 0:	// Ignore
                    break;
                case 1:	// Ignore all
                    spellChecker.addIgnoredVocabulary(currentWord);
                    break;
                case 2:	// Add to user
                    spellChecker.addUserVocabulary(currentWord);
                    break;
                case 3:	// Add to main
                    spellChecker.addMainVocabulary(currentWord);
                    break;
                case 4:	// Change
                    currentWord = correctionField.getText();
                    contextArea.setEnabled(true);
                    contextArea.setCaretPosition(startPosition);
                    contextArea.moveCaretPosition(currentPosition);
                    contextArea.replaceSelection(currentWord);
                    currentPosition = contextArea.getSelectionEnd();
                    contextArea.setEnabled(false);
                    break;
        }
        try {
            getNextIncorrectWord();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

///////////////////////////////////////////////////////////////////////////////

    public void windowOpened      (WindowEvent e) { }
    public void windowClosed      (WindowEvent e) { }
    public void windowIconified   (WindowEvent e) { }
    public void windowDeiconified (WindowEvent e) { }
    public void windowActivated   (WindowEvent e) { }
    public void windowDeactivated (WindowEvent e) { }

    public void windowClosing     (WindowEvent e) {
    	try {
    	    input.close();
    	    output.close();
    	} catch (IOException ex) {
    	    System.out.println(ex.getMessage());
    	}
    	spellChecker.saveMainVocabulary("main.hamlet.out");
    	spellChecker.saveUserVocabulary("user.hamlet.out");
    	System.exit(0);
    }


///////////////////////////////////////////////////////////////////////////////

    private int ch = -1;
    private int currentPosition = 0, startPosition = 0;

    private void addToContext (char ch) {
    	contextArea.append("" + ch);
    	currentPosition++;
    }

    private String readWord (Reader input) throws IOException {
        StringBuffer sb = new StringBuffer();
        try {
            if (ch != -1) {
		        output.write(ch);
		        addToContext((char) ch);
    	    }
            ch = input.read();

            // Skip any non-letters on the input...
            while (ch != -1 && ! Character.isLetter((char) ch)) {
        		output.write(ch);
        		addToContext((char) ch);
                ch = input.read();
    	    }

            // Read letters up to the first non-letter to form a word...
    	    startPosition = currentPosition;
            while (ch != -1 && Character.isLetter((char) ch)) {
                sb.append((char) ch);
        		addToContext((char) ch);
                ch = input.read();
            }
    	    contextArea.setCaretPosition(startPosition);
    	    contextArea.moveCaretPosition(currentPosition);
        } catch (IOException e) {
            return null;
        }

        if (sb.length() > 0)
            return new String(sb);
        else
            return null;
    }


    private void getNextIncorrectWord () throws IOException {
    	if (currentWord != null)
    	    output.write(currentWord);

        String word = readWord(input);
        while (word != null && spellChecker.check(word)) {
    	    output.write(word);
            word = readWord(input);
    	}

        currentWord = word;
        if (currentWord != null)
            correctionField.setText(currentWord);
        else {
            JOptionPane.showMessageDialog(null,
                    "No more incorrect words found.", "Spell check finished",
                    JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0; i < theButtons.length; i++)
                theButtons[i].setEnabled(false);
        }
    }

///////////////////////////////////////////////////////////////////////////////

    public static void main (String[] args) {
    	try {
    	    BufferedReader input = new BufferedReader(
    		    new InputStreamReader(new FileInputStream(args[0])));
    	    BufferedWriter output = new BufferedWriter(
    		    new OutputStreamWriter(
    			    new FileOutputStream(args[0] + ".out")));
    	    SpellCheckerApplication f =
    		    new SpellCheckerApplication(input, output);
    	    f.show();
            f.getNextIncorrectWord();
    	} catch (IOException e) {
    	    System.out.println(e.getMessage());
    	}
    }
}
