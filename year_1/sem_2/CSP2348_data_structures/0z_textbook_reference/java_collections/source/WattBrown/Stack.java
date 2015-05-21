package WattBrown;

public interface Stack {

    // Stack values are stacks whose elements are arbitrary objects.

    // Accessors:

    public boolean isEmpty ();
        // Return true if and only if this stack is empty.

    public Object getLast ();
        // Return the element at the top of this stack, or null if this
        // stack is empty.

    // Transformers:

    public void clear ();
        // Make this stack empty.

    public void addLast (Object x);
        // Add x as the top element on this stack.

    public Object removeLast ();
        // Remove and return the top element from this stack, or null if this
        // stack is empty.
}
