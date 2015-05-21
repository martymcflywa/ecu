import java.io.*;

import WattBrown.Queue;
import WattBrown.ArrayQueue;

public class Scanning {

    private static Queue wordQ = new ArrayQueue(100);

    private static void scan (String line) {
    // Add all words in line to wordQ.
        int lineLength = line.length();
        int i = 0;
        while (i < lineLength) {
            char ch = line.charAt(i++);
            if (Character.isLetter(ch)) {
                StringBuffer sb = new StringBuffer();
                do {
                    sb.append(ch);
                    if (i == lineLength)  break;
                    ch = line.charAt(i++);
                } while (Character.isLetter(ch));
                String word = new String(sb);
                wordQ.addLast(word.toLowerCase());
            }
        }
    }

    private static void scanAll (String filename) {
    // Add all words in the named file to wordQ.
        try {
            BufferedReader lineInput =
                    new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(
                                new File(filename))));
            for (;;) {
                String line = lineInput.readLine();
                if (line == null)  break;
                scan(line);
            }
            lineInput.close();
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public static void main (String[] args) {
        scanAll(args[0]);
        while (! wordQ.isEmpty())
            System.out.println(wordQ.removeFirst());
    }

}
