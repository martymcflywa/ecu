# Tutorial 06: Binary tree data structures

## Task 1

Explain the relationship between the depth and node of a binary tree using the examples given below:

1. How many nodes does a fully-balanced binary tree of depth 4 have?
	- n = 2<sup>d+1</sup> - 1
	- = 2<sup>4+1</sup> - 1
	- = 2<sup>5</sup> - 1
	- = 31
2. What is the maximum depth of a balanced binary tree of 30 nodes?
	- d = floor(log<sub>2</sub>30)
	- log<sub>2</sub>16 = 4, log<sub>2</sub>32 = 5
	- floor(log<sub>2</sub>30) = 4
3. Verify your answers above by drawing illustrative binary trees

**Fully balanced tree depth 4:**

![1-1](http://snag.gy/ldjrO.jpg)

**Balanced tree w/ 30 nodes:**

![1-2](http://snag.gy/brT4q.jpg)

## Task 2

Consider a binary search tree (BST) whose elements are abbreviated names of chemical elements.

1. Starting with an empty BST, show the effect of successively inserting the following elements:
	- H, C, N, O, AI, Si, Fe, Na, P, S, Ni, Ca
2. Show the effect of successively deleting Si, N, O from the resulting BST

**Successive inserts:**

![2-1](http://snag.gy/1z2zU.jpg)

**Successively deleting Si, N, O:**

![2-2](http://snag.gy/erb4Q.jpg)

## Task 3

Test the Java implementation of a `Binary Search Tree` given in `TreeTest.java`.

1. Execute this program
2. Use the first line of values to draw this BST
3. Hand-test the visitation of this BST in terms of Pre-order, In-order and Post-order traversals
4. Compare your results with the executed results

**BST hand-drawn:**

Values: 49, 76, 67, 29, 75, 18, 4, 83, 87, 40  
Note: During an insert iteration, look back to root, then check for less than or greater than to determine next placement.

![3-2](http://snag.gy/gQMIw.jpg)

**BST traverse orders:**

**Java output:**

```
Preorder traversal
49 29 18 4 40 76 67 75 83 87

Inorder traversal
4 18 29 40 49 67 75 76 83 87

Postorder traversal
4 18 40 29 75 67 87 83 76 49
```

**Hand output:**

- Pre-order: VLR
	- 49, 29, 18, 4, 40, 76, 67, 75, 83, 87
- In-order: LVR
	- 4, 18, 29, 40, 49, 67, 75, 76, 83, 87
		- Note: Result is **IN ORDER!!**
- Post-order: LRV
	- 4, 18, 40, 29, 75, 67, 87, 83, 76, 49

## Task 4

Given the following traversal orders, draw the binary tree:

1. Pre-order: VLR
	- A, B, D, C, E, F, G
2. In-order: LVR
	- B, D, A, E, C, G, F

Recall that the pre-order traversal traverses the binary tree in the order of root, left subtree, right subtree (VLR). This order can be used to determine the root node of a subtree. Specifically, the first element in the pre-order must be element of the root node. The in-order traversal traverses the binary tree in the order of left subtree, root, right subtree (LVR). The in-order sequence can be used to determine nodes in its left and/or right subtrees.

From the given pre-order sequence, we know that A is the element of the root node of the tree, because A appears first in the pre-order. Then, from the in-order sequence, the whole sequence can be divided into three parts, as (B, D) A, (E, C, G, F). A's left subtree contains elements B, D because B, D are the only elements appearing before A in pre-order. Similarly, A's right subtree contains elements E, C, G, F. We can draw initially a conceptual binary tree like this:

![4-1 concept](http://snag.gy/7yVvI.jpg)

From the above A's left subtree, as B appears before D in the pre-order, B must be the root of the subtree. In addition, B also appears before D in the in-order, indicating that D must be in B's right subtree, which contains D as the only node. Thus we have:

![4-2 left subtree](http://snag.gy/3Mkf9.jpg)

Similary, in A's right subtree, C appears before E, G, F in the pre-order. This means that C is the root node of the subtree. To work out which nodes in C's left or right subtrees, we check these nodes in the in-order.

In the in-order sequence, E appears before C, indicating that E is in C's left subtree. And G and F appear after C in the in-order, indicating they are in C's right subtree.

![4-3 right subtree](http://snag.gy/jkkZn.jpg)

Following the same principle, we can work out the appearance of C's subtrees shown below.

![4-4 complete tree](http://snag.gy/YImrk.jpg)
