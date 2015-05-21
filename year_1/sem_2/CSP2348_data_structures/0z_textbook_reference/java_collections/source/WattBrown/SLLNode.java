package WattBrown;

class SLLNode {

    protected Object element;    // ... value contained in this node.
    protected SLLNode succ;      // ... link to this node's successor.

    protected SLLNode (Object elem, SLLNode succ) {
        // Construct a node with value elem and successor succ.
        this.element = elem;
        this.succ = succ;
    }
}
