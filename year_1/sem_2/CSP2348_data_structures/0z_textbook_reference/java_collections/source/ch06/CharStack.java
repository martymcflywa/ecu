public class CharStack {

    private char[] elems;
    private int top;

    private static int maxSize = 100;

    public CharStack () {
        elems = new char[maxSize];
        top = 0;
    }

    public void addLast (char x) {
        elems[top++] = x;
    }

    public char removeLast () {
        return elems[--top];
    }

    public boolean isEmpty () {
        return (top == 0);
    }

}
