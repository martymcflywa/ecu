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

![2-2]()

## Task 3

Test the Java implementation of a `Binary Search Tree` given in `TreeTest.java`.

1. Execute this program
2. Use the first line of values to draw this BST
3. Hand-test the visitation of this BST in terms of Pre-order, In-order and Post-order traversals
4. Compare your results with the executed results

## Task 4

Given the following traversal orders, draw the binary tree:

1. Pre-order
	- A, B, D, C, E, F, G
2. In-order
	- B, D, A, E, C, G, F
