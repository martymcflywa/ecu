import java.io.*;
import java.util.Iterator;
import WattBrown.*;

import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class StudentRecordSystem {

    // Implement a simple student records system.

    // The system contains three maps:
    //   students records all of the students by student id.
    //   degrees records all of the programs by program id.
    //   courses records all of the courses by course id.
    private Map students, degrees, courses;

    //////////// Constructor ////////////

    public StudentRecordSystem () {
    	students = new BSTMap();
    	degrees  = new BSTMap();
    	courses  = new BSTMap();
    }

///////////////////////////////////////////////////////////////////////////////

    //////////// File reading methods ////////////

    private static Map readStudents (String filename) {
    // Read the list of students from the file and construct a map
    // of student records.
    	Map result = new BSTMap();
    	try {
    	    BufferedReader input = new BufferedReader(
    		    new InputStreamReader(new FileInputStream(filename)));
    	    Student student = Student.read(input);
    	    while (student != null) {
    		result.put(student.getStudentID(), student);
    		student = Student.read(input);
    	    }
    	} catch (Exception e) {
    	    System.out.println(e.getMessage());
    	}
    	return result;
    }

    private static Map readDegrees (String filename) {
    // Read the list of degree programs from the file and construct a map of
    // degree program records.
    	Map map = new BSTMap();
    	try {
    	    BufferedReader input = new BufferedReader(
    		    new InputStreamReader(new FileInputStream(filename)));
    	    Degree degree = Degree.read(input);
    	    while (degree != null) {
    		map.put(degree.getDegreeID(), degree);
    		degree = Degree.read(input);
    	    }
    	} catch (Exception e) {
    	    System.out.println(e.getMessage());
    	}
    	return map;
    }

    private static Map readCourses (String filename) {
    // Read the list of courses from the file.
    	Map map = new BSTMap();
    	try {
    	    BufferedReader input = new BufferedReader(
    		    new InputStreamReader(new FileInputStream(filename)));
    	    Course course = Course.read(input);
    	    while (course != null) {
    		map.put(course.getCourseID(), course);
    		course = Course.read(input);
    	    }
    	} catch (Exception e) {
    	    System.out.println(e.getMessage());
    	}
    	return map;
    }

    //////////// Database-like operations ////////////


    private Map select (Map map, Set keys) {
    // Return the map obtained by selecting only those entries from map whose
    // keys are in keys.
        Map result = new BSTMap();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object val = map.get(key);
            if (val != null)
                result.put(key, val);
        }
        return result;
    }

    private Set getAllStudents (Map map) {
    // Return the set of all student identifiers contained in the given
    // map of StudentCollection objects.
    	Set result = new BSTSet();
    	Iterator iter = map.keySet().iterator();
    	while (iter.hasNext()) {
    	    Object key = iter.next();
    	    StudentCollection record = (StudentCollection) map.get(key);
            result.addAll(record.getStudentIDs());
    	}
    	return result;
    }

    //////////// Report methods ////////////

    public void displayCourses (JTextArea output, Set courseIDs) {
    // Display on output the identifiers and names of all students enrolled
    // on any of the courses whose identifiers are in courseIDs.
    	Set students = getAllStudents(select(courses, courseIDs));
    	Map sorted = selectSortedStudents(students);
    	displayMap(output, sorted);
    }


    public void displayDegrees (JTextArea output, Set degreeIDs) {
    // Display on output the identifiers and names of all students registered
    // for any of the degree programs whose identifiers are in degreeIDs.
    	Set students = getAllStudents(select(degrees, degreeIDs));
    	Map sorted = selectSortedStudents(students);
    	displayMap(output, sorted);
    }

    private Map selectSortedStudents (Set ids) {
    // Return a map containing all of the students with identifiers in the set
    // ids, but using their sort-keys as keys.
        Map result = new BSTMap();
        Iterator iter = ids.iterator();
        while (iter.hasNext()) {
            String id = (String) iter.next();
            Student s = (Student) students.get(id);
            result.put(s.sortKey(), s);
        }
        return result;
    }

    public void displayMap (JTextArea output, Map map) {
    // Display in output the identifiers and names of all students in map.
    	Iterator iter = map.keySet().iterator();
        output.setText("");
    	while (iter.hasNext()) {
    	    String key = (String) iter.next();
    	    Student student = (Student) map.get(key);
    	    output.append(student.getStudentID() + " " +
    		    student.getName() + "\n");
    	}
    }

///////////////////////////////////////////////////////////////////////////////

    public void addKeys (JComboBox cb, Map map) {
    	Iterator iter = map.keySet().iterator();
    	while (iter.hasNext())
    	    cb.addItem(iter.next());
    }


    public void addCourses (JComboBox cb) {
    	addKeys(cb, courses);
    }


    public void addDegrees (JComboBox cb) {
	    addKeys(cb, degrees);
    }

///////////////////////////////////////////////////////////////////////////////

    public static void main (String[] args) {
    	StudentRecordSystem system = new StudentRecordSystem();

    	system.students = readStudents("students.txt");
    	system.degrees = readDegrees("degrees.txt");
    	system.courses  = readCourses("courses.txt");

    	RecordGUI gui = new RecordGUI(system);
    	gui.show();
    }

}
