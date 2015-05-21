 

//  Using set operations on a HashSet of strings

import java.util.*;

public class WS1102
{ public static void main(String[] args)
  { Set countries = new HashSet();
    load(countries);
    report(countries,"Australia");
    System.out.println("countries.remove(\"Australia\") = "
                        + countries.remove("Australia"));
    report(countries,"Australia");
    report(countries,"Fiji");
    System.out.println("countries.remove(\"Fiji\") = "
                        + countries.remove("Fiji"));
    System.out.println("countries.add(\"Fiji\") = "
                        + countries.add("Fiji"));
    report(countries,"Fiji");
    System.out.println("countries.add(\"Fiji\") = "
                        + countries.add("Fiji"));
    report(countries,"Fiji");
  }
  
  private static void report(Set set, String string)
  { System.out.println("\t\t" + set.size() + " elements: " + set);
    System.out.println("\t\tset.contains(" + string + ") = "
                        + set.contains(string));
  }
  
  private static void load(Set set)
  { set.add("Canada");
    set.add("India");
    set.add("Australia");
    set.add("China");
    set.add("USA");
    set.add("Peru");
    set.add("New Zealand");
  }
}
