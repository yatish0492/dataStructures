package com.yatish.Trees;

import java.util.Stack;

/*
    For non recursive inorder traversal,
        we will have a stack and we will keep adding the left nodes until last/leaf node. Then we will pop the
        node(print) and goto its right child
        and
        again keep adding the left nodes until last/leaf node. we will continue the same steps repeatedly until the
        stack becomes empty.
 */
public class J3_1_Tree_Traversal_InOrder_NonRecursive {

    public static void main(String[] args) {
        /*
						1
					-------------
					|		    |
					2		    3
				--------	     ---------
				|	   |     |		 |
			    4	   5     6		 7
			------   ----  -----   ------
			|    |   |   | |   |  |     |
			8    9  10  11 12  13 14    15
		*/
        InOrderNonRecursive obj = new InOrderNonRecursive();
        obj.root = new Node(1);
        obj.root.left = new Node(2);
        obj.root.right = new Node(3);
        obj.root.left.left = new Node(4);
        obj.root.left.right = new Node(5);
        obj.root.right.left = new Node(6);
        obj.root.right.right = new Node(7);
        obj.root.left.left.left = new Node(8);
        obj.root.left.left.right = new Node(9);
        obj.root.left.right.left = new Node(10);
        obj.root.left.right.right = new Node(11);
        obj.root.right.left.left = new Node(12);
        obj.root.right.left.right = new Node(13);
        obj.root.right.right.left = new Node(14);
        obj.root.right.right.right = new Node(15);

        obj.printInOrder(obj.root);
    }

}

class InOrderNonRecursive {

    Node root;

    public void printInOrder(Node node) {

        Stack<Node> stack = new Stack<Node>();

        while(node != null || !stack.isEmpty()) {

            // Going till last left node
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            System.out.println(node.data);

            node = node.right;

        }
    }
}
