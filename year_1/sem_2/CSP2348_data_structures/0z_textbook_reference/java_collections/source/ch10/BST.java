public class BST {

    // Each BST object is (a header of) a binary search tree (BST).
    // This BST is represented simply by a reference to its root node (root).
    protected BSTNode root;
    
    public BST () {
    // Construct an empty BST.
        this.root = null;
    }
    
    public BSTNode search (Comparable target) {
    // Find which if any node of this BST contains an element equal to target. 
    // Return a link to that node (or null if there is none).
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTNode curr = this.root;
        for (;;) {
            if (curr == null)
                return null;
            direction = target.compareTo(curr.element);
            if (direction == 0)
                return curr;
            if (direction < 0)
                curr = curr.left;
            else  // direction > 0
                curr = curr.right;
        }
    }
    
    public void insert (Comparable elem) {
    // Insert the element elem in this BST.
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTNode parent = null, curr = root;
        for (;;) {
            if (curr == null) {
                BSTNode ins = new BSTNode(elem);
                if (root == null)
                    root = ins;
                else if (direction < 0)
                    parent.left = ins;
                else  // direction > 0
                    parent.right = ins;
                return;
            }
            direction = elem.compareTo(curr.element);
            if (direction == 0)
                return;
            parent = curr;
            if (direction < 0)
                curr = curr.left;
            else  // direction > 0
                curr = curr.right;
        }
    }
    
    public void delete (Comparable elem) {
    // Delete the element elem in this BST.
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTNode parent = null, curr = this.root;
        for (;;) {
            if (curr == null)
                return;
            direction = elem.compareTo(curr.element);
            if (direction == 0) {
                BSTNode del = curr.deleteTopmost();
                if (curr == this.root)
                    this.root = del;
                else if (curr == parent.left)
                    parent.left = del;
                else  // curr == parent.right
                    parent.right = del;
                return;
            }
            parent = curr;
            if (direction < 0)
                curr = parent.left;
            else  // direction > 0
                curr = parent.right;
        }
    }

}
