import java.util.Iterator;

import WattBrown.List;
import WattBrown.LinkedList;

public class ListTesting {

    private static void printList (List list) {
        System.out.print("[");
        Iterator listElems = list.iterator();
        while (listElems.hasNext())
            System.out.print(" " + listElems.next());
        System.out.println(" ]");
    }

    public static void main (String[] args) {
        List names = new LinkedList();
        List others = new LinkedList();
        others.add("Nelson");
        others.add("Ralph");
        others.add("Brian");
        printList(names);
        for (int i = 0; i < args.length; ) {
            String op = args[i++];
            System.out.println("Operation: " + op);
            if (op.equals("l"))
                System.out.println("    " + names.size());
            else if (op.equals("g")) {
                int index = Integer.parseInt(args[i++]);
                System.out.println("    " + names.get(index));
            }
            else if (op.equals("e"))
                System.out.println("    " +
                        (names.equals(others) ? "equal" : "unequal"));
            else if (op.equals("s")) {
                int index = Integer.parseInt(args[i++]);
                names.set(index, args[i++]);
            }
            else if (op.equals("a")) {
                int index = Integer.parseInt(args[i++]);
                names.add(index, args[i++]);
            }
            else if (op.equals("al"))
                names.add(args[i++]);
            else if (op.equals("aa"))
                names.addAll(others);
            else if (op.equals("r")) {
                int index = Integer.parseInt(args[i++]);
                names.remove(index);
            }
            else
                System.out.println(" -- INVALID");
            printList(names);
        }
    }

}
