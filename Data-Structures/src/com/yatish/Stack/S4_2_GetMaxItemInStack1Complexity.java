package com.yatish.Stack;

import java.util.Stack;

// This is same as 'S4_GetMinMaxItemInStack.java' but with o(1) space and time complexity.
// While pushing element if newElement is greater than maxElement then push (2*newElement + maxElement)
//              and make newElement as maxElement
//              otherwise normally add the newElement to stack and maxElement doesn't change.
// While poping elment if poppedElement is greater than maxElement then return maxElement, not poppedElement
//              and make new maxElement as (poppedElement - 2*maxElement)
//              otherwise normally return poppedElement and maxElement doesn't change.
public class S4_2_GetMaxItemInStack1Complexity {

    public static void main(String[] args) {
        StackMaxOof1 stack = new StackMaxOof1();

        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(10);
        stack.push(20);

        System.out.println(stack.pop());
        System.out.println(stack.getMax());
    }
}

class StackMaxOof1  extends Stack<Integer> {

    Integer maxElement;

    @Override
    public Integer push(Integer newElement) {
        if(super.isEmpty()) {
            super.push(newElement);
            maxElement = newElement;
        } else {
            if(newElement > maxElement) {
                super.push(2*newElement + maxElement);
                maxElement = newElement;
            } else {
                super.push(newElement);
            }
        }
        return newElement;
    }

    @Override
    public Integer pop() {
        if(super.isEmpty()) {
            System.out.println("Stack Overflow Exception");
            return -999999;
        }
        Integer poppedElement = super.pop();
        if(poppedElement > maxElement) {
            Integer tempMaxElement = maxElement;
            maxElement = poppedElement - 2*maxElement;
            return tempMaxElement;
        } else {
            return poppedElement;
        }
    }

    public Integer getMax() {
        return maxElement;
    }

}

