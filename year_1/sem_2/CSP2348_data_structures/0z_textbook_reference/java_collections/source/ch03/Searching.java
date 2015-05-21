public class Searching {

    public static final int NONE = -1;  // ... distinct from any array index.
    

    public static int linearSearch1 (Object target, Object[] a,
	    int left, int right) {
    // Find which if any component of a[left...right] contains target.
        for (int p = left; p <= right; p++) {
            if (target.equals(a[p]))  return p;
        }
        return NONE;
    }
    

    public static int linearSearch2 (Comparable target, Comparable[] a,
	    int left, int right) {
    // Find which if any component of a[left...right] contains target
    // (where a is sorted).
        for (int p = left; p <= right; p++) {
            int comp = target.compareTo(a[p]);
            if (comp == 0)      return p;
            else if (comp < 0)  return NONE;
        }
        return NONE;
    }
    

    public static int binarySearch (Comparable target, Comparable[] a,
	    int left, int right) {
    // Find which if any component of a[left...right] contains target 
    // (where a is sorted).
        int l = left, r = right;
        while (l <= r) {
            int m = (l + r)/2;
            int comp = target.compareTo(a[m]);
            if (comp < 0)
                r = m - 1;
            else if (comp > 0)
                l = m + 1;
            else  // comp == 0
                return m;
        }
        return NONE;
    }


    public static void main (String[] args) {
        String[] words1 = {"fox", "cow", "pig", "cat", "rat", "lio",
		"tig", "goa", "dog"};
        int left1 = 0, right1 = words1.length - 1;
        String[] words2 = {"cat", "cow", "dog", "fox", "goa", "lio",
		"pig", "rat", "tig"};
        int left2 = 0, right2 = words2.length - 1;
        String[] testcases = {"ant", "cat", "cow", "dog", "eag", "fox", "goa",
		"lio", "mou", "pig", "rab", "rat", "she", "tig", "zeb"};
        
        for (int t = 0; t < testcases.length; t++) {
            String target = testcases[t];
            System.out.println(target
		    + "  " + linearSearch1(target, words1, left1, right1)
                    + "  " + linearSearch2(target, words2, left2, right2)
                    + "  " + binarySearch(target, words2, left2, right2));
        }
    }

}
