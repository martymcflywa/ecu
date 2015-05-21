import java.io.*;

import WattBrown.Queue;
import WattBrown.LinkedQueue;

public class Unmerging {

    private static Person readPerson (BufferedReader input)
            throws IOException {
        String line = input.readLine();
        if (line == null)  return null;
        int i1 = line.indexOf(' ');
        int i2 = line.indexOf(' ', i1+1);
        int i3 = line.indexOf(' ', i2+1);
        String surname = line.substring(0, i1);
        String forename = line.substring(i1+1, i2);
        boolean female = (line.substring(i2+1, i3).equals("F"));
        int dob = Integer.parseInt(line.substring(i3+1));
        return new Person(surname, forename, female, dob);
    }

    private static void writePerson (BufferedWriter output, Person p)
            throws IOException {
        String line = p.surname + ' ' + p.forename
                        + ' ' + (p.female ? 'F' : 'M') + ' ' + p.dob;
        output.write(line + '\n');
        System.out.println(line); // TEMP
    }

    public static void unmergePersons
                    (BufferedReader input,
                     BufferedWriter output)
            throws IOException {
        Queue females = new LinkedQueue(),
                males = new LinkedQueue();
        Person p;
        for (;;) {
            p = readPerson(input);
            if (p == null)  break;
            if (p.female)
                females.addLast(p);
            else
                males.addLast(p);
        }
        while (! females.isEmpty()) {
            p = (Person) females.removeFirst();
            writePerson(output, p);
        }
        while (! males.isEmpty()) {
            p = (Person) males.removeFirst();
            writePerson(output, p);
        }
    }

    public static void main (String[] args) {
        try {
            BufferedReader input =
                    new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(args[0])));
            BufferedWriter output =
                    new BufferedWriter(
                        new OutputStreamWriter(
                            new FileOutputStream(args[1])));
            unmergePersons(input, output);
            input.close();
            output.close();
        }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

}
