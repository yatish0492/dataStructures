package com.yatish.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
    We will check the nodes from left to right (BFS) and then add the new node if we find any nodes having empty
    left child if not then empty right child.
 */
public class J5_Adding_Node_To_Tree {

    public static void main(String[] args) {
        BinaryTreeInsertion obj = new BinaryTreeInsertion();
        obj.root = new Node(1);
        obj.insertNode(new Node(2));
        obj.insertNode(new Node(3));

        obj.printInOder(obj.root);
    }

}

class BinaryTreeInsertion {
    Node root;

    public void insertNode(Node newNode) {
        Queue<Node> tempQueue = new LinkedList<Node>();
        tempQueue.add(root);
        // We will store nodes in this Queue in BFS order. we will remove each node and check it its left child is empty,
        // if so then new node will be added to it, if not then it ill check if right and add to it. If noth are not empty,
        // then this node will be removed from the Queue and next node will be checked for same.

        while(!tempQueue.isEmpty()) {
            Node currentNode = tempQueue.remove();
            if(currentNode.left == null) {
                currentNode.left = newNode;
                break;
            } else {
                tempQueue.add(currentNode.left);
            }
            if(currentNode.right == null) {
                currentNode.right = newNode;
                break;
            } else {
                tempQueue.add(currentNode.right);
            }
        }
    }

    public void printInOder(Node node) {
        if(node == null) {
            return;
        }
        printInOder(node.left);
        System.out.println(node.data);
        printInOder(node.right);
    }
}
