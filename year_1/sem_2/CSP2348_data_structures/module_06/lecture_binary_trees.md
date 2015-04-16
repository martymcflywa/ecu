# Binary tree data structures

## Binary tree properties

- A binary tree consists of a **header**, plus a number of **nodes** connected by **links** in a *hierarchical* data structure
	- The header contains a link to a node designated as the **root node**
		- The header itself is **not** a node of the tree
	- Each node contains an **element** (value or object), plus links to at most two other nodes
		- Called its **left child** and **right child**

![binary tree header, root, child](http://snag.gy/lk1bw.jpg)

- A **leaf node** is one that has no children
	- ie. Both its links are null
- Every node, except the root node, is the left or right child of exactly one other node
	- Called **parent** node of the children nodes
	- The root node has **no parent**, the only link to it is the header
- The **size** of a binary tree is the number of nodes (elements)
	- An **empty** binary tree has size Zero
	- Its header is null

![binary tree leaf node, parent node](http://snag.gy/7ybEn.jpg)

### Binary trees and subtrees

- Each node has both a **left subtree** and a **right subtree**
	- Either or both which may be empty
- A node's left/right subtree consists of the node's left/right child together with that child's own children, grandchildren, etc.
	- Of recursive definition

![binary tree subtree](http://snag.gy/tOm9L.jpg)

### Node and tree depths

#### Node depth

- Observation:
	- For any node, say N, in a tree, there is exactly one sequence of links between the root node and N
- The **depth** of node N is the number of links between the root node and N

![binary tree node depth](http://snag.gy/pwfEq.jpg)

#### Tree depth

- The **depth** of a tree is the depth of the deepest node in the tree
	- A tree consisting of a single node has depth 0
	- By convention, an **empty** tree has depth of **-1**

![binary tree tree depth](http://snag.gy/eoITo.jpg)

#### Balanced tree

- A binary tree of depth d is **balanced** if all its
	- Nodes at depths 0, 1, ..., d-2 have two children
		- ie. All occupied
	- Nodes at depth d-1 (all occupied) may have two/one/no children
	- Nodes at depth d have no children
		- This they are leaf nodes
		- Leaves can only be in the last two levels
			- Nodes in other levels must have two children
- A binary tree of depth 0 or 1 is **always** balanced

![binary tree balanced](http://snag.gy/CeCcu.jpg)

##### Example

- An n-node balanced binary tree of depth d has at least 2<sup>d</sup> nodes and at most 2<sup>d+1</sup> - 1 nodes
	- ie. 2<sup>d</sup> &le; n < 2<sup>d+1</sup>
- Depth (d) of balanced binary tree of size n: d = floor(log<sub>2</sub>n)

![binary tree depth example](http://snag.gy/B4fOB.jpg)

#### Fully balanced tree

- A binary tree of depth d is **fully balanced** if all nodes at depths 0, 1, ..., d-1 have two children
- A fully balanced binary tree depth of d has 2<sup>d+1</sup> nodes
	- ie. n = 2<sup>d+1</sup> - 1
	- The number of nodes of a depth-d fully balanced binary tree reaches maximum
- Depth (d) of a fully balanced binary tree of size n: d = floor(log<sub>2</sub>n)

![binary tree fully balanced](http://snag.gy/3e4Uf.jpg)

#### Ill-balanced tree

- A binary tree of depth d is **ill-balanced** if any node at depths 0, 1, ..., d-2 has only one or no child
	- ie. Nodes are not fully occupied at d-1

![binary tree ill-balanced](http://snag.gy/Oqmdv.jpg)

- An ill-balanced binary tree of depth d could have as few as d+1 nodes
- Conversely:
	- Max. depth (d<sub>max</sub>) of ill-balanced binary tree size, of size n, can be:
		- d<sub>max</sub> = n-1

![binary tree very ill-balanced](http://snag.gy/DuMK9.jpg)

## Binary tree traversal

- Binary tree **traversal:**
	- Visit all nodes (elements) of the tree in some predetermined order
		- ie. Visit per node once and only once
	- Must:
		1. Visit root node, R
		2. Traverse the left subtree l
		3. Traverse the right subtree r
	- But in which order?
- **Pre-order** traversal (R-l-r)
	- Visit root node R
	- Traverse left subtree
	- Traverse right subtree
		- Value
		- Left
		- Right
- **In-order** traversal (l-R-r)
	- Traverse left subtree
	- Visit root node R
	- Traverse right subtree
		- Left
		- Value
		- Right
- **Post-order** traversal (l-r-R)
	- Traverse left subtree
	- Traverse right subtree
	- Visit root node R
		- Left
		- Right
		- Value

### Pre-order traversal

- Schematic for pre-order traversal (R-l-r)
	- Visit root node R
	- Traverse left subtree
	- Traverse right subtree

![schematic pre-order](http://snag.gy/3zXUQ.jpg)

- Illustration (R-l-r)

![illus pre-order](http://snag.gy/RZzVG.jpg)

- Result:
	- lion, fox, cat, dog, rat, pig, tiger

#### Generic pre-order algorithm

>To traverse, in pre-order, the subtree whose root node is top:

>1. If top is not null:
	1. Visit top
	2. Traverse, in pre-order, top's left subtree
	3. Traverse, in pre-order, top's right subtree
2. Terminate

- This algorithm is **generic:**
	- The meaning of "Visit..." in step 1.1 is left *open*
- Note that the algorithm is **recursive**

### In-order traversal

- Schematic for in-order traversal (l-R-r):
	- Traverse left subtree
	- Visit root node
	- Traverse right subtree

![schematic in-order](http://snag.gy/oAgh2.jpg)

- Illustration (l-R-r)

![illus in-order](http://snag.gy/MEBkg.jpg)

- Result:
	- cat, dog, fox, lion, pig, rat, tiger
- Note: If the BT is a binary-search-tree, the in-order traversal will visit the elements in ascending order

#### Generic in-order algorithm

>To traverse, in in-order, the subtree whose root node is top:

>1. If top is not null:
	1. Traverse, in in-order, top's left subtree
	2. Visit top
	3. Traverse, in in-order, top's right subtree
2. Terminate

### Post-order traversal

- Schematic for post-order traversal (l-r-R)
	- Traverse left subtree
	- Traverse right subtree
	- Visit root node

![schematic post-order](http://snag.gy/TLOqe.jpg)

- Illustration (l-r-R)

![illus post-order](http://snag.gy/rvPlp.jpg)

- Result:
	- dog, cat, fox, pig, tiger, rat, lion

#### Generic post-order algorithm

>To traverse, in post-order, the subtree whose root node is top:

>1. If top is not null:
	1. Traverse, in post-order, top's left subtree
	2. Traverse, in post-order, top's right subtree
	3. Visit top
2. Terminate

## Binary search trees (BST)

- A binary search tree (BST) is a binary tree with the following property:
	- For any node in the binary tree, if that node contains element elem, then:
		- Its left subtree (if not empty) contains only elements less than elem
		- Its right subtree (if not empty) contains only elements greater than elem

### BST examples

![bst examples](http://snag.gy/xQhfg.jpg)

### BST Java implementation

#### BST Nodes

``` java
public class BSTNode {
	protected Comparable element;
	protected BSTNode left, right;
	protected BSTNode(Comparable elem) {
		element = elem;
		left = null;
		right = null;
	}
	// BSTNode methods to follow
}
```

#### BST headers

``` java
public class BST {
	private BSTNode root;
	public BST() {
		// construct empty BST
		root = null;
	}
	// BST methods to follow
}
```

### BST searching

- **Problem:**
	- Search for a given target value in a BST
- **Idea:**
	- Compare the target value with the element in the root node
		- If the target value is **equal**, search is successful
		- If target value is **less**, search the right subtree
		- If target value is **greater**, search the right subtree
		- If subtree is **empty**, search is unsuccessful

#### BST search algorithm

>To find which if any node of a BST contains an element equal to target:

>1. Set curr ot the BSTs root
2. Repeat:
	1. If curr is null, terminate with answer non
	2. Otherwise, if target is equal to curr's element, terminate with answer curr
	3. Otherwise, if target is less than curr's element, set curr to curr's left child
	4. Otherwise, if target is greater than curr's element, set curr to curr's right child

#### BST search successful

![anim bst search success](http://i.imgur.com/KviU21l.gif)

#### BST search unsuccessful

![anim bst search unsuccessful](http://i.imgur.com/ZXEKaeX.gif)

#### BST search analysis

- **Counting comparisons:**
	- Let the BST's size be n
	- If the BST has depth d, the number of comparisons at most is d+1
		- If the BST is **well balanced**, its depth is floor(log<sub>2</sub>n)
			- Max. no. of comparisons = floor(log<sub>2</sub>n) + 1
			- Best-case time complexity is O(log n)
		- If the BST is **ill-balanced**, its depth is at most n-1
			- Max. no. of comparisons = n
			- Worst-case time complexity is O(n)

#### BST search implementation in Java

``` java
public BSTNode search(Comparable target) {
	int direction = 0;
	BSTNode curr = root;

	for(;;) {

		if(curr == null) {
			return null;
		}

		direction = target.compareTo(curr.element);

		if(direction == 0) {
			return curr;
		} else if(direction < 0) {
			curr = curr.left;
		} else {
			curr = curr.right;
		}
	}
}
```

### BST insertion

- **Idea:**
	- To insert a new element into a BST, proceed as if searching for that element
		- If the element is present, no insert is needed
		- If the element is not already present, the search will lead to a null link
			- Replace the null link by a link to a leaf node containing the new element

#### BST insertion algorithm

>To insert the element elem into a BST:

>1. Set parent to null, and set curr to BST's root
2. Repeat:
	1. If curr is null, replace the null link from which curr was taken by a link to a newly-created leaf node with element elem, and terminate
	2. Otherwise, if elem is equal to curr's element, terminate
	3. Otherwise, if elem is less than curr's element, set parent to curr and set curr to curr's left child
	4. Otherwise, if elem is greater than curr's element, set parent to curr and set curr to curr's right child

#### Insert empty BST

![anim bst insert empty](http://i.imgur.com/wyhH02Y.gif)

#### Insert non-empty BST

![anim bst insert non-empty](http://i.imgur.com/2Wzm5bP.gif)

#### BST insertion analysis

- **Counting comparisons:**
	- No. of comparisons is the same as for BST search
		- If BST is **well balanced:**
			- Max. no. of comparisons = floor(log<sub>2</sub>n) + 1
			- Best case time complexity is O(log n)
		- If BST is **ill balanced:**
			- Max. no of comparisons = n
			- Worst case time complexity is O(n)

#### Building a BST in practice

- Starts with an empty BST
- Whether a BST is well-balanced or ill-balanced depends on order of insertions
	- If the inserted elements are randomly ordered, the BST will probably be reasonably **well-balanced**
		- Or close to **balanced**
	- If the inserted elements happen to be in ascending/descending order, the BST will be extremely **ill-balanced**

#### Example: Successive insertions

##### Randomly ordered insertions

- Inserting:
	- 'lion', 'fox', 'rat', 'cat', 'pig', 'dog', 'tiger'

![bst successive insert random](http://i.imgur.com/e208zjD.gif)

##### Ascending/descending ordered insertions

- Inserting:
	- 'cat', 'dog', 'fox', 'lion', 'pig', 'rat'

![bst successive insert ascend/descend](http://i.imgur.com/20zNy6N.gif)

### BST deletion

- Three cases to consider
	- Deleting a subtree's leftmost element
	- Deleting a subtree's topmost element
	- Deleting an arbitrary given element in a BST

#### Delete leftmost element

- **Problem:** Delete the leftmost element in a subtree
- Two cases to consider:
	1. The subtree's topmost node has no left child
	2. The subtree's topmost node has a left child
- Note: By definition, the leftmost node has no left child

##### Case 1: No left child

- Case 1
	- Topmost node has no left child:
		- Discard the topmost node, but retain its right subtree

![bst delete leftmost no left child](http://snag.gy/MY5Sy.jpg)

##### Case 2: Has left child

- Case 2
	- Topmost node has a left child
		- Link the leftmost node's parent to the leftmost node's right child

![bst delete leftmost has left child](http://snag.gy/X8TF4.jpg)

##### Delete leftmost element algorithm

>To delete the leftmost element in the (nonempty) subtree whose topmost node is top:

>1. If top has no left child: // case 1
	1. Terminate with top's right child as answer
2. If top has a left child: // case 2
	1. Set parent to top, and set curr to top's left child
	2. While node curr has a left child, repeat:
		1. Set parent to curr, and set curr to curr's left child
	3. Set parent's left child to curr's right child
	4. Terminate with top as answer

#### Delete topmost element

- **Problem:** Delete the topmost element in a subtree
- Four cases to consider:
	1. The topmost node has no children
	2. The topmost node has a right child but no left child
	3. The topmost node has a left child but no right child
	4. The topmost node has two children

##### Case 1: Has no children

- Case 1
	- Topmost node has no children
		- Make the subtree empty

![bst delete topmost no child](http://snag.gy/bBL16.jpg)

##### Case 2: Has right child, no left child

- Case 2
	- Topmost node has a right child but no left child
		- Discard the topmost node, but retain its right subtree

![bst delete topmost has right no left](http://snag.gy/XhxyV.jpg)

##### Case 3: Has left child, no right child

- Case 3
	- Topmost node has a left child but no right child
		- Discard the topmost node, but retain its left subtree

![bst delete topmost has left no right](http://snag.gy/7YAZ0.jpg)

##### Case 4: Has left and right child

- Case 4
	- Topmost node has left and right child
		- Copy the right subtree's leftmost element into the topmost node, then delete the right subtree's leftmost element

![bst delete topmost has both](http://snag.gy/hipPB.jpg)

##### Delete topmost element algorithm

>To delete the topmost element in the subtree whose topmost node is top:

>1. If top has no left child: // case 1/2
	1. Terminate with top's right child as answer
2. If top has no right child: // case 3
	1. Terminate with top's left child as answer
3. If top has two children: // case 4
	1. Set top's element to the leftmost element in top's right subtree
	2. Delete the leftmost element in top's right subtree
	3. Terminate with top as answer

###### Auxiliary algorithm: determine leftmost element

>To determine the leftmost element in the nonempty subtree whose topmost node is top:

>1. Set curr to top
2. While curr has a left child, repeat:
	1. Set curr to curr's left child
3. Terminate with curr's element as answer

###### Deleting a given element

![bst delete given element](http://i.imgur.com/BsUKzI4.gif)

## Guide

- Reading
	- Chapter 10: Java Collections
	- Chapter 7: Data Structures & Algorithms
- Next lecture
	- Hash tables
	- Second test: Array sorting, linked lists and binary trees
