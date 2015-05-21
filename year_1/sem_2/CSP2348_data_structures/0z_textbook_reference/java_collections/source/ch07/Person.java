public class Person {
    
    public String surname, forename;
    public boolean female;
    public int dob;
    
    public Person (String surname, String forename,
                    boolean female, int dob) {
        this.surname = surname;
        this.forename = forename;
        this.female = female;
        this.dob = dob;
    }
    
    public void changeName (String newSurname) {
        this.surname = newSurname;
    }
    
}
