package com.yatish.Trees;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    /*@Override
    public boolean equals(Object node) {
        boolean result = true;
        if(node instanceof Node) {
            Node tempNode = (Node) node;
            if(this.data == tempNode.data) {
                if(this.left == null || tempNode.left == null) {

                } else
            } this.left.equals(tempNode.left) && this.right.equals(tempNode.right)) {
                return true;
            }
        }
        return false;
    }*/
}