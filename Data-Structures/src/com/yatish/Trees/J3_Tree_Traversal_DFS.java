package com.yatish.Trees;

// NOTE: In-Order traversal of a Binary Search Tree will give elements in ascending order.
public class J3_Tree_Traversal_DFS {

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
		BinaryTree1 obj = new BinaryTree1();
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
		
		
		
		System.out.println("PreOrderTraversal");
		System.out.println("-----------------");
		obj.PreOrderTraversal(obj.root);
		System.out.println("PostOrderTraversal");
		System.out.println("-----------------");
		obj.PostOrderTraversal(obj.root);
		System.out.println("InOrderTraversal");
		System.out.println("-----------------");
		obj.InOrderTraversal(obj.root);
				
		

	}

}

class BinaryTree1 {
	
	Node root;

	/*
			  50
           /     \
          30      70
	 */
	
	/*
	 * Depth First Traversal (PreOrder)
	 * -------------------------------
	 *	root - left - right
	 *  50 - 30 - 70
	 */
	public void PreOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data);
		PreOrderTraversal(node.left);
		PreOrderTraversal(node.right);	
	}

	/*
	 * Depth First Traversal (PostOrder)
	 * -------------------------------
	 *	left - right - root
	 *  30 - 70 - 50
	 */
	public void PostOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		PostOrderTraversal(node.left);
		PostOrderTraversal(node.right);
		System.out.println(node.data);
		
	}

	/*
	 * Depth First Traversal (InOrder)
	 * -------------------------------
	 *	left - root - right
	 *  30 - 50 - 70
	 */
	public void InOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		InOrderTraversal(node.left);
		System.out.println(node.data);
		InOrderTraversal(node.right);
		
	}
}
