package csp2348.pkg5243_workshop2;

import java.util.Scanner;

public class Power {

    //return b^n, where n>=0
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public int simplePower(int b, int n) {
        if (n < 0) {
            return 0;
        }
        int p = 1;
        System.out.println("SimplePower: ");
        for (int i = 1; i <= n; i++) {
            p *= b;
            System.out.println("i= " + i + " p= " + p + " b=" + b);
        }
        return p;
    }

//return b^n, where n>=0
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public int smartPower(int b, int n) {
        if (n < 0) {
            return 0;
        }
        int i = 0, p = 1, q = b, m = n;
        System.out.println("Smart Power Computation: ");
        System.out.println("i= " + i + " p= " + p + " q= " + q + " m= " + m);
        while (m > 0) {
            if ((m % 2) != 0) {
                p *= q;
                System.out.println("i= " + (++i) + " p= " + p + " q= " + q + " m= " + m);
            }
            m /= 2;
            q *= q;
            System.out.println("i= " + (++i) + " p= " + p + " q= " + q + " m= " + m);
        }
        return p;
    }

    public static void main(String[] args) {
        Power power = new Power();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of p followed ");
        int p1 = in.nextInt();
        System.out.println("Enter the value of b followed return ");
        int b1 = in.nextInt();
        power.simplePower(p1, b1);
        power.smartPower(p1, b1);
    }
}