package com.yatish.Trees.BST;

import com.yatish.Trees.Node;

// NOTE: In-Order traversal will give the elements in ascending order. eg: inorder traversal prints - 6,8,9,10,11,12,13
//          in this program example.
public class J1_BST_Implementation {

    public static void main(String[] args) {

        /*
						10
					-------------
					|		    |
					8		    12
				--------	  --------
				|	   |      |		 |
			    6	   9     11      13

         */

        BinarySearchTree obj = new BinarySearchTree();

        obj.root = new Node(10);
        obj.root.left = new Node(8);
        obj.root.right = new Node(12);
        obj.root.left.left = new Node(6);
        obj.root.left.right = new Node(9);
        obj.root.right.left = new Node(11);
        obj.root.right.right = new Node(13);

        System.out.println(obj.isBST(obj.root));



    }

}

class BinarySearchTree {
    Node root;
    Node prev;

    public boolean isBST(Node current) {

        if(current == null) {
            return true;
        }

        if(isBST(current.left) == false) {
            return false;
        }

        if(prev != null && current.data <= prev.data) {
            return false;
        }

        prev = current;

        return isBST(current.right);

    }

}
