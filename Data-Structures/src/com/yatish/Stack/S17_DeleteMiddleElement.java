package com.yatish.Stack;

import java.util.Stack;

public class S17_DeleteMiddleElement {

    // We will pop all the elements out recursively and then add them back to the stack. but while adding if the current
    // element is middle element then will not insert it.
    public void deleteMiddleElement(Stack<String> stack, int sizeOfStack, int currentCount) {

        if(stack.isEmpty()) {
            return;
        }

        String temp = stack.pop();
        deleteMiddleElement(stack, sizeOfStack, currentCount + 1);

        if(currentCount != (sizeOfStack/2)) {
            stack.push(temp);
        }
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        S17_DeleteMiddleElement obj = new S17_DeleteMiddleElement();
        obj.deleteMiddleElement(stack, stack.size(), 0);
        System.out.println("Done");
    }
}
