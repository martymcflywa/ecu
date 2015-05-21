import java.io.*;
import WattBrown.*;

public class Degree implements StudentCollection {

    // A degree program record contains the details about the program of study
    // for a student.

    // Each degree program record has a degree program identifier, a
    // title, and a set of registered students.
    private String degreeID, title;
    private Set studentIDs;

    //////////// Constructor ////////////

    public Degree (String id, String title) {
    // Construct a new program record.
    	this.degreeID = id;
    	this.title = title;
    	this.studentIDs = new BSTSet();
    }

    //////////// Accessors ////////////

    public String getDegreeID () {
    // Return the degree program ID for this degree program.
	    return degreeID;
    }


    public String getTitle () {
    // Return the title for this degree program.
	return title;
    }


    public Set getStudentIDs () {
    // Return the set of identifiers of students registered for this degree
    // program.
	return studentIDs;
    }


    public String toString () {
    // Convert this degree program record into a string.
	return degreeID + "," + title + "," + studentIDs;
    }

    //////////// Transformers ////////////

    public static Degree read (BufferedReader input) throws Exception {
    // Create a new degree program record using the details read from the input.
    // Return the new record or null if there is no record to read.
    // A malformed record will cause an exception.
    	String degreeID = input.readLine();
    	if (degreeID != null) {
    	    String title = input.readLine();
    	    Degree degree = new Degree(degreeID, title);
    	    String line = input.readLine();
    	    while (line != null && line.length() > 0) {
    	        degree.studentIDs.add(line);
    	        line = input.readLine();
    	    }
    	    return degree;
    	} else
    	    return null;
    }


    public void addStudent(Student student) {
    // Add student to this course.
    	studentIDs.add(student.getStudentID());
    }
}
