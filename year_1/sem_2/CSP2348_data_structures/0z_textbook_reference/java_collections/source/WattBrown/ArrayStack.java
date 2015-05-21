package WattBrown;

import java.util.NoSuchElementException;

public class ArrayStack implements Stack {

    // Stack values are stacks whose elements are arbitrary objects.

    // This stack is represented as follows: depth is its depth, and
    // elems[0...depth-1] are its elements.
    private Object[] elems;
    private int depth;


    public ArrayStack (int maxDepth) {
        // Construct a new  stack, initially empty.
        elems = new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Return true if and only if this stack is empty.
        return (depth == 0);
    }


    public Object getLast () {
        // Return the element at the top of this stack.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Make this stack empty.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void addLast (Object x) {
        // Add x as the top element on this stack.
        elems[depth++] = x;
    }


    public Object removeLast () {
        // Remove and return the top element from this stack.
        if (depth == 0)
            throw new NoSuchElementException();
        Object topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}
