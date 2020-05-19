package com.yatish.Stack;

import java.util.Stack;

public class S16_sortStackNonRecursive {

    private Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> resultStack = new Stack<>();
        // Take each element from stack and check if 'resultStack' is empty or if its top element is lesser than
        // the inserting element. if so then add it to 'resultStack'. else pop the elements from 'resultStack' and
        // add it to original 'stack' until we find an element which is less than insertion element and then add it.
        while(!stack.isEmpty()) {
            int eachElement = stack.pop();

            if(resultStack.isEmpty() || eachElement > resultStack.peek()) {
                resultStack.push(eachElement);
            } else {
                while(!resultStack.isEmpty() && eachElement < resultStack.peek()) {
                    stack.push(resultStack.pop());
                }
                resultStack.push(eachElement);
            }
        }

        return resultStack;
    }


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        S16_sortStackNonRecursive obj = new S16_sortStackNonRecursive();
        Stack<Integer> sortedStack = obj.sortStack(stack);
        System.out.println("Done");
    }

}
