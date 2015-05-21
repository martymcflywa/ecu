import java.util.Iterator;

public class SetTesting {
    
    public static void main (String[] args) {
        Set zoo = new BSTSet();
        Set cats = new BSTSet();
        cats.add("lion");
        cats.add("tiger");
        cats.add("lynx");
        cats.add("puma");
        cats.add("leopard");
        cats.add("cheetah");
        cats.add("cougar");
        System.out.println("cats = " + cats);
        System.out.println("zoo = " + zoo);
        for (int i = 0; i < args.length; ) {
            String op = args[i++];
            System.out.println("Operation: " + op);
            if (op.equals("ie"))
                System.out.println("    " + zoo.isEmpty());
            else if (op.equals("s"))
                System.out.println("    " + zoo.size());
            else if (op.equals("c"))
                System.out.println("    " + zoo.contains(args[i++]));
            else if (op.equals("e"))
                System.out.println("    " + zoo.equals(cats));
            else if (op.equals("d"))
                System.out.println("    " + zoo.disjoint(cats));
            else if (op.equals("ca"))
                System.out.println("    " + zoo.containsAll(cats));
            else if (op.equals("k"))
                zoo.clear();
            else if (op.equals("a"))
                zoo.add(args[i++]);
            else if (op.equals("r"))
                zoo.remove(args[i++]);
            else if (op.equals("aa"))
                zoo.addAll(cats);
            else if (op.equals("ra"))
                zoo.removeAll(cats);
            else if (op.equals("ka"))
                zoo.retainAll(cats);
            else
                System.out.println(" -- INVALID");
            System.out.println("zoo = " + zoo);
        }
    }

}
