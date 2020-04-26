package com.yatish.Trees;

public class J7_Implement_Tree_Using_Array {

    public static void main(String[] args) {


        /*
                    A(0)
                   /   \
                 B(1)  C(2)
                /   \      \
              D(3)  E(4)   F(6)

              We will assign the indexes for nodes as follows, before only as shown below,

                      0
                   /    \
                  1      2
                /   \   /  \
               3    4  5    6
               ... etc.

             we get index of child node by formula
                        '(parentIndex * 2) + 1'  --> left node
                        '(parentIndex * 2) + 2'  --> right node
             eg: 1 is parent index then left child index is '(1*2)+1' = 3.

        */

        TreeUsingArray obj = new TreeUsingArray();
        obj.setRoot("A");
        obj.setLeftNode("B", 0);
        obj.setRightNode("C", 0);

    }

}

class TreeUsingArray {

    int root = 0;
    String[] tree = new String[10];

    public void setRoot(String rootNode) {
        tree[0] = rootNode;
    }

    public void setLeftNode(String newNode, int parentIndex) {
        int index = (parentIndex * 2) + 1;
        if(tree[parentIndex] == null) {
            System.out.println("Parent element not found");
        }
        tree[index] = newNode;
    }

    public void setRightNode(String newNode, int parentIndex) {
        int index = (parentIndex * 2) + 2;
        if(tree[parentIndex] == null) {
            System.out.println("Parent element not found");
        }
        tree[index] = newNode;
    }
}
