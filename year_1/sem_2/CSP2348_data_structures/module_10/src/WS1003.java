//  Using an ArrayList to store ranked data

import java.io.*;
import java.util.*;

public class WS0903
{ private static ArrayList list = new ArrayList();
  public static void main(String[] args)
  { load("Cities.txt");
    System.out.println(list);
    list.remove(list.indexOf("Seoul"));
    list.remove(list.indexOf("Osaka"));
    ListIterator it = list.listIterator();
    System.out.println("it.next() = " + it.next());
    System.out.println("it.next() = " + it.next());
    System.out.println("it.next() = " + it.next());
    System.out.println("it.next() = " + it.next());
  }
  
  private static void load(String filename)
  { try
    { File file = new File(filename);
      FileReader reader = new FileReader(file);
      BufferedReader in = new BufferedReader(reader);
      String city = in.readLine();
      while (city != null)
      { list.add(city);
        city = in.readLine();
      }
    }
    catch(Exception e) { System.out.println(e); }
  } 
}
