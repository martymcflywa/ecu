//  Using an ArrayList to store ranked data

import java.io.*;
import java.util.*;

public class WS0904
{ private static LinkedList list = new LinkedList();
  public static void main(String[] args)
  { load("Cities.txt");
    System.out.println(list);
    list.remove(list.indexOf("Seoul"));
    list.remove(list.indexOf("Osaka"));
    list.add(5,"Shanghai");
    list.add(6,"Los Angeles");
    System.out.println(list);
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
