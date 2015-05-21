public class GCD {

    static int gcd (int m, int n) {
    // Return the GCD of psoitive integers m and n.
	int p = m, q = n;
	while (p % q != 0) {
	    int r = p % q;
	    p = q;  q = r;
	}
	return q;
    }

    public static void main (String[] args) {
	int x = Integer.parseInt(args[0]);
	int y = Integer.parseInt(args[1]);

	System.out.println("The gcd of " + x + " and " + y + " is " +
		gcd(x, y));
    }
}
