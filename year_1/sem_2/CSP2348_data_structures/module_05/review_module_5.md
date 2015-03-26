# Review questions

## Linked lists

1. The reference to the next node in a Single Linked List (SLL) is referred to as a \_\_\_\_\_\_\_\_\_\_
	- Link
2. The length of a linked list is its number of links
	- False
3. The length of a linked list is its number of nodes
	- True
4. Given some predetermined sequential order, visiting all the nodes / several contiguous nodes of a SLL is called a \_\_\_\_\_\_\_\_\_\_ of the SLL
	- Traversal
5. Explain why the array-based binary search algorithm is unsuitable for linked lists?
	- Binary search is efficient for arrays, because of the middle component of any array can be accessed directly, using simple arithmetic to compute its index
	- But binary search is not efficient for linked lists because the middle node of a linked list could be accessed only by counting n / 2 nodes from the first (assuming we already know the linked lists length n)
	- Such a traversal would take O(n) time, thus destroying the O(log n) time complexity that we aim to achieve with binary search
6. Analyse the time complexity of Algorithm 4.23 on Page 87 of textbook

>To find which if any node of the SLL headed by first contains an element equal to target:

>1. For each node curr of the SLL headed by first, repeat:
	1. If target is equal to node curr's element, terminate with answer curr
2. Terminate with answer none

- Number of comparison: (n + 1) / 2
- = O(n)
