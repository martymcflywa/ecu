 

//  A German-English dictionary

import java.util.*;

public class WS1103
{ public static void main(String[] args)
  { Map map = new HashMap(11);
    map.put("Ast","gate");
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
    System.out.println("map=" + map);
    System.out.println("map.keySet()=" + map.keySet());
    System.out.println("map.size()=" + map.size());
  }
}
