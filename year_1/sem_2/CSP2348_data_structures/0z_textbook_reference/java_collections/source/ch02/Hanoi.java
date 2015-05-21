public class Hanoi {

    private static void shift (int n, int source, int dest) {
        if (n == 1)
            move(source, dest);
        else {
            int spare = 6 - source - dest;
            shift(n-1, source, spare);
            move(source, dest);
            shift(n-1, spare, dest);
        }
    }


    private static void move (int source, int dest) {
        System.out.println("Move disk from " + source
                + " to " + dest + ".");
    }


    public static void main (String[] args) {
        int ndisks = Integer.parseInt(args[0]);
        shift(ndisks, 1, 2);
    }

}
