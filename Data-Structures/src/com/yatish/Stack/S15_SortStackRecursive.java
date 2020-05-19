package com.yatish.Stack;

import java.util.Stack;

public class S15_SortStackRecursive {

    private void sortedInsert(Stack<Integer> stack, int insertElement) {

        // if stack empty or insert element is greater than top element then insert.
        if(stack.isEmpty() || insertElement > stack.peek()) {
            stack.push(insertElement);
            return; // make sure we return this as we have inserted the element.
        }

        // if insertElement is less than top element, then pop the element and then recursively call it
        // until we find a peek element which is less than insert element. then call stack comes back
        // and inserts all the popped elements in the same order
        int temp = stack.pop();
        sortedInsert(stack, insertElement);
        stack.push(temp);
    }

    private void sortStack(Stack<Integer> stack) {

        // we will remove one element and then call it recursively until we reach last element and then we call
        // 'sortedInsert()' method for each element popped so that they will be inserted in sorted order.
        if(!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack, x);
        }
    }


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        S15_SortStackRecursive obj = new S15_SortStackRecursive();
        obj.sortStack(stack);
        System.out.println("Done");
    }




}
