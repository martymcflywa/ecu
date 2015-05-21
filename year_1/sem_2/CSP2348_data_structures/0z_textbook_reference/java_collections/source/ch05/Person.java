public class Person {

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

}
