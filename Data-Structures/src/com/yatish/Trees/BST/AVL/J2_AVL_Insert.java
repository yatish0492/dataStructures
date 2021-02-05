package com.yatish.Trees.BST.AVL;

/*
    How do we re-balance the tree if it becomes im-balanced after insertion/deletion?
        We need to rotate the nodes to make it balanced. Following is how we do rotation,

        * T1, T2 and T3 are subtrees of the tree

        Right Rotation 'y'
        ------------------
                    y                               x
                   / \     Right Rotation          /  \
                 x   T3   - - - - - - - >        T1   y
                / \                                  / \
              T1  T2                                T2  T3

        We need to bend the parent link towards the side it is slanting. In this case, bend the above line of
        'x' connecting to 'y' to the right and make that as right child.
        Since 'y' became right child, previous right child 'T2' will be moved to 'y's left child.


        Left Rotation 'x'
        -----------------
                    x                               y
                   / \     Left Rotation          /  \
                T1   y   - - - - - - - >         x   T3
                    / \                         / \
                   T2  T3                     T1  T2

        We need to bend the parent link towards the side it is slanting. In this case, bend the above line of
        'y' connecting to 'x' to the left and make that as left child.
        Since 'x' became left child, previous left child 'T2' will be moved to 'x's right child.


      We come across 4 cases to re-balance the tree
      ---------------------------------------------
      a) Left Left Case
      ------------------
             z                                      y
            / \                                   /   \
           y   T4      Right Rotate (z)         x      z
          / \          - - - - - - - - ->      /  \    /  \
         x   T3                               T1  T2  T3  T4
        / \
      T1   T2


      b) Left Right Case
      ------------------
            z                               z                           x
           / \                            /   \                        /  \
          y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
         / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
       T1   x                          y    T3                    T1  T2 T3  T4
           / \                       / \
         T2   T3                   T1   T2

      c) Right Right Case
      -------------------
                z                                y
               /  \                            /   \
              T1   y     Left Rotate(z)       z      x
                  /  \   - - - - - - - ->    / \    / \
                 T2   x                     T1  T2 T3  T4
                     / \
                   T3  T4

       d) Right Left Case
       ------------------
                z                            z                            x
               / \                          / \                          /  \
             T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
                 / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
                x   T4                      T2   y                  T1  T2  T3  T4
               / \                              /  \
             T2   T3                           T3   T4

 */
public class J2_AVL_Insert {

    public static void main(String[] args) {
        AVLNodeTree obj = new AVLNodeTree();

        // Make sure you assign the return value to 'obj.root' because the root variable may change based on re-balance.
        obj.root = obj.insertNode(1, obj.root);
        obj.root = obj.insertNode(2, obj.root);
        obj.root = obj.insertNode(3, obj.root);
        obj.root = obj.insertNode(4, obj.root);
        obj.root = obj.insertNode(4, obj.root);

        System.out.println("Done");

    }
}

class AVLNode {
    Integer data;
    int height;
    int count;
    AVLNode left;
    AVLNode right;

    public AVLNode(Integer data) {
        this.data = data;
    }
}

class AVLNodeTree {
    AVLNode root;

    public Integer max(Integer a, Integer b) {
        if(a>b) {
            return a;
        }
        return b;
    }

    public Integer height(AVLNode node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    // Right rotate
    public AVLNode rightRotate(AVLNode node) {
        AVLNode leftChild = node.left;
        AVLNode rightChild = node.right;

        //perform right rotation
        leftChild.right = node;
        node.left = rightChild;

        // Update Heights. Updating heights of node and its left child because those are the ones whoes levels are
        // changed after re-balancing.
        node.height = max(height(node.left), height(node.right)) + 1;
        leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1;

        // return new root node
        return leftChild;
    }


    // Left Rotate
    public AVLNode leftRotate(AVLNode node) {
        AVLNode leftChild = node.left;
        AVLNode rightChild = node.right;

        //perform left rotation
        rightChild.left = node;
        node.right = leftChild;

        // Update Heights. Updating heights of node and its left child because those are the ones whoes levels are
        // changed after re-balancing.
        node.height = max(height(node.left), height(node.right)) + 1;
        rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1;

        //return new root node
        return rightChild;
    }

    public Integer getBalance(AVLNode node) {
        if(node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }



    public AVLNode insertNode(Integer newKey, AVLNode node) {
        //Insertion is same as that of BST insertion.
        if(node == null) {
            return new AVLNode(newKey);
        }
        if(newKey < node.data) {
            node.left = insertNode(newKey, node.left);
        } else if (newKey > node.data) {
            node.right = insertNode(newKey, node.right);
        } else if(newKey == node.data) {
            node.count++;
            return node;
        }


        // Setting height
        node.height = max(height(node.left), height(node.right)) + 1;

        //Re-balancing
        //------------
        // If balance is greater then 1 then lft tree level is more lenghty and causing im-balance in tree.
        // If balance is less then -1 then right tree level is more lenghty and causing im-balance in tree.
        Integer balance = getBalance(node);

        //Left Left Case
        if(balance > 1 && newKey < node.left.data) {
            return rightRotate(node);
        }

        //Left Right Case
        if(balance > 1 && newKey > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //Right Right Case
        if(balance < -1 && newKey > node.right.data) {
            return leftRotate(node);
        }

        //Right Left Case
        if(balance < -1 && newKey < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

}
