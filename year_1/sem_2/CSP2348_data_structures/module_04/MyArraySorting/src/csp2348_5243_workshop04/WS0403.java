package csp2348_5243_workshop04;

import java.util.Vector;

/**
 * Testing java.util.Vector class.
 */
public class WS0403 {

    private static Vector v = new Vector();
    private static Vector w = new Vector();

    public static void main(String[] args) {

        System.out.println("v = " + v);
        v.add("Perth");
        v.add("Sydney");
        v.add("Melbourne");
        v.add("Brisbane");
        v.add("Adelaide");
        System.out.println("v = " + v);
        w = (Vector) v.clone();
        System.out.println("w = " + w);
        System.out.println("w.equals(v) = " + w.equals(v));
        v.set(3, "Canberra");
        System.out.println("v = " + v);
        System.out.println("w = " + w);
        System.out.println("w.equals(v) = " + w.equals(v));
        v.insertElementAt("Hobart", 3);
        System.out.println("v = " + v);
        System.out.println("w = " + w);
        System.out.println("w.equals(v) = " + w.equals(v));
        w.removeElementAt(1);
        w.removeElementAt(3);
        w.remove("Canberra");
        System.out.println("w = " + w);
        v.addAll(5, w);
        System.out.println("v = " + v);
        System.out.println("v.indexOf(\"Perth\") = "
                + v.indexOf("Perth"));
        System.out.println("v.indexOf(\"Perth\",2) = "
                + v.indexOf("Perth", 2));
        System.out.println("v.indexOf(\"Canberra\") = "
                + v.indexOf("Canberra"));
    }
}
