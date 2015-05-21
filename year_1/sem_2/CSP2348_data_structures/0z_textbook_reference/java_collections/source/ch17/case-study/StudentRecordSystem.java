import java.io.*;
import java.util.*;

import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class StudentRecordSystem {

    // Implement a simple student records system.

    // The system contains three maps:
    //   students records all of the students by student id.
    //   degrees records all of the programs by program id.
    //   courses records all of the courses by course id.
    private Map<String, Student> students;
    private Map<String, Degree>  degrees;
    private Map<String, Course>  courses;

    //////////// Constructor ////////////

    public StudentRecordSystem () {
    	students = null;
    	degrees  = null;
    	courses  = null;
    }

///////////////////////////////////////////////////////////////////////////////

    //////////// File reading methods ////////////

    private static Map<String, Student> readStudents (String filename) {
    // Read the list of students from the file and construct a map
    // of student records.
    	Map<String, Student> result = new TreeMap<String, Student>();
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

    private static Map<String, Degree> readDegrees (String filename) {
    // Read the list of degree programs from the file and construct a map of
    // degree program records.
    	Map<String, Degree> map = new TreeMap<String, Degree>();
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

    private static Map<String, Course> readCourses (String filename) {
    // Read the list of courses from the file.
    	Map<String, Course> map = new TreeMap<String, Course>();
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


    private <A> Map<String, A> select (Map<String, A> map, Set<String> keys) {
    // Return the map obtained by selecting only those entries from map whose
    // keys are in keys.
        Map<String, A> result = new TreeMap<String, A>();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            A val = map.get(key);
            if (val != null)
                result.put(key, val);
        }
        return result;
    }

    private <A implements StudentCollection> Set<String> getAllStudents (
			    Map<String, A> map) {
    // Return the set of all student identifiers contained in the given
    // map of StudentCollection objects.
    	Set<String> result = new TreeSet<String>();
    	Iterator<String> iter = map.keySet().iterator();
    	while (iter.hasNext()) {
    	    String key = iter.next();
    	    StudentCollection record = map.get(key);
            result.addAll(record.getStudentIDs());
    	}
    	return result;
    }

    //////////// Report methods ////////////

    public void displayCourses (JTextArea output, Set<String> courseIDs) {
    // Display on output the identifiers and names of all students enrolled
    // on any of the courses whose identifiers are in courseIDs.
    	Set<String> students = getAllStudents(select(courses, courseIDs));
    	Map<String, Student> sorted = selectSortedStudents(students);
    	displayMap(output, sorted);
    }


    public void displayDegrees (JTextArea output, Set<String> degreeIDs) {
    // Display on output the identifiers and names of all students registered
    // for any of the degree programs whose identifiers are in degreeIDs.
    	Set<String> students = getAllStudents(select(degrees, degreeIDs));
    	Map<String, Student> sorted = selectSortedStudents(students);
    	displayMap(output, sorted);
    }

    private Map<String, Student> selectSortedStudents (Set<String> ids) {
    // Return a map containing all of the students with identifiers in the set
    // ids, but using their sort-keys as keys.
        Map<String, Student> result = new TreeMap<String, Student>();
        Iterator<String> iter = ids.iterator();
        while (iter.hasNext()) {
            String id = iter.next();
            Student s = students.get(id);
            result.put(s.sortKey(), s);
        }
        return result;
    }

    public void displayMap (JTextArea output, Map<String, Student> map) {
    // Display in output the identifiers and names of all students in map.
    	Iterator<String> iter = map.keySet().iterator();
        output.setText("");
    	while (iter.hasNext()) {
    	    String key = iter.next();
    	    Student student = map.get(key);
    	    output.append(student.getStudentID() + " " +
    		    student.getName() + "\n");
    	}
    }

///////////////////////////////////////////////////////////////////////////////

    public <A> void addKeys (JComboBox cb, Map<String, A> map) {
    	Iterator<String> iter = map.keySet().iterator();
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
    	system.degrees  = readDegrees("degrees.txt");
    	system.courses  = readCourses("courses.txt");

    	RecordGUI gui = new RecordGUI(system);
    	gui.show();
    }

}
