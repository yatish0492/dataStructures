package com.yatish.Trees.BST;

import com.yatish.Trees.Node;

public class J2_BST_Search {

    public static void main(String[] args) {
        BSTSearch obj = new BSTSearch();

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

        System.out.println(obj.search(obj.root, 6));
    }
}

class BSTSearch {

    Node root;

    public boolean search(Node node, Integer searchElement) {
        if(node == null) {              // as usual we have hadded mandatory 'nod==null' condition
            return false;
        }
        if(node.data == searchElement) {
            return true;
        }
        // We are recursively calling function with node.left and then node.right so that these will iterate over all
        // nodes. but here we know we need not iterate over all nodes, so we are conditionally executing them.
        if(searchElement < node.data) {
            return search(node.left, searchElement);
        } else {
            return search(node.right, searchElement);
        }
    }
}



