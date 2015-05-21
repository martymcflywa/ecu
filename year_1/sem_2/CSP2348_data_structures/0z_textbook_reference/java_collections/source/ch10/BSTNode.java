public class BSTNode {

    // Each BSTNode object is a BST node.
    // This node is represented by its element (element) together with
    // references to its left child (left) and its right child (right).
    // For every element x stored in the subtree at left:
    //    x.compareTo(element) < 0
    // For every element y stored in the subtree at right:
    //    y.compareTo(element) > 0
    protected Comparable element;
    protected BSTNode left, right;
    
    public BSTNode (Comparable elem) {
    // Construct a BST node with element elem and no children.
        this.element = elem;
        this.left = null;
        this.right = null;
    }
     
    public BSTNode deleteTopmost () {
    // Delete the topmost element in the subtree whose topmost node is this.
    // Return a link to the modified subtree.
        if (left == null)
             return right;
        else if (right == null)
            return left;
        else {  // this node has both a left child and a right child
            element = right.getLeftmost();
            right = right.deleteLeftmost();
            return this;
        }
    }
    
    private BSTNode deleteLeftmost () {
    // Delete the leftmost node of the (nonempty) subtree
    // whose topmost node is this.
    // Return a link to the modified subtree.
        BSTNode parent = null, curr = this;
        while (curr.left != null) {
            parent = curr;  curr = curr.left;
        }
        if (curr == this)
            return this.right;
        else {
            parent.left = curr.right;
            return this;
        }
    }
    
    private Comparable getLeftmost () {
    // Return the element in the leftmost node of the (nonempty) subtree
    // whose topmost node is this.
        BSTNode curr = this;
        while (curr.left != null)
            curr = curr.left;
        return curr.element;
    }

    public static int sizeOfSubtree (BSTNode top) {
        if (top == null)
            return 0;
        else
            return 1 + sizeOfSubtree(top.left) + sizeOfSubtree(top.right);
    }

}
