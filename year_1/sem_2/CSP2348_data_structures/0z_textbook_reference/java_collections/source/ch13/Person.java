public class Person implements Comparable {

    // Each Person value consists of a person's surname, forename, gender,
    // and year of birth.
    
    public String surname, forename;
    public boolean female;
    public int yearOfBirth;
    
    public Person (String surname, String forename, boolean female,
            int yearOfBirth) {
        this.surname = surname;
        this.forename = forename;
        this.female = female;
        this.yearOfBirth = yearOfBirth;
    }


    public int compareTo (Object that) {
    	Person other = (Person) that;
    	int d = this.surname.compareTo(other.surname);
    	if (d != 0)
    	    return d;
    	else
    	    return this.forename.compareTo(other.forename);
    }

}
