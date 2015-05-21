public class Powers {
    
    private static int power1 (int b, int n) {
        int p = 1;
        for (int i = 1; i <= n; i++)
            p *= b;
        return p;
    }

    
    private static int power2 (int b, int n) {
        int p = 1, q = b, m = n;
        while (m > 0) {
            if (m % 2 != 0)  p *= q;
            m /= 2;  q *= q;
        }
        return p;
    }

    
    private static int power3 (int b, int n) {
        if (n == 0)
            return 1;
        else
            return b * power3(b, n-1);
    }
    

    private static int power4 (int b, int n) {
        if (n == 0)
            return 1;
        else {
            int p = power4(b, n/2);
            if (n % 2 == 0)  // n is even
                return p * p;
            else             // n is odd
                return p * p * b;
        }
    }


    public static void main (String[] args) {
        for (int n = 0; n < 10; n++)
            System.out.println(n
                    + "  " + power1(2, n)
                    + "  " + power2(2, n)
                    + "  " + power3(2, n)
                    + "  " + power4(2, n));
    }
    
}
