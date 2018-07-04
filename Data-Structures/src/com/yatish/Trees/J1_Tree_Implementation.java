package com.yatish.Trees;

public class J1_Tree_Implementation {

	public static void main(String[] args) {
		BinaryTreeImplementation obj = new BinaryTreeImplementation();
		obj.root = new Node(1);
		obj.root.left = new Node(2);
		obj.root.right = new Node(3);
		obj.root.left.left = new Node(4);
		obj.root.left.right = new Node(5);
		obj.root.right.left = new Node(6);
		obj.root.right.right = new Node(7);
	}

}

class BinaryTreeImplementation {
	
	Node root;
	
}

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
	}
}
