package com.yatish.Stack;

// we can achieve this by using custom doubly linked list implementation from scratch.Basically writing linked list form scratch.
// NOTE: we are achieving O(1) complexity with time and space.
// whenever there is a question like O(1) requirement with stacks.... we can achieve by writing linked list from scratch and
// using that for storing the stack.
public class S7_StackWithMiddleElemOperation {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.middle.data);
    }


}

// Linked list Node
class Node {
    Integer data;
    Node prev;
    Node next;
}

// Customised Stack
class CustomStack {
    Node head = null;
    Node middle = null;
    Integer size = 0;


    public Integer push(Integer newElement) {
        // Adding the element at head
        Node newNode = new Node();
        newNode.data = newElement;
        newNode.next = head;
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;
        // setting middle element as we add new element. just keep middle element as the first element when for the
        // first time it is inserted. then keep moving it to previous node if length of list is odd number.
        if(size == 1) {
            middle = head;
        } else if(size%2 != 0) {
            middle = middle.prev;
        }
        return newElement;
    }


    public Integer pop() {
        if(size == 0) {
            System.out.println("Stack overflow exception");
            return -99999;
        }
        Integer removingElem = head.data;
        // Removing the element at head
        head = head.next;
        // Calculating middle element will be same logic as that in push(). but instead of 'prev' we need to go 'next'
        if(size == 1) {
            middle = head;
        } else if(size%2 != 0) {
            middle = middle.next;
        }
        return removingElem;
    }

}


