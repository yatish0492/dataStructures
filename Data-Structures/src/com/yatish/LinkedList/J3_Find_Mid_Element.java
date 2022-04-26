package com.yatish.LinkedList;

/*
    Problem description
    -------------------
    We need to find the mid element of the linked list

    eg:
        Input : 1 --> 2 --> 3 --> 4 --> 5
        Output : 3

        Input : 1 --> 2 --> 3 --> 4 --> 5 --> 6
        Output : 3 or 4

    Logic
    -----
    We will have 2 pointers starting from head of the list. one will jump once node and another will jump 2 nodes.
    when pointer that jumps 2 nodes reaches the end of the list. Then the other pointer which jumps 1 node should be
    at the mid node.
 */
public class J3_Find_Mid_Element {

    public static void main(String[] args) {

        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.head = new Node(2);
        list1.head.nextNode = new Node(4);
        list1.head.nextNode.nextNode = new Node(3);
        list1.head.nextNode.nextNode.nextNode = new Node(1);
        list1.head.nextNode.nextNode.nextNode.nextNode = new Node(5);

        Node singleNodeJumper = list1.head;
        Node doubleNodeJumper = list1.head;

        while(doubleNodeJumper != null && doubleNodeJumper.nextNode != null) {
            singleNodeJumper = singleNodeJumper.nextNode;
            doubleNodeJumper = doubleNodeJumper.nextNode.nextNode;

            if(doubleNodeJumper == null || doubleNodeJumper.nextNode == null) {
                System.out.println("Mid Node - " + singleNodeJumper.data);
            }
        }
    }
}
