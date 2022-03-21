package com.yatish.LinkedList;

/*
    Problem Description
    --------------------
    We have 2 linked list, consider the linked list has numbers in reverse order,
    eg:
        Linked list =  HEAD --> 2 --> 4 --> 3
        Number = 342
    We have 2 linked lists and we need to return the result as a linked list only with same reverse order of numbers


    input
    -----
    HEAD --> 2 --> 4 --> 3
    HEAD --> 4 --> 6 --> 5

    Output (342 + 564 = 906)
    -------------------------
    HEAD --> 6 --> 0 --> 9


    input
    -----
    HEAD --> 8 --> 4 --> 2
    HEAD --> 1 --> 8

    Output (248 + 81 = 329)
    -------------------------
    HEAD --> 9 --> 2 --> 3


    Logic
    ------
    Same how we do addition on paper is school days. We add each number and carry forward number will be added next
    eg:
        step - 1
             carry -

                    3 4 2
                    5 6 4
                    ------
                        6

        step - 2
            carry - 1

                    3 4 2
                    5 6 4
                    ------
                      0 6

         step - 3
            carry - 1

                    3 4 2
                    5 6 4
                    ------
                    9 0 6

       As linked list already have numbers in reverse order we can start from head only.



 */
public class J2_AddTwoLinkedList {

    public static void main(String[] args) {

        // List 1
        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.head = new Node(2);
        list1.head.nextNode = new Node(4);
        list1.head.nextNode.nextNode = new Node(3);

        // List 2
        LinkedListImplementation list2 = new LinkedListImplementation();
        list2.head = new Node(4);
        list2.head.nextNode = new Node(6);
        list2.head.nextNode.nextNode = new Node(5);

        // Result Sum Linked list
        LinkedListImplementation list3 = new LinkedListImplementation();


        Node curList1 = list1.head;
        Node curList2 = list2.head;
        Node curList3 = list3.head;


        // Summation Logic
        int carry = 0;
        while(curList1 != null || curList2 != null) {
            int sum = 0;
            if(curList1 != null) {
                sum = sum + curList1.data;
            }
            if(curList2 != null) {
                sum = sum + curList2.data;
            }

            sum = sum + carry;
            if(curList3 == null) {
                list3.head = new Node(sum%10);
                curList3 = list3.head;
            } else {
                curList3.nextNode = new Node(sum%10);
                curList3 = curList3.nextNode;
            }

            // Carry number
            carry = sum/10;


            // Goto Next element
            if(curList1 != null) {
                curList1 = curList1.nextNode;
            }
            if(curList2 != null) {
                curList2 = curList2.nextNode;
            }
        }

        // Printing linked List
        for(var cur=list3.head; cur !=null; cur = cur.nextNode) {
            System.out.println(cur.data);
        }

    }


}
