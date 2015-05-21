public class BtreeNode {

	// Each BtreeNode object is a B-tree node.
	// This node is represented as follows: its elements occupy the subarray
	// elems[0...size-1], and links to its child nodes are held in the subarray
	// childs[0...size]. For each element elems[i], childs[i] is a link
	// to its left child, and childs[i+1] is a link to its right child.
	// Moreover, for every element x in the left subtree of elem:
	//    x.compareTo(elem) < 0
	// and for every element y in the right subtree of elem:
	//    y.compareTo(elem) > 0
	// In the case of a leaf node, all components of childs are null.
	protected int size;
	protected Comparable[] elems;
	protected BtreeNode[] childs;

	protected BtreeNode (int k, Comparable elem,
							BtreeNode left, BtreeNode right) {
	// Construct a B-tree node of arity k, initially with one element, elem,
	// and two children, left and right.
		elems = new Comparable[k];
		childs = new BtreeNode[k+1];
		// ... Each array has one extra component, to allow for future overflow.
		size = 1;
		elems[0] = elem;
		childs[0] = left;
		childs[1] = right;
	}


	protected BtreeNode (int k, Comparable[] elems,
							BtreeNode[] childs, int l, int r) {
	// Construct a B-tree node of arity k, with its elements taken from the
	// subarray elems[l...r-1] and its children from the subarray
	// childs[l...r].
		elems = new Comparable[k];
		childs = new BtreeNode[k+1];
		// ... Each array has one extra component, to allow for future overflow.
		size = 0;
		for (int j = l; j < r; j++) {
			elems[size] = elems[j];
			childs[size] = childs[j];
			size++;
		}
		childs[size] = childs[r];
	}
}
