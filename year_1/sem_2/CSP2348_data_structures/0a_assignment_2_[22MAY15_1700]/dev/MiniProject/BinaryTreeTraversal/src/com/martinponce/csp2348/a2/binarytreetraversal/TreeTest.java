package com.martinponce.csp2348.a2.binarytreetraversal;

// Fig. 19.18: TreeTest.java
// This program tests class Tree.
//import java.util.*;
// Class TreeTest definition
public class TreeTest {

    // test class Tree
    public static void main(String args[]) {
        Tree tree = new Tree();
        int value;
        int[] a = {49, 76, 67, 29, 75, 18, 4, 83, 87, 40};

        System.out.println("Inserting the following values to tree: ");

        // insert 10 random integers from 0-99 in tree
        for (int i = 0; i < 10; i++) {
            value = a[i];
            System.out.print(value + " ");

            tree.insertNode(value);
        }

        // perform preorder traveral of tree
        System.out.println("\n\nPre-order traversal of tree:");
        tree.preorderTraversal();

        // perform inorder traveral of tree
        System.out.println("\n\nIn-order traversal of tree:");
        tree.inorderTraversal();

        // perform postorder traveral of tree
        System.out.println("\n\nPost-order traversal of tree:");
        tree.postorderTraversal();
        System.out.println();

        /****************************************
         * Additions by Martin Ponce begin here *
         ****************************************/

        // test printLeafOnly
        System.out.println("\nPrint leaf nodes only for tree:");
        tree.printLeafOnly();
        System.out.println();

        // test printNonLeafOnly
        System.out.println("\nPrint non-leaf nodes only for tree:");
        tree.printNonLeafOnly();
        System.out.println();

        // test getHeight
        System.out.println("\nPrint height of tree:");
        System.out.println(tree.getHeight());
        System.out.println();

        // test methods with bigTree
        testBigTree();
    }

    /**
     * Method to test more complicated array.
     */
    private static void testBigTree() {

        Tree bigTree = new Tree();
        int bigTreeValue;
        int[] b = {49, 76, 67, 29, 75, 18, 4, 83, 87, 40, 80, 46, 42, 43, 45, 41};

        // testing bigTree
        System.out.println("Inserting the following values to bigTree: ");

        // insert 10 random integers from 0-99 in bigTree
        for (int i = 0; i < 16; i++) {
            bigTreeValue = b[i];
            System.out.print(bigTreeValue + " ");
            bigTree.insertNode(bigTreeValue);
        }

        // perform preorder traveral of bigTree
        System.out.println("\n\nPre-order traversal of bigTree:");
        bigTree.preorderTraversal();

        // perform inorder traveral of bigTree
        System.out.println("\n\nIn-order traversal of bigTree:");
        bigTree.inorderTraversal();

        // perform postorder traveral of bigTree
        System.out.println("\n\nPost-order traversal of bigTree:");
        bigTree.postorderTraversal();
        System.out.println();

        // test printLeafOnly for bigTree
        System.out.println("\nPrint leaf nodes only for bigTree:");
        bigTree.printLeafOnly();
        System.out.println();

        // test printNonLeafOnly for bigTree
        System.out.println("\nPrint non-leaf nodes only for bigTree:");
        bigTree.printNonLeafOnly();
        System.out.println();

        // test getHeight for bigTree
        System.out.println("\nPrint height of bigTree:");
        System.out.println(bigTree.getHeight());

        // test getHeight for empty tree
        Tree emptyTree = new Tree();
        System.out.println("\nPrint height of emptyTree:");
        System.out.println(emptyTree.getHeight());

        // test getHeight for single node tree
        Tree oneNodeTree = new Tree();
        oneNodeTree.insertNode(99);
        System.out.println("\nPrint height of oneNodeTree:");
        System.out.println(oneNodeTree.getHeight());

    }
}  // end class TreeTest

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
