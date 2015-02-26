/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csp2348_5243_workshop1;

import java.util.Scanner;

public class GCD {
//find greatest common divisor of m>0,n>0

    public static int gcd(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int p = m, q = n, r;
        while ((p % q) != 0) {
            r = p % q;
            p = q;
            q = r;
        }
        return q;
    }

    public static void main(String[] args) {
        int x, y;
        if (args.length == 0) {
// This is an example of how to assign in the program values for x and y 
//            x=77; y=21;
// This is an example of using Scanner to read from the input stream 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter 1st number: ");
            x = scanner.nextInt();
            System.out.print("Please enter 2nd number: ");
            y = scanner.nextInt();
            scanner.close();
        } else {
// Use this if you passing the value as arguments for the GCD class
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
        }
        System.out.println("The gcd of "
                + x + " and " + y
                + " is " + gcd(x, y));
    }
}
