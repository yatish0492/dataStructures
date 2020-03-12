package com.yatish.Stack;

import java.util.Stack;

// We use 2 stacks to achieve this. stack bottom will be back of queue and top will be front of queue.
public class S3_ImplementQueueUsingStack {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    // 'enQueue' means add an element to queue
    static public void enQueue(Integer newElement) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(newElement);

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // 'deQueue' means removing an element in queue
    static public void deQueue() {
        if(s1.isEmpty()) {
            System.out.println("No elements in queue to remove");
        } else {
            s1.pop();
        }
    }



    public static void main(String[] args) {
        S3_ImplementQueueUsingStack.enQueue(1);
        S3_ImplementQueueUsingStack.enQueue(2);
        S3_ImplementQueueUsingStack.enQueue(3);
        S3_ImplementQueueUsingStack.enQueue(4);

        System.out.println(S3_ImplementQueueUsingStack.s1);

        System.out.println("Removed one element from queue");
        S3_ImplementQueueUsingStack.deQueue();
        System.out.println(S3_ImplementQueueUsingStack.s1);
        System.out.println("Removed one element from queue");
        S3_ImplementQueueUsingStack.deQueue();
        System.out.println(S3_ImplementQueueUsingStack.s1);
        System.out.println("Removed one element from queue");
        S3_ImplementQueueUsingStack.deQueue();
        System.out.println(S3_ImplementQueueUsingStack.s1);
    }
}
