package com.yatish.Trees;

/*
    Printing spiral fashion means, like snake fashion as shown below,

    -------------------------->
                              |
    <--------------------------
    |
    --------------------------->
                               |
                               etc.

     NOTE: it is same as that of BFS traversal with recursion. but we need to use a flag to say like rightToLeft and
           based on that we need to reverse the recursive call 'right' first and then 'left' next.
 */
public class J4_1_Tree_Traversal_Spiral {

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
        BinaryTree3 obj = new BinaryTree3();
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

        obj.printLevelOrderWithRecursionWithLevelInformation();

    }

}


class BinaryTree3 {

    Node root;

    public void printLevelOrderWithRecursionWithLevelInformation() {
        int height = findHeight(root);
        boolean rightToLeft = false;
        for (int i = 0; i <= height; i++) {
            if(i%2 == 0) {
                rightToLeft = true;
            } else {
                rightToLeft = false;
            }
            printGivenLevel(root, i, rightToLeft);
            System.out.println("\n");
        }

    }

    public int findHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftTreeHeight = findHeight(node.left);
            int rightTreeHeight = findHeight(node.right);

            if (leftTreeHeight < rightTreeHeight) {
                return rightTreeHeight + 1; // we are adding 1 to height counter as we goto each level reccursion.
            } else {
                return leftTreeHeight + 1;
            }
        }
    }

    public void printGivenLevel(Node node, int level, boolean rihtToLeft) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.print(node.data);
        } else {
            if(rihtToLeft) {
                printGivenLevel(node.left, level - 1, rihtToLeft);
                printGivenLevel(node.right, level - 1, rihtToLeft);
            } else {
                printGivenLevel(node.right, level - 1, rihtToLeft);
                printGivenLevel(node.left, level - 1, rihtToLeft);
            }
        }

    }
}


