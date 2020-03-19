package com.yatish.Stack;

// Don't think its finding only min and max of current stack. it needs to be updated dynamically when a new element is
// pushed and when an element is popped.

import java.util.Stack;

// Solution -  we will extends Stack class and include 2 more stacks 'min' and 'max' to it. along with its standard stack.
public class S4_GetMinMaxItemInStack {


    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();

        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(3);

        System.out.println(stack);
        System.out.println(stack.minStack);
        System.out.println(stack.maxStack);

        System.out.println("MinElement - " + stack.minStack.peek());
        System.out.println("MaxElement - " + stack.maxStack.peek());
    }


}

class MinMaxStack extends Stack<Integer> {

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    //Overriding push()
    @Override
    public Integer push(Integer newElement) {
        if(super.isEmpty()) {
            super.push(newElement);
            minStack.push(newElement);
            maxStack.push(newElement);
        } else {
            super.push(newElement);
            var minElement = minStack.peek();
            var maxElement = maxStack.peek();
            if(newElement <= minElement) {
                minStack.push(newElement);
            }
            if(newElement >= maxElement) {
                maxStack.push(newElement);
            }
        }
        return newElement;
    }

    //Overriding pop()
    @Override
    public Integer pop() {
        int popedElement = super.pop();
        int peekMinElement = minStack.peek();
        int peekMaxElement = maxStack.peek();

        if(popedElement == peekMinElement) {
            minStack.pop();
        }
        if(popedElement == peekMaxElement) {
            maxStack.pop();
        }
        return popedElement;
    }

}
