package com.yatish.Trees;


public class J2_1_Tree_Traversal_Return_Void_vs_Node {}

/*
    If we need to update child of parent node then we need to return 'Node'. following functions explain this in detail.
 */
// We are trying to change the node 10 with node 12.
class TreeVoidNodeReturn {
    Node root;


    public void RecursionWithVoidReturn(Node node) {
        // base condition.
        if(node == null) {
            return;
        }
        node.left = new Node(10);   // this will change the left child of the node in tree
        node.right = new Node(11);  // this will change the right child of the node in tree

        if(node.data == 10) {
            node = new Node(12);    // doesn't work, reason mentioned in detail below
        }
        /*
            But above line won't change the value of node in the tree because, 'node' is just a pointer to the node in
            tree. by executing above line it will create new object somewhere and point to it. So tree node vaule still
            remains unaffected.

            What is the solution then?
                We need to execute 'parentNode.left = new Node(12)' or 'parentNode.right = new Node(12)' but passing
                parent to the function recursively is also difficult say like,
                        IteratingWithVoidReturn(node.left, node);
                        IteratingWithVoidReturn(node.right, node);
                                While executing 'IteratingWithVoidReturn' function on call of above mentioned lines, we
                                have 'parent' but we don't know whether parent's left node is sent or right node is sent
                                inside the function. We might have to pass one more parameter mentioning whether its
                                right or left child is passed.
                More efficient way is returning a 'Node' and assigning it to corresponding place.
                So, only solution is to return 'Node' instead of 'void' as shown in 'IteratingWithNodeReturn'
         */


        RecursionWithVoidReturn(node.left);
        RecursionWithVoidReturn(node.right);
    }

    public Node RecursionWithNodeReturn(Node node) {
        if(node == null) {
            return null;
        }

        if(node.data == 10) {
            node = new Node(12); // we know that this doesn't work. based on discussion in 'IteratingWithVoidReturn'
            return new Node(12); //this works, as the returned value will be assigned to parent nodes left or right.
                                        // based on 'node.left = IteratingWithNodeReturn(node.left);' or
                                        //          'node.right = IteratingWithNodeReturn(node.right);'
                                        // which call is currently executing the function.
        }

        // we need to assign the returned value to 'node.left', if we are passing 'node.left'.
        node.left = RecursionWithNodeReturn(node.left);
        // we need to assign the returned value to 'node.right', if we are passing 'node.right'.
        node.right = RecursionWithNodeReturn(node.right);
        return node;    // if we are returning the same node then same node will be assigned back so there will be
                        // no change for that node in the tree.
    }
}
