import WattBrown.PriorityQueue;
import WattBrown.HeapPriorityQueue;

import java.io.*;
import java.util.Comparator;

public class HeapSortPeople {

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
                        + ' ' + (p.female ? 'F' : 'M') + ' ' + p.yearOfBirth;
        output.write(line + '\n');
    }

    public static void sortPeople (BufferedReader input,
            BufferedWriter output, Comparator comp) throws IOException {
        PriorityQueue people = new HeapPriorityQueue(10, comp);
        for (;;) {
            Person p = readPerson(input);
            if (p == null)  break;
            people.add(p);
        }
        while (! people.isEmpty()) {
            Person p = (Person) people.remove();
            writePerson(output, p);
        }
    }
    
    public static void main (String[] args) {
        try {
            BufferedReader input;
            BufferedWriter output = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(args[1])));

            input = new BufferedReader(
                    new InputStreamReader(new FileInputStream(args[0])));
            sortPeople(input, output, null);
            input.close();
            
            input = new BufferedReader(
                    new InputStreamReader(new FileInputStream(args[0])));
            output.write("\n");
            sortPeople(input, output, new PersonByYearComparator());

            input.close();
            input = new BufferedReader(
                    new InputStreamReader(new FileInputStream(args[0])));
            output.write("\n");
            sortPeople(input, output, new PersonByForenameComparator());
            input.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}