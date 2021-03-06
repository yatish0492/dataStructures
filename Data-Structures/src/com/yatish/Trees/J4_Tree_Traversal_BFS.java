package com.yatish.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
	BFS traversal
	---------------
	1) Level print nodes with recursive
	2) Level print nodes without recursive

 */
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
		obj.printLevelOrderWithoutRecursionWithLevelInformation();

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

	/*
	 Same as above method just that we will use a delimiter node between levels in the queue to distinguish the levels
	 of tree.

	NOTE : If we want to print the reverse order for a level, then we will add the child nodes to stack first until
			level end and then pop the elements and print it.
	      eg: Say like we need to print spiral, then first level we add to queue and print them next level we add to
	      		both stack and pop them and print them. Along with stack we will add to queue as well but not print
	      		because For next level we need to print left to right so for that we need parent level nodes left to right.
	*/
	public void printLevelOrderWithoutRecursionWithLevelInformation() {
		Queue<Node> tempQueue = new LinkedList<Node>();
		tempQueue.add(root);
		tempQueue.add(new Node(-99)); // we will use '-99' as delimiter for end of a level
		while (!tempQueue.isEmpty()) {
			Node currentNode = tempQueue.remove();


			if(currentNode.data == -99 && !tempQueue.isEmpty()) {  // So if we encounter -99 that means it is end of
				System.out.print("\n");							   // level and hence we will add -99 here and goto next
				tempQueue.add(new Node(-99));				   // line.
				continue;
			}

			System.out.print(currentNode.data);
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
