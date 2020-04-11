package com.yatish.Trees.BST;

import com.yatish.Trees.Node;

/*
    In BST, removal of a nodes means we need fill that spot if it is not a leaf node.

    We need to consider 3 cases here,
    1) leaf node : Simply remove from the tree
              50                             50
           /     \         delete(20)      /   \
          30      70       --------->    30     70
         /  \    /  \                     \    /  \
       20   40  60   80                   40  60   80
                  \                             \
                  65                            65

    2) One child :  Copy the child to the node and delete the child
              50                             50
           /     \         delete(30)      /   \
          30      70       --------->    40     70
            \    /  \                          /  \
            40  60   80                       60   80
                  \                             \
                  65                            65

    3) 2 children : If it has 2 children,
                  if right child is leaf node,
                        then that right node itself will be used for replacing the deleted node. Then that right
                        node will be deleted.
                  if right child is not a leaf node,
                        then we will go to its right node and then go to its left nodes recursively and take the
                        last left node and replace the deleted node with this node and we will delete that last left
                        node used for replacement. which will be '60' in this case. If the last left node has a right
                        child then that child will be put in the place of last left node deleted.

                 NOTE: following is another way of finding which nodes should be replacing the deleted node,
                ----------------------------------------------------------------------------------------------
                    we will get the in-order traversal of the tree and the next element of the deletion element in this
                    traversal order will be used for replaced the deleted node. In this example, for the tree in-order
                    traversal order is 40,50,60,65,70,80. so in this in-order traversal next node after node '50' is '60',
                    so we are replacing '50' node with '60'

              50                             60
           /     \         delete(50)      /   \
          40      70       --------->    40    70
                 /  \                         /  \
                60   80                     65   80
                  \
                  65
            Consider we delete 60 after this, then it will be replaced with '70' as it right node doesn't have left
            child node. But once 70 is deleted '80' will become ophan right? No actually, we will apply the 3 cases
            of deletion, we discussed for that node as well. it will fall into case 2 and it will be replaced by '80'

              60                             65
           /     \         delete(60)      /   \
          40      70       --------->    40    70
                 /   \                           \
                65   80                          80

 */
public class J4_BST_Delete {

    public static void main(String[] args) {

        /*
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80
                      \
                      65
         */
        BSTDelete obj = new BSTDelete();
        obj.root = new Node(50);
        obj.root.left = new Node(30);
        obj.root.right = new Node(70);
        obj.root.left.left = new Node(20);
        obj.root.left.right = new Node(40);
        obj.root.right.left = new Node(60);
        obj.root.right.right = new Node(80);
        obj.root.right.left.right = new Node(65);


        obj.deleteNode(obj.root, 20);
        obj.deleteNode(obj.root, 30);
        obj.deleteNode(obj.root, 50);
        obj.deleteNode(obj.root, 60);


    }
}

class BSTDelete {

    Node root;

    // Make sure that you need to return 'Node' here, you cannot use 'void' as return type because we need to assign
    // different node to its parent.left or parent.right.
    public Node deleteNode(Node currentNode, Integer deletionKey) {
        if(currentNode == null) {
            return null;
        }


        if(currentNode.data == deletionKey) {

            // Case-1 and Case-2 is handled here.
            if(currentNode.left == null) {
                return currentNode.right;
            } else if(currentNode.right == null) {
                return currentNode.left;
            }

            // Case-3
            Node parentNode = currentNode;
            Node replacementNode = currentNode.right;

            // Iteration to goto the last left node recursively. preserving last nodes parent node in 'parentNode'
            // and last node in 'replacementNode'
            while(replacementNode.left != null) {
                parentNode = replacementNode;
                replacementNode = replacementNode.left;
            }
            // 'parentNode == currentNode' means the right node didn't have left node at all. so that means we need to
            // replace deleted 'deletionKey' node with right node. so deleted right node needs to be replaced with its
            // right child. if it doesn't have any right child then 'null' will be assigned.
            if(parentNode == currentNode) {
                currentNode.right = replacementNode.right;
            } else { // replacing the left last node with its right child.
                parentNode.left = replacementNode.right;
            }
            // replacing the deletion node key
            currentNode.data = replacementNode.data;
            return currentNode;
        }

        if(deletionKey < currentNode.data) {
            currentNode.left = deleteNode(currentNode.left, deletionKey);
            return currentNode;
        } else {
            currentNode.right = deleteNode(currentNode.right, deletionKey);
            return currentNode;
        }
    }

}
