package com.yatish.Stack;

import java.util.Stack;

// This is same as 'S4_GetMinMaxItemInStack.java' but with o(1) space and time complexity.
// While pushing element if newElement is lesser than minElement then push (2*newElement - minElement)
//              and make newElement as minElement
//              otherwise normally add the newElement to stack and minElement doesn't change.
// While poping elment if poppedElement is lesser than minElement then return minElement, not poppedElement
//              and make new minElement as (2*minElement - poppedElement)
//              otherwise normally return poppedElement and minElement doesn't change.
public class S4_1_GetMinItemInStack1Complexity {

    public static void main(String[] args) {
        StackMinOof1 stack = new StackMinOof1();

        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}

class StackMinOof1  extends Stack<Integer> {

    Integer minElement;

    @Override
    public Integer push(Integer newElement) {
        if(super.isEmpty()) {
            super.push(newElement);
            minElement = newElement;
        } else {
            if(newElement < minElement) {
                super.push(2*newElement - minElement);
                minElement = newElement;
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
        if(poppedElement < minElement) {
            Integer tempMinElement = minElement;
            minElement = 2*minElement - poppedElement;
            return tempMinElement;
        } else {
            return poppedElement;
        }
    }

    public Integer getMin() {
        return minElement;
    }

}
