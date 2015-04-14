# Review questions

## Binary trees

### 1:

How many leaf nodes does a fully balanced tree of depth d = 3 have?

n = 2<sup>d</sup>  
= 2<sup>3</sup>  
= 8

### 2:

How many nodes does a fully balanced binary tree of depth d = 3 have?

n = 2<sup>d+1</sup> - 1  
= 2<sup>3+1</sup> - 1  
= 2<sup>4</sup> - 1  
= 15

### 3:

What is the range of possible depths of a binary tree with 100 nodes?

d = floor(log<sub>2</sub>100)  
log<sub>2</sub>64 = 6, log<sub>2</sub>128 = 7  
floor(log<sub>2</sub>100) = 6  
d = 6

### 4:

What are the advantages and disadvantages of using a BST?

Advantage: Has O(log<sub>2</sub>n) efficiency in insertions/deletions.  
Disadvantage: May be come very unbalanced, and efficiency becomes O(n).

### 5:

Insert the following 10 states in the US that firstly ratified the US constitution into a BST. After the insertion, show the results of in-order, pre-order and post-order visitations of this BST.

![5-0](http://snag.gy/B3Cjn.jpg)

- In-order LVR:
	1. CT
	2. DE
	3. GA
	4. MA
	5. MD
	6. NH
	7. NJ
	8. PA
	9. SC
	10. VA
- Pre-order VLR:
	1. MD
	2. DE
	3. CT
	4. GA
	5. MA
	6. PA
	7. NJ
	8. NH
	9. SC
	10. VA
- Post-order LRV:
	1. CT
	2. MA
	3. GA
	4. DE
	5. NH
	6. NJ
	7. VA
	8. SC
	9. PA
	10. MD
