import java.io.*;

public class Student {

    // A student record contains the personal details about a student.

    // Each student has a student identifier, a name, an address,
    // and a date of birth.
    private String studentID, name, address;
    private Date birthDate;

    //////////// Constructor ////////////

    public Student (String studentID, String name, String address,
	   int birthYear, int birthMonth, int birthDay) {
    // Construct a new student record.
    	this.studentID = studentID;
    	this.name = name;
    	this.address = address;
    	this.birthDate = new Date (birthYear, birthMonth, birthDay);
    }

    //////////// Accessors ////////////

    public String getStudentID () {
    // Return this student's identifier.
    	return studentID;
    }


    public String getName () {
    // Return this student's name.
    	return name;
    }


    public String sortKey () {
    // Return a string suitable for sorting students alphabetically
    // by surname. It correctly handles Scottish surnames beginning "MC*"
    // as if they are spelt "MAC*".
    	String surname = name.substring(0, name.indexOf(','));
    	if (surname.length() >= 2 &&
    		surname.charAt(0) == 'M' &&
    		surname.charAt(1) == 'C')
    	    surname = "MAC" + surname.substring(2);

    	String forenames = name.substring(name.indexOf(',')+1);
    	String initials = "";
    	for (int i = 1; i < forenames.length(); i++) {
    	    if (forenames.charAt(i-1) == ' ')
    		initials += forenames.charAt(i);
    	}
    	return (surname + "-" + initials).toUpperCase() + ":" + studentID;
    }


    public String toString () {
    // Convert this student record to a string.
    	return studentID + "," + name + "," + address + "," + birthDate;
    }

    //////////// Transformers ////////////

    public static Student read (BufferedReader input) throws Exception {
    // Create a new student record using the details read from the input.
    // Return the new record or null if there is no record to read.
    // A malformed record will cause an exception.
    	String studentID = input.readLine();
    	if (studentID != null) {
    	    String name = input.readLine();
    	    String address = input.readLine();
    	    String line = input.readLine();
    	    if (line.length() != 10)
    		throw new Exception ("date is wrong length" + line);
    	    int year = Integer.parseInt(line.substring(0, 4));
    	    int month = Integer.parseInt(line.substring(5, 7));
    	    int day = Integer.parseInt(line.substring(8, 10));
    	    input.readLine();
    	    return new Student(studentID, name, address,
    		    year, month, day);
    	} else
    	    return null;
    }
}
