package com.yatish.Trees;

/*
	What is a binary tree?
		Binary tree can have only 2 children. left and right child.

	What is skewed binary tree?
        Binary tree with only right childs or only left childs.
        eg:
                        10                              10
                          \                            /
                          20           OR             8
                            \                        /
                             30                     6
 */
public class J1_Tree_Implementation {

	public static void main(String[] args) {
		BinaryTreeImplementation obj = new BinaryTreeImplementation();

		/*create root*/
		obj.root = new Node(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

		obj.root.left = new Node(2);
		obj.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */


		obj.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
	}

}

class BinaryTreeImplementation {
	
	Node root;
	
}

