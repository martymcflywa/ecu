import java.util.Comparator;

public class PersonByYearComparator implements Comparator {

    public int compare (Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        return (p1.yearOfBirth - p2.yearOfBirth);
    }

    public boolean equals (Object obj) {
    	return (obj != null && obj instanceof PersonByYearComparator);
    }
}