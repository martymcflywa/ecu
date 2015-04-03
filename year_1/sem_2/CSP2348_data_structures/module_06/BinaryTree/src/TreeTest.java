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

        System.out.println("Inserting the following values: ");

        // insert 10 random integers from 0-99 in tree
        for (int i = 0; i < 10; i++) {
            value = a[i];
            System.out.print(value + " ");

            tree.insertNode(value);
        }

        // perform preorder traveral of tree
        System.out.println("\n\nPreorder traversal");
        tree.preorderTraversal();

        // perform inorder traveral of tree
        System.out.println("\n\nInorder traversal");
        tree.inorderTraversal();

        // perform postorder traveral of tree
        System.out.println("\n\nPostorder traversal");
        tree.postorderTraversal();
        System.out.println();
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
