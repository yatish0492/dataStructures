package com.yatish.Stack;

import java.util.LinkedList;
import java.util.Queue;

// We use 2 Queues to achieve this. When pushing the element. we will just push the elment to the back of queue.
// When poping we will take all elements from queue and put to another queue except last element and that will be popped.
public class S6_ImplementStackUsingQueue {

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.q1);
    }
}

class StackUsingQueue {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>(); // this acts like temp queue.

    public Integer push(Integer newElement) {
        q1.add(newElement);
        return newElement;
    }

    public Integer pop() {
        if(q1.size() == 0) {
            System.out.println("Stack Overflow Exception");
        }

        // take out all elements except last and add it to 'q2'
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
        Integer removedElem = q1.remove();

        //put the elements to 'q1' back now
        while(q2.size() > 0) {
            q1.add(q2.remove());
        }

        return removedElem;
    }

}
