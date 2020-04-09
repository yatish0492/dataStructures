package com.yatish.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
        Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom (i.e. the deleted
        node is replaced by bottom most and rightmost node)

    Example :

    Delete 10 in below tree
       10
     /    \
    20     30
    Output :
       30
     /
    20


    Delete 20 in below tree
       10
     /    \
    20     30
            \
            40
    Output :
       10
     /   \
    40    30
 */
public class J6_Removing_Node_From_Tree {

    public static void main(String[] args) {
        BinaryTreeRemoval obj = new BinaryTreeRemoval();
        obj.root = new Node(1);
        obj.root.left = new Node(2);
        obj.root.right = new Node(3);
        obj.removeNodeAndReplaceWithLastNode(1);
        obj.printInOder(obj.root);
    }

}

class BinaryTreeRemoval {

    Node root;

    // Basically, it will replace the 'data' of the node to be removed with the last node 'data', which means basically,
    // the deleted node is replaced with the last node. then we will delete the last node from the tree.
    // We use BFS order to do this operation.
    public Integer removeNodeAndReplaceWithLastNode(Integer data) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        Node nodeToBeDeletedInTree = null;
        Node currentNode = null;

        while(!queue.isEmpty()) {
            currentNode = queue.remove();

            if (currentNode.data == data) {
                nodeToBeDeletedInTree = currentNode;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        if(nodeToBeDeletedInTree != null) {
            Node lastNode = currentNode;
            nodeToBeDeletedInTree.data = lastNode.data;
            deleteNode(lastNode);
            return nodeToBeDeletedInTree.data;
        }
        return null;
    }

    // we are using the same BFS method to do this deletion as well.
    public void deleteNode(Node lastNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();

            if(currentNode == lastNode && queue.size() == 1) {
                root = null;
            }
            if(currentNode.left != null) {
                if(currentNode.left == lastNode) {
                    currentNode.left = null;
                    return;
                }
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                if(currentNode.right == lastNode) {
                    currentNode.right = null;
                    return;
                }
                queue.add(currentNode.right);
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
