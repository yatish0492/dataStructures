package com.yatish.Trees;

import java.util.Stack;

public class J3_1_InOrderTraversal_NonRecursive {

    public static void main(String[] args) {
        InOrderTraversalTreeNonRecur obj = new InOrderTraversalTreeNonRecur();
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

class InOrderTraversalTreeNonRecur {
    Node root;

    public void printInOrder(Node currentNode) {

        // Empty Tree
        if(currentNode == null) {
            System.out.println("Empty Tree");
            return;
        }

        Stack<Node> stack = new Stack();

        while(currentNode != null || stack.size() > 0) {

            // go to the most left node.
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            System.out.println(currentNode.data);

            currentNode = currentNode.right;

        }
    }
}