package WattBrown;

import java.util.NoSuchElementException;

public class LinkedStack implements Stack {

    // Stack values are stacks whose elements are arbitrary objects.

    // This stack is represented as follows: top is a link to the first node
    // of a SLL containing the stack's elements.
    private SLLNode top;

    public LinkedStack () {
        // Construct a new  stack, initially empty.
        top = null;
    }

    public boolean isEmpty () {
        // Return true if and only if this stack is empty.
        return (top == null);
    }

    public Object getLast () {
        // Return the element at the top of this stack.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public void clear () {
        // Make this stack empty.
        top = null;
    }

    public void addLast (Object x) {
        // Add x as the top element on this stack.
        top = new SLLNode(x, top);
    }

    public Object removeLast () {
        // Remove and return the top element from this stack.
        if (top == null)
            throw new NoSuchElementException();
        Object topElem = top.element;
        top = top.succ;
        return topElem;
    }

}
