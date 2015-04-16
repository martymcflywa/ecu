package lab;

public class WS0702 {

    private static final int MASK = 0x7FFFFFFF; // 2^32-1
    private static final int CAPACITY = 101;

    public static void main(String[] args) {

        printHash("Rad");
        printHash("Uhr");
        printHash("Ohr");
        printHash("Tor");
        printHash("Hut");
        printHash("Tag");
    }

    private static void printHash(String word) {
        System.out.println("hash(" + word + ") = " + hash(word));
    }

    private static int hash(Object object) {
        return (object.hashCode() & MASK) % CAPACITY;
    }
}
