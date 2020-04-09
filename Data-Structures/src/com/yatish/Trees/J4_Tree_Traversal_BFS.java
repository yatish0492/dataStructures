package com.yatish.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class J4_Tree_Traversal_BFS {

	public static void main(String[] args) {
		
		/*
				1
			-------------
			|		    |
			2		    3
		----------	    ---------
		|	     |       |		 |
		4	     5       6		 7
		------   ----  -----   ------
		|    |   |   | |   |  |     |
		8    9  10  11 12  13 14    15 
		*/
		BinaryTree2 obj = new BinaryTree2();
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

		obj.printLevelOrderWithoutRecursionWithoutLevelInformation();
		obj.printLevelOrderWithRecursionWithLevelInformation();

	}

}


class BinaryTree2 {
	
	Node root;

	public void printLevelOrderWithoutRecursionWithoutLevelInformation() {
		Queue<Node> tempQueue = new LinkedList<Node>();
		tempQueue.add(root);

		while (!tempQueue.isEmpty()) {
			Node currentNode = tempQueue.remove();
			System.out.println(currentNode.data);
			if (currentNode.left != null) {
				tempQueue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				tempQueue.add(currentNode.right);
			}
		}
	}
	
	public void printLevelOrderWithRecursionWithLevelInformation() {
		int height = findHeight(root);
		for(int i = 0; i <= height; i++) {
			printGivenLevel(root,i);
			System.out.println("\n");
		}

	}
	
	public int findHeight(Node node) {
		if(node == null) {
			return 0;
		} else {
			int leftTreeHeight = findHeight(node.left);
			int rightTreeHeight = findHeight(node.right);
			
			if(leftTreeHeight < rightTreeHeight) {
				return rightTreeHeight+1; // we are adding 1 to height counter as we goto each level reccursion.
			} else {
				return leftTreeHeight+1;
			}
		}
	}
	
	public void printGivenLevel(Node node,int level) {
		if(node == null) {
			return;
		} else if(level == 1) {
			System.out.print(node.data);
		} else {
			printGivenLevel(node.left,level-1);
			printGivenLevel(node.right,level-1);
		}
		
	}
}
