import java.util.Iterator;
import java.io.*;

import WattBrown.LinkedList;

public class TextEditor {

    // Each TextEditor object represents a text subject to editing. The text
    // consists of lines numbered 0, 1, …. If the text is nonempty, at any time
    // one line is selected, initially line 0.

    // This text is represented as a list of lines, text. The number of the
    // currently-selected line (or -1 if the text is empty) is held in selection.
    private LinkedList text;
    private int selection;

    public TextEditor () {
    // Construct a text, initially empty.
        text = new LinkedList();
        selection = -1;
    }

    public void insertBefore (String line) {
    // Insert line immediately before the selected line in this text.
        if (selection < 0) {
            warn("There is no line to insert before."); return;
        }
        text.add(selection++, line);
    }

    public void insertAfter (String line) {
    // Insert line immediately after the selected line in this text, and select the
    // inserted line.
        text.add(++selection, line);
    }

    public void delete () {
    // Delete the selected line in this text, and select the following line (or the
    // previous line, if the last line was deleted).
        if (selection < 0) {
            warn("There is no line to delete."); return;
        }
        text.remove(selection);
        if (selection == text.size())
            selection--;
    }

    public void replace (String line) {
    // Replace the selected line in this text by line, and select the replacement
    // line.
        if (selection < 0) {
            warn("There is no line to replace."); return;
        }
        text.set(selection, line);
    }

    public void select (int ln) {
    // Select the line numbered ln in this text.
        if (ln < 0 || ln >=text.size())
            warn("There is no such line to select.");
        selection = ln;
    }

    public void find (String s) {
    // Find the first line, between the selected line and the end of this text, that
    // contains s as a substring, and select that line.
        if (selection < 0) {
            warn("There are no lines to search."); return;
        }
        int length = text.size();
        for (int ln = selection; ln < length; ln++) {
            String line = (String) text.get(ln);
            if (line.indexOf(s) >= 0) {
                selection = ln;
                return;
            }
        }
        warn("There is no line containing '" + s + "'.");
    }

    public void load (BufferedReader input)
                    throws IOException {
    // Insert the text contained in input after the last line of this text, and
    // select the last line inserted.
        for (;;) {
            String line = input.readLine();
            if (line == null)  break;
            text.add(line);
        }
        selection = text.size()-1;
    }

    public void save (BufferedWriter output)
                    throws IOException {
    // Write this text to output.
        Iterator lines = text.iterator();
        while (lines.hasNext()) {
            String line = (String) lines.next();
            output.write(line + '\n');
        }
    }

    public void display () {
    // Display this text, highlighting the selected line.
        int ln = 0;  // … line number
        Iterator lines = text.iterator();
        while (lines.hasNext()) {
            String line = (String) lines.next();
            boolean selected = (ln == selection);
            System.out.println(ln + (selected ? " * " : " : ") + line);
            ln++;
        }
    }

    private void warn (String msg) {
        System.out.println("WARNING: " + msg);
    }

    public static void main (String[] args) {
        try {
            TextEditor editor = new TextEditor();
            for (int i = 0; i < args.length; ) {
                char op = args[i++].charAt(0);
                System.out.println("Operation: " + op);
                switch (op) {
                    case 'i':
                        editor.insertBefore(args[i++]);
                        break;
                    case 'a':
                        editor.insertAfter(args[i++]);
                        break;
                    case 'd':
                        editor.delete();
                        break;
                    case 'r':
                        editor.replace(args[i++]);
                        break;
                    case 's':
                        editor.select(Integer.parseInt(args[i++]));
                        break;
                    case 'f':
                        editor.find(args[i++]);
                        break;
                    case 'l': {
                        BufferedReader input =
                                new BufferedReader(
                                    new InputStreamReader(
                                        new FileInputStream(args[i++])));
                        editor.load(input);
                        input.close();
                        break;
                    }
                       case 'v': {
                        BufferedWriter output =
                                new BufferedWriter(
                                    new OutputStreamWriter(
                                        new FileOutputStream(args[i++])));
                        editor.save(output);
                        output.close();
                        break;
                    }
                    default:
                        System.out.println(" -- INVALID");
                }
                editor.display();
            }
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

}
