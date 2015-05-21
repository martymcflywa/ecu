

//  Using set operations on a TreeSet of strings

import java.util.*;

public class WS1101 {
    public static void main(String[] args) {
        SortedSet countries = new TreeSet();
        load(countries);
        System.out.println(countries);
        System.out.println("countries.first() = " + countries.first());
        System.out.println("countries.last()  = " + countries.last());
        String s1 = "Australia";
        String s2 = "Canada";
        System.out.println("countries.headSet(" + s1 + ") = "
                + countries.headSet(s1));
        System.out.println("countries.subSet(" + s1 + "," + s2 + ") = "
                + countries.subSet(s1, s2));
        System.out.println("countries.tailSet(" + s2 + ") = "
                + countries.tailSet(s2));
    }

    private static void load(Set set) {
        set.add("Canada");
        set.add("China");
        set.add("Greece");
        set.add("Togo");
        set.add("India");
        set.add("Oman");
        set.add("Egypt");
        set.add("Peru");
        set.add("USA");
        set.add("Australia");
    }
}
