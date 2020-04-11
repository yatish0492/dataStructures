package com.yatish.Trees.BST;

import com.yatish.Trees.Node;

/*
    While inserting node, it will start from
 */
public class J3_BST_Insert {

    public static void main(String[] args) {
        BSTInsert obj = new BSTInsert();

         /*
						10
					-------------
					|		    |
					8		    12
				--------	  --------
				|	   |      |		 |
			    6	   9     11      13

         */

        obj.root = new Node(10);
        obj.root.left = new Node(8);
        obj.root.right = new Node(12);
        obj.root.left.left = new Node(6);
        obj.root.left.right = new Node(9);
        obj.root.right.left = new Node(11);
        obj.root.right.right = new Node(13);

        obj.insertNode(obj.root, 7);

        /*
						10
					-------------
					|		    |
					8		    12
				--------	  --------
				|	   |      |		 |
			    6	   9     11      13
            --------
            |       |
           null     7     <-- Inserted here
         */

    }
}

class BSTInsert {
    Node root;

    public void insertNode(Node node, Integer newNodeKey) {
        if(node == null) {
            return;
        }
        // We are recursively calling function with node.left and then node.right so that these will iterate over all
        // nodes. but here we know we need not iterate over all nodes, so we are conditionally executing them.
        if(newNodeKey < node.data) {
            if(node.left == null) {
                node.left = new Node(newNodeKey);
                return;
            }
            insertNode(node.left, newNodeKey);
        } else {
            if(node.right == null) {
                node.right = new Node(newNodeKey);
                return;
            }
            insertNode(node.right, newNodeKey);
        }
    }

}
