import WattBrown.*;

public class Btree {

	// Each Btree object is a B-tree header.
	// This B-tree is represented  as follows: arity is the maximum number
	// of children in any node, and root is a link to its root node.
	private int arity;
	private BtreeNode root;

	public Btree (int k) {
	// Construct an empty B-tree of arity k.
		root = null;
		arity = k;
	}

	public BtreeNode search (Comparable target) {
    // Find which if any node of this B-tree contains an element equal to
    // target. Return a link to that node, or null if there is no such node.
    	BtreeNode curr = root;
    	for (;;) {
    		if (curr == null)
    			return null;
    		int pos = searchInNode(target, curr);
    		if (target.equals(curr.elems[pos]))
    			return curr;
    		else
    			curr = curr.childs[pos];
    	}
    }


    private int searchInNode (Comparable target, BtreeNode curr) {
    // Return the index of the leftmost element in node curr that is not less
    // than target.
        return -1;
    }


    public void insert (Comparable elem) {
    // Insert element elem into this B-tree.
    	if (root == null) {
    		root = new BtreeNode(arity, elem, null, null);
    		return;
    	}
    	Stack lineage = new LinkedStack();
    	BtreeNode curr = root;
    	for (;;) {
    		int pos = searchInNode(elem, curr);
    		if (elem.equals(curr.elems[pos]))
    			return;
    		else {
    			lineage.add(curr);
    			lineage.add(new Integer(pos));
    			if (curr.childs[0] == null) {
    				// curr is a leaf node
    				insertInNode(elem, null, null, lineage);
    				return;
    			} else
    				curr = curr.childs[pos];
    		}
    	}
    }


    private void insertInNode (Comparable elem,
						BtreeNode left, BtreeNode right,
						Stack lineage) {
    // Insert element elem, with children left and right, in the given node.
    // Split that node if necessary. The stack lineage contains the given node,
    // its parent, its grandparent, etc., together with the insertion position
    // in each of these nodes.
    	BtreeNode curr = (BtreeNode) lineage.remove();
    	int ins = ((Integer) lineage.remove()).intValue();
    	for (int i = curr.size; i > ins; i--) {
    		curr.elems[i] = curr.elems[i-1];
    		curr.childs[i+1] = curr.childs[i];
    	}
    	curr.size++;
    	curr.elems[ins] = elem;
    	curr.childs[ins] = left;
    	curr.childs[ins+1] = right;
    	if (curr.size == arity) {
    		int medpos = curr.size/2;
    		Comparable median = curr.elems[medpos];
    		BtreeNode sib = new BtreeNode(arity,
    				curr.elems, curr.childs, medpos+1, curr.size);
    		for (int j = medpos; j < curr.size; j++) {
    			curr.elems[j] = null;
    			curr.childs[j+1] = null;
    		}
    		curr.size = medpos;
    		if (curr == root)
    			root = new BtreeNode(arity, median, curr, sib);
    		else
    			insertInNode(median, curr, sib, lineage);
    	}
    }
}
