import java.io.*;

import WattBrown.ArrayStack;
import WattBrown.Stack;

public class FileReversal {

public static void reverse (File file)
                throws IOException {
    // Reverse the order of the lines in file.
    Stack lineStack = new ArrayStack(10);
    BufferedReader lineInput =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(file)));
    lineStack.clear();
    for (;;) {
        String line = lineInput.readLine();
        if (line == null)  break;
        lineStack.addLast(line);
    }
    lineInput.close();
    while (! lineStack.isEmpty()) {
        String line = (String) lineStack.removeLast();
        System.out.println(line);
    }
}

public static void main (String[] args) {
    String filename = args[0];
    File file = new File(filename);
    try {
        reverse(file);
    }
    catch (IOException e) { System.out.println(e.getMessage()); }
}

}
