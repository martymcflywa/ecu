package WattBrown;

import java.util.Iterator;

public interface Tree {

    // Each Tree object is a tree whose elements are arbitrary objects.

    //////////// Accessors ////////////

    public boolean isEmpty ();
    // Return true is and only if this tree is empty.

    public int size ();
    // Return the number of nodes in this tree.

    public Tree.Node root ();
    // Return the root node of this tree, or null if this tree is empty.

    public Tree.Node parent (Tree.Node node);
    // Return the parent of node in this tree, or null if node is the root node.

    public Iterator children (Tree.Node parent);
    // Return an iterator that visits all the children of node parent in
    // this tree, in the order they were added.

    public int childCount (Tree.Node parent);
    // Return the number of children of node parent in this tree.

    public Object element (Tree.Node node);
    // Return the element in node in this tree.

    //////////// Transformers ////////////

    public void clear ();
    // Make this tree empty.

    public void makeRoot (Object elem);
    // Make this tree consist of just a root node containing element elem.

    public Tree.Node addChild (Tree.Node parent, Object elem);
    // Add a node containing element elem as a child of node parent in
    // this tree. Return the node just added.

    public Object remove (Tree.Node node);
    // Remove node from this tree, together with all its descendants.
    // Return the element in that node.

    //////////// Iterators ////////////

    public Iterator nodesInOrder ();
    // Return an iterator that visits all nodes of this tree, with an in-order
    // traversal.

    public Iterator nodesPreOrder ();
    // Return an iterator that visits all nodes of this tree, with a pre-order
    // traversal.

    public Iterator nodesPostOrder ();
    // Return an iterator that visits all nodes of this tree, with a post-order
    // traversal.

    //////////// Inner interface for tree nodes ////////////

    public interface Node {

        // Each Tree.Node object is a tree node. It contains a single element
        // and has an arbitrary number of children.

        //////////// Accessor ////////////

        public Object getElement ();

        //////////// Transformer ////////////

        public void setElement (Object elem);
    }
}