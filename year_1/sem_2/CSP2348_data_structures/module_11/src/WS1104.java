 

//  An alphabetized German-English dictionary

import java.util.*;

public class WS1104
{ private static Map map;
  
  public static void main(String[] args)
  { map = new TreeMap();
    load();
    dump();
  }
  
  private static void load()
  { map.put("Ast","gate");
    map.put("Eis","ice");
    map.put("Hof","court, yard, farm");
    map.put("Hut","hat");
    map.put("Lob","praise");
    map.put("Mal","mark, signal");
    map.put("Mut","courage");
    map.put("Ohr","ear");
    map.put("Ost","east");
    map.put("Rad","wheel");
    map.put("Rat","advice, counsel");
    map.put("Tag","day");
    map.put("Tor","gate");
    map.put("Uhr","clock");
    map.put("Wal","whale");
    map.put("Zug","procession, train");
  }

  private static void dump()
  { Set set = map.entrySet();
    for (Iterator it=set.iterator(); it.hasNext(); )
      System.out.println(it.next());
  }
}
