import java.util.Iterator;

public class Eratosthenes {
    
    static IntSet range (int l, int m) {
    // Return the set {l, ..., m-1}.
        IntSet ints = new IntSet(m);
        for (int n = l; n < m; n++)
            ints.add(n);
        return ints;
    }

    static IntSet primesLessThan (int m) {
        IntSet sieve = range(2, m);
/*
        IntSet sieve = new IntSet(m);
        for (int n = 2; n < m; n++)
            sieve.add(n);
*/
        for (int n = 2; n*n <= m; n++)
            if (sieve.contains(n))
                for (int mult = 2*n; mult < m; mult += n)
                    sieve.remove(mult);
        return sieve;
    }

    static void main (String [] args) {
        int m = Integer.parseInt(args[0]);
        IntSet sieve = primesLessThan(m);
        System.out.println("Primes less than " + m + " are "
                + sieve);
        int l = Integer.parseInt(args[1]);
        sieve.retainAll(range(l, m));
        System.out.println("Primes in interval " + l + "..." + (m-1) + " are "
                + sieve);
/*
        System.out.print("Primes less than " + m + " are:");
        Iterator iter = sieve.iterator();
        while (iter.hasNext()) {
            Integer i = (Integer) iter.next();
            System.out.print(" " + i);
        }
        System.out.println();
*/
    }

}
