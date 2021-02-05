package com.yatish.Trees;

/*
    Basically, the structure of left and right sub-tree of root element should be mirror of each other to be Foldable.

      Foldable Tree
      --------------
(a)
       10
     /    \
    7      15
     \    /
      9  11

(b)
        10
       /  \
      7    15
     /      \
    9       11


        Non - Foldable Tree
        -------------------
(a)
        10
       /  \
      7   15
     /    /
    5   11

(d)

         10
       /   \
      7     15
    /  \    /
   9   10  12

 */

public class J8_Check_Tree_Foldable {

    public static void main(String[] args) {
        FoldableTreeCheck obj = new FoldableTreeCheck();

        obj.root = new Node(10);
        obj.root.left = new Node(7);
        obj.root.left.left = new Node(5);
        obj.root.right = new Node(15);
        obj.root.right.right = new Node(11);

        boolean foldable = obj.isFoldable(obj.root.left, obj.root.right);

        System.out.println("Foldable - " + foldable);
    }

}

class FoldableTreeCheck {

    Node root;

    public boolean isFoldable(Node leftNode, Node rightNode) {
        if(leftNode == null && rightNode == null) {
            return true;
        }
        if(leftNode == null || rightNode == null) {
            return false;                      // NOTE : We should use conditions for return 'false' but not 'true'
        }                                     //        because if we give 'true' condition here for first node
                                             //        or root node. the condition will be satisfied and returned
                                            //        so other nodes recursive call ll not happen. Only the
                                           //        base condition mentioned above should return true which
                                          //        will break the recursion.


        // If you need to make sure that numbers are also same on the mirror image when folded and not only structure
        // then you can add one more condition here which checks if(leftNode.data != rightNode.data) then return false;

        return isFoldable(leftNode.left, rightNode.right) &&
                isFoldable(leftNode.right, rightNode.left);
    }

}
