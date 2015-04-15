package csp2348.module05.linkedlists;

public class Main {

    private static MyLinkedList<String> testSLL = new MyLinkedList();

    public static void main(String[] args) {
        testSLL.insertFirstSLL("Alpha");
        testSLL.insertLastSLL("Charlie");
        testSLL.insertFirstSLL("Kilo");
        testSLL.insertFirstSLL("Delta");
        testSLL.insertLastSLL("Whiskey");
        testSLL.insertLastSLL("Tango");
        testSLL.insertLastSLL("Foxtrot");
        testSLL.insertAfterSLL("Lima", "Juliet");
        testSLL.insertAfterSLL("Lima", "Whiskey");
        testSLL.deleteTargetSLL("Foxtrot");
        testSLL.deleteFirstSLL();
        testSLL.deleteLastSLL();
        testSLL.deleteTargetSLL("Mike");
        testSLL.searchSLL("Charlie");
        testSLL.searchSLL("November");
        testSLL.deleteFirstSLL();
        testSLL.deleteLastSLL();
        testSLL.deleteTargetSLL("Charlie");
        testSLL.deleteFirstSLL();
        testSLL.deleteLastSLL();
        testSLL.deleteLastSLL();
    }
}
