package com.yatish.LinkedList;

/*
     Problem description
    -------------------
    We need to find whether if there is a loop in the linked list.

    eg:
        Input : 1 --> 2 --> 3 --> 4 --> 5
        Output : No loop

        Input : 1 --> 2 --> 3 --> 4 --> 5
                      ^                 |
                      |_________________|
        Output : Loop is present


     Logic
     ------
     We will have 2 pointers starting from head of the list. one will jump once node and another will jump 2 nodes.
        If both the pointers meet and point to same node, that means there is a loop in linked list.
 */

public class J4_Finding_Loop_In_Linked_List {

    public static void main(String[] args) {

        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.head = new Node(2);
        list1.head.nextNode = new Node(4);
        list1.head.nextNode.nextNode = new Node(3);
        list1.head.nextNode.nextNode.nextNode = new Node(1);
        list1.head.nextNode.nextNode.nextNode.nextNode = list1.head.nextNode;

        Node singleNodeJumper = list1.head;
        Node doubleNodeJumper = list1.head;

        while(doubleNodeJumper != null && doubleNodeJumper.nextNode != null) {
            singleNodeJumper = singleNodeJumper.nextNode;
            doubleNodeJumper = doubleNodeJumper.nextNode.nextNode;

            if(singleNodeJumper == doubleNodeJumper) {
                System.out.println("There is a loop in linked list");
                break;
            }
        }
    }
}
