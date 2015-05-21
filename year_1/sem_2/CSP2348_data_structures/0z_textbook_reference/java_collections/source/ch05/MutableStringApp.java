public class MutableStringApp {

    public static void substitute (StringBuffer subject, String str1,
	    String str2) {
    // Replace all occurrences of str1 by str2 in subject.
        int length1 = str1.length(), length2 = str2.length();
        int i = 0;
        while (i+length1 <= subject.length()) {
            if (subject.substring(i, i+length1).equals(str1)) {
                subject.delete(i, i+length1);
                subject.insert(i, str2);
//                subject.replace(i, i+length1, str2);
                i += length2;
            } else
                i++;
        }
    }

    public static void main (String[] args) {
        StringBuffer subject = new StringBuffer(args[0]);
        substitute(subject, args[1], args[2]);
        System.out.println(subject);
    }

}
