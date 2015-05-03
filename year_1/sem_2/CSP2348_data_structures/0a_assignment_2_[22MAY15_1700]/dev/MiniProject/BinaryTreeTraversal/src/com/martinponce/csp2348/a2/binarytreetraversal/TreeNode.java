package com.martinponce.csp2348.a2.binarytreetraversal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// Class TreeNode definition
public class TreeNode {

    protected TreeNode left;   // left node
    protected Object data;     // data item
    protected TreeNode right;  // right node

    public TreeNode(Object newData) {
        data = newData;
        left = right = null;
    }

    public synchronized void insert(Integer number) {
        // new value is less than the node's data's value
        if (number.intValue() < ((Integer) data).intValue()) {
            if (left == null) {
                left = new TreeNode(number);
            } else {
                left.insert(number);
            }

        } // assignment operator allows duplicate values
        else if (number.intValue() >= ((Integer) data).intValue()) {
            if (right == null) {
                right = new TreeNode(number);
            } else {
                right.insert(number);
            }
        }
    }

    // get right child
    public synchronized TreeNode getRight() {
        return right;
    }

    // get left child
    public synchronized TreeNode getLeft() {
        return left;
    }

    // return the data
    public synchronized Object getData() {
        return data;
    }
}  // end class TreeNode

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
