public class StringApp {

    public static String standardize (String surname) {
    // Return surname with the prefix "Mc" (if present) replaced by "Mac".
    // (This is needed for sorting Scottish surnames into directory order.)
        int letters = surname.length();
        if (letters > 2 && surname.substring(0, 2).equals("Mc"))
            return "Mac".concat(surname.substring(2, letters));
        else
            return surname;
    }

    public static void main (String[] args) {
        for (int i = 0; i < args.length; i++) {
            String surname = args[i];
            System.out.print(surname + " => ");
            System.out.println(standardize(surname));
        }
    }

}
