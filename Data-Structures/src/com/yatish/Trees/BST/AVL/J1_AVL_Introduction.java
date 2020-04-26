package com.yatish.Trees.BST.AVL;


/*
    What is AVL?
        AVL tree is a self balancing binary search tree(BST). where difference between height of left and right
        subtree is not more than 1.
            AVL Tree                    Not AVL Tree --> as the hieght difference is 2 between left and right sub-tree.
            --------                    -------------
              50                             50
           /     \                         /   \
          30      70                     30     70
         /  \    /  \                   /  \    /  \
       20   40  60   80                20  40  60   80
                  \                   /  \
                  65                 19  21
                                     /
                                    18
    What is skewed binary tree?
        Binary tree with only right childs or only left childs.
        eg:
                        10                              10
                          \                            /
                          20           OR             8
                            \                        /
                             30                     6


    Why AVL trees?
        In the BST, the complexity of most of the operations like search,insert,delete,min,max etc is O(h), where 'h'
        is the height of the tree. If BST is a skewed binary tree then it can go upto O(n) at worst case, where 'n'
        is the number of nodes in the tree. whereas in case of AVL trees, its maximum height is always O(Logn) where,
        'n' is number of nodes in the tree. Hence AVL tree complexity at worst case is O(Logn) whereas for BST the worst
        case is O(n)


   As we keep on inserting/deleting elements in AVL, it might get imbalanced. how to handle this?
        We need to check if the tree is balanced/AVL after each insertion/deletion and if it is im-balanced then we
        need to re-balance it to make it AVL again.
 */
public class J1_AVL_Introduction {

}
