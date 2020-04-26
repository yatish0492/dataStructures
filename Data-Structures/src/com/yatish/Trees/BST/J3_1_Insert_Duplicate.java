package com.yatish.Trees.BST;

/*
    For inserting a duplicate node. we have 2 approaches as follows,
        1) Adding the duplicate node to the right child of the node.
        eg: consider we are adding 12 and already 12 is there in BST. then we will add it to the right child of existing
            12 node.
                12
              /     \
            10      20
           /  \     /
          9   11   12
             /      \
            10       12

        2) We can add one more property 'count' to the 'Node' class so that we can just increase the 'count' whenever
           there is a duplicate node inserted.


     Which approach is better among the 2 appraoches mentioned above?
        2nd approach of 'count' is best because. In 1st approach while deleting a node with duplicate nodes, then we
        need to delete all the dupicates nodes available whereas with the 2nd appraoch, we need to just delete only
        one node irrespective whatever is the count value.
 */
public class J3_1_Insert_Duplicate {

    public static void main(String[] args) {
        BSTInsertDuplicate obj = new BSTInsertDuplicate();

        obj.root = new NodeWithCount(10);
        obj.root.left = new NodeWithCount(5);
        obj.root.right = new NodeWithCount(15);

        obj.insertNode(obj.root,15);
        obj.insertNode(obj.root,16);
        System.out.println("Done");
    }

}

class NodeWithCount {
    Integer data;
    NodeWithCount left;
    NodeWithCount right;
    int count;              // count

    public NodeWithCount(Integer data) {
        this.data = data;
    }
}

class BSTInsertDuplicate {
    NodeWithCount root;

    public void insertNode(NodeWithCount node, Integer newNodeKey) {
        if(node == null) {
            return;
        }

        if(node.data == newNodeKey) {       // if newNode is duplicate then increase only count and return.
            node.count++;
            return;
        }

        if(newNodeKey < node.data) {
            if(node.left == null) {
                node.left = new NodeWithCount(newNodeKey);
                node.count = 1;
                return;
            }
            insertNode(node.left, newNodeKey);
        } else {
            if(node.right == null) {
                node.right = new NodeWithCount(newNodeKey);
                node.count = 1;
                return;
            }
            insertNode(node.right, newNodeKey);
        }
    }

}
