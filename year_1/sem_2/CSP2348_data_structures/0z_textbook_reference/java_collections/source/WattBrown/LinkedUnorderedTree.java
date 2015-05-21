package WattBrown;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedUnorderedTree implements Tree {

    // Each LinkedUnorderedTree object is an unordered tree whose
    // elements are arbitrary objects.
    // This tree is represented by a reference to its root node (root), which
    // is null if the tree is empty. Each tree node contains links to its first
    //  child, to its parent, and to its next sib.

    private LinkedUnorderedTree.Node root;

    //////////// Constructor ////////////

    public LinkedUnorderedTree () {
    // Construct a tree, initially empty.
        root = null;
    }

    //////////// Accessors ////////////

    public boolean isEmpty () {
    // Return true is and only if this tree is empty.
    	return (root == null);
    }

    public int size () {
    	throw new UnsupportedOperationException(); // TEMPORARY
    }

    public Tree.Node root () {
    // Return the root node of this tree, or null if this tree is empty.
        return root;
    }

    public Tree.Node parent (Tree.Node node) {
    // Return the parent of node in this tree, or null if node is the root node.
        return ((LinkedUnorderedTree.Node) node).parent;
    }

    public int childCount (Tree.Node node) {
    // Return the number of children of node in this tree.
        LinkedUnorderedTree.Node parent =
                (LinkedUnorderedTree.Node) node;
        LinkedUnorderedTree.Node child =
                parent.firstChild;
        int count = 0;
        while (child != null) {
            count++;
            child = child.nextSib;
        }
        return count;
    }

    public String toString () {
    // Convert this tree into a string representation.
    	return toString(root);
    }

    public String toString (Tree.Node node) {
    // Convert this (sub-)tree into a string representation.
        if (node == null)
            return "Empty tree";
        else
            return node.toString();
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this tree empty.
    	root = null;
    }

    public void makeRoot (Object elem) {
    // Make this tree consist of just a root node containing element elem.
        root = new LinkedUnorderedTree.Node(elem);
    }

    public Tree.Node addChild (Tree.Node node, Object elem) {
    // Add a new node containing element elem as a child of node in this
    // tree. The new node has no children of its own. Return the node
    // just added.
        LinkedUnorderedTree.Node parent =
                (LinkedUnorderedTree.Node) node;
        LinkedUnorderedTree.Node newChild =
                new LinkedUnorderedTree.Node(elem);
        newChild.parent = parent;
        newChild.nextSib = parent.firstChild;
        parent.firstChild = newChild;
        return newChild;
    }

    public Object remove (Tree.Node node) {
    // Remove node from this tree, together with all its descendants.
        LinkedUnorderedTree.Node curr = (LinkedUnorderedTree.Node) node;
        if (curr == root) {
            root = null;
            return curr.element;
        }
        LinkedUnorderedTree.Node parent = curr.parent;
        if (curr == parent.firstChild)
            parent.firstChild = curr.nextSib;
        else {
            LinkedUnorderedTree.Node prevSib = parent.firstChild;
            while (prevSib.nextSib != curr)
                prevSib = prevSib.nextSib;
            prevSib.nextSib = curr.nextSib;
        }
        return curr.element;
    }

    public Object element (Tree.Node node) {
    	return node.getElement();
    }

    //////////// Iterators ////////////

    public Iterator children (Tree.Node node) {
    	return new LinkedUnorderedTree.ChildrenIterator(
    	        (LinkedUnorderedTree.Node) node);
    }

    public Iterator nodesInOrder () {
    // Return an iterator that visits all nodes of this tree, with an in-order
    // traversal.
        return new LinkedUnorderedTree.InOrderIterator();
    }

    public Iterator nodesPreOrder () {
    // Return an iterator that visits all nodes of this tree, with a pre-order
    // traversal.
        return new LinkedUnorderedTree.PreOrderIterator();
    }

    public Iterator nodesPostOrder () {
    // Return an iterator that visits all nodes of this tree, with a post-order
    // traversal.
        return new LinkedUnorderedTree.PostOrderIterator();
    }

    //////////// Inner classes ////////////

    private static class Node implements Tree.Node {

        // Each LinkedUnorderedTreeNode object is a  node of an
        // unordered tree, and contains a single element.
        // This tree node consists of an element (element), a link to its first
       // child (firstChild) a link to its parent (parent), and a link to its
        // next sib (nextSib).

        private Object element;
        private LinkedUnorderedTree.Node firstChild, parent, nextSib;

        private Node (Object elem) {
            // Construct a tree node, containing element elem, that has no
            // children, no parent, and no sibs.
            this.element = elem;
            this.firstChild = null;
            this.parent = null;
            this.nextSib = null;
        }

        public Object getElement () {
        // Return the element contained in this node.
            return this.element;
        }

        public String toString () {
        // Convert this tree node and all its children to a string.
            String children = "";
            for (LinkedUnorderedTree.Node curr = firstChild; curr != null;
                    curr = curr.nextSib) {
                children += curr.toString();
            }
            return element.toString() + children;
        }

        public void setElement (Object elem) {
        // Change the element contained in this node to be elem.
            this.element = elem;
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    private static class ChildrenIterator implements Iterator {

        private LinkedUnorderedTree.Node curr, prev;

        private ChildrenIterator (LinkedUnorderedTree.Node node) {
            curr = node.firstChild;
            prev = null;
        }

        public boolean hasNext () {
            return (curr != null);
        }

        public Object next () {
            if (curr == null)
                throw new NoSuchElementException();
            prev = curr;
            curr = curr.nextSib;
            return prev;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    private class InOrderIterator implements Iterator {

        private Stack track;  // sequence of nodes not yet visited

        private InOrderIterator () {
            track = new LinkedStack();
            LinkedUnorderedTree.Node curr = root;
            while (curr != null) {
                track.addLast(curr);
                curr = curr.firstChild;
            }
        }

        public boolean hasNext () {
            return (! track.isEmpty());
        }

        public Object next () {
            LinkedUnorderedTree.Node place =
                    (LinkedUnorderedTree.Node) track.removeLast();
            LinkedUnorderedTree.Node curr = place.nextSib;
            while (curr != null) {
                track.addLast(curr);
                curr = curr.firstChild;
            }
            return place.element;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    private class PreOrderIterator implements Iterator {

        private Stack track;  // sequence of nonempty subtrees still to be visited

        private PreOrderIterator () {
            track = new LinkedStack();
            if (root != null)
                track.addLast(root);
        }

        public boolean hasNext () {
            return (! track.isEmpty());
        }

        public Object next () {
            LinkedUnorderedTree.Node place =
                    (LinkedUnorderedTree.Node) track.removeLast();
            if (place.nextSib != null)
                track.addLast(place.nextSib);
            if (place.firstChild != null)
                track.addLast(place.firstChild);
            return place.element;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    private class PostOrderIterator implements Iterator {

        private Stack track;  // sequence of nonempty subtrees still to be visited

        private PostOrderIterator () {
            track = new LinkedStack();
            if (root != null)
                track.addLast(root);
        }

        public boolean hasNext () {
            return (! track.isEmpty());
        }

        public Object next () {
            LinkedUnorderedTree.Node place =
                    (LinkedUnorderedTree.Node) track.removeLast();
            if (place.nextSib != null)
                track.addLast(place.nextSib);
            if (place.firstChild != null)
                track.addLast(place.firstChild);
            return place.element;
        }

        public void remove () {
    	    throw new UnsupportedOperationException();
        }
    }

}