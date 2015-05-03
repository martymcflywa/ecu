package com.martinponce.csp2348.a2.binarytreetraversal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// Class Tree definition
public class Tree {

    protected TreeNode root;

    // Construct an empty Tree of integers
    public Tree() {
        root = null;
    }

    // Insert a new node in the binary search tree.
    // If the root node is null, create the root node here.
    // Otherwise, call the insert method of class TreeNode.
    public synchronized void insertNode(Integer d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            root.insert(d);
        }
    }

    // Preorder Traversal
    public synchronized void preorderTraversal() {
        preorderHelper(root);
    }

    // Recursive method to perform preorder traversal
    private synchronized void preorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    // Inorder Traversal
    public synchronized void inorderTraversal() {
        inorderHelper(root);
    }

    // Recursive method to perform inorder traversal
    private synchronized void inorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.left);
        System.out.print(node.data + " ");
        inorderHelper(node.right);
    }

    // Postorder Traversal
    public synchronized void postorderTraversal() {
        postorderHelper(root);
    }

    // Recursive method to perform postorder traversal
    private synchronized void postorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.print(node.data + " ");
    }

    /****************************************
     * Additions by Martin Ponce begin here *
     ****************************************/

    /**
     * Method prints leaf nodes only.
     */
    public synchronized void printLeafOnly() {
        printLeafHelper(root);
    }

    /**
     * Recursive method to print leaf nodes only.
     * Using in-order traversal: Left, Value, Right.
     *
     * @param node TreeNode.
     */
    private synchronized void printLeafHelper(TreeNode node) {
        if(node == null) {
            return;
        }

        printLeafHelper(node.left);

        if(node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }

        printLeafHelper(node.right);
    }

    /**
     * Method prints non-leaf nodes only.
     */
    public synchronized void printNonLeafOnly() {
        printNonLeafHelper(root);
    }

    /**
     * Recursive method to print non-leaf nodes only.
     * Using in-order traversal: Left, Value, Right.
     *
     * @param node TreeNode.
     */
    private synchronized void printNonLeafHelper(TreeNode node) {
        if(node == null) {
            return;
        }

        printNonLeafHelper(node.left);

        if(node.left != null || node.right != null) {
            System.out.print(node.data + " ");
        }

        printNonLeafHelper(node.right);
    }

    public synchronized int getHeight() {
        return getHeightHelper(root);
    }

    private synchronized int getHeightHelper(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) {
            return 0;
        }

        return Math.max(getHeightHelper(node.left), getHeightHelper(node.right)) + 1;
    }
}  // end class Tree
/**
 * ************************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and Prentice Hall. * All
 * Rights Reserved. * * DISCLAIMER: The authors and publisher of this book have
 * used their * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs * to
 * determine their effectiveness. The authors and publisher make * no warranty
 * of any kind, expressed or implied, with regard to these * programs or to the
 * documentation contained in these books. The authors * and publisher shall not
 * be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ************************************************************************
 */
