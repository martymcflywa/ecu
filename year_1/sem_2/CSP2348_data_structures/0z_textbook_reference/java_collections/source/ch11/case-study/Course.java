import java.io.*;
import WattBrown.*;

public class Course implements StudentCollection {

    // A course record contains the details about a particular course.

    // Each course has a course id, a name, and a map of results.
    // Each entry in the results map contains a student registration number,
    // and a mark.
    private String courseID, name;
    private Map grades;

    // Constant to indicate that a grade has not been recorded for a student.
    public static final String NO_GRADE = "NO GRADE";

    //////////// Constructor ////////////

    public Course (String courseID, String name) {
    	this.courseID = courseID;
    	this.name = name;
    	this.grades = new BSTMap();
    }

    //////////// Accessors ////////////

    public String getCourseID () {
    // Return the course ID of this course.
    	return courseID;
    }


    public String getName () {
    // Return the name of this course.
	    return name;
    }


    public Set getStudentIDs () {
    // Return the set of identifiers of students enrolled on this course.
	    return grades.keySet();
    }


    public String toString () {
    // Convert this course into a string.
	    return courseID + "," + name + "," + grades;
    }

    //////////// Transformers ////////////

    public void addStudent (Student student) throws Exception {
    // Enroll the given student on this course. Throw an exception if the
    // student is already enrolled.
      	String studentID = student.getStudentID();
    	if (grades.get(studentID) == null)
    	    grades.put(studentID, new Integer(NO_GRADE));
    	else
    	    throw new Exception("student " + studentID +
    		    " is already enrolled on course " + name);
    }


    public void recordGrade (Student student, String grade) throws Exception {
    // Record the grade for a student taking this course.
    // Throw an exception if the student is not enrolled on this course.
    	String studentID = student.getStudentID();
    	if (grades.get(studentID) != null)
    	    grades.put(studentID, grade);
    	else
    	    throw new Exception("student " + studentID +
    		    " is not enrolled on course " + name);
    }

    public static Course read (BufferedReader input)
	    throws Exception {
    // Create a new course record using the details read from the input.
    // Return the new record or null if there is no record to read.
    // A malformed record will cause an exception.
    	String courseID = input.readLine();
    	if (courseID != null) {
    	    String name = input.readLine();
    	    Course course =  new Course(courseID, name);
    	    String studentID = input.readLine();
    	    while (studentID != null && studentID.length() > 0) {
        		course.grades.put(studentID, NO_GRADE);
        		studentID = input.readLine();
    	    }
    	    return course;
    	} else
    	    return null;
    }

}
