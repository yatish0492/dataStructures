package com.yatish.Trees;

/*
    What is Continuous Trees?
        Every distinct path of tree from root to leafs should be having difference between node value as 1.

    Input :          3
                    / \
                   2   4
                  / \   \
                 1   3   5

    Output: "Yes"
        // 3->2->1 every two adjacent node's absolute difference is 1
        // 3->2->3 every two adjacent node's absolute difference is 1
        // 3->4->5 every two adjacent node's absolute difference is 1

    Input :          7
                    / \
                   5   8
                  / \   \
                 6   4   10
    Output: "No"
        // 7->5->6 here absolute difference of 7 and 5 is not 1.
        // 7->5->4 here absolute difference of 7 and 5 is not 1.
        // 7->8->10 here absolute difference of 8 and 10 is not 1.
 */
public class J9_Countinuous_Tree {

    public static void main(String[] args) {
        ContinuousTree obj = new ContinuousTree();
        obj.root = new Node(3);
        obj.root.left = new Node(2);
        obj.root.right = new Node(4);
        obj.root.left.left = new Node(1);
        obj.root.left.right = new Node(3);
        obj.root.right.right = new Node(5);

        System.out.println(obj.isContinuousTree(obj.root));
    }
}


class ContinuousTree {

    public Node root;

    // For each and every node, we are checking if the difference between node and its immediate children is 1 or not.
    // To decide if it is continuous tree or not.
    public boolean isContinuousTree(Node node) {

        // if node is null
        if(node == null) {
            return true;
        }



        // if node has only left child
        if(node.left != null && node.right == null) {
            if(Math.abs(node.data - node.left.data) != 1) {
                return false;                       // NOTE : We should use conditions for return 'false' but not 'true'
            }                                       //        because if we give 'true' condition here for first node
        }                                           //        or root node. the condition will be satisfied and returned
                                                    //        so other nodes recursive call ll not happen. Only the
                                                    //        base condition mentioned above should return true which
                                                    //        will break the recursion.
        // if node has only right child
        if(node.left == null && node.right != null) {
            if(Math.abs(node.data - node.right.data) != 1) {
                return false;
            }
        }

        // if node has both left and right child
        // if node has only left child
        if(node.left != null & node.right != null) {
            if(Math.abs(node.data - node.left.data) != 1 || Math.abs(node.data - node.right.data) != 1) {
                return false;
            }
        }

        return isContinuousTree(node.left) && isContinuousTree(node.right);

    }

}
