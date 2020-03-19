package com.yatish.Stack;


// Just take an array of integers and make front of array as top of one stack and end of array as top of other stack.
// basically make '-1' as top of one stack and 'n' as top of another stack. 'n' is lenght of the array.
// when added an element to stack1, then increment top of stack1.. when added element to stack2 decrement top of stack2.
// Make sure that top of each other doesn't cross each other.
public class S5_Implement2StacksInArray {

    public static void main(String[] args) {
        TwoStacksInArray stacks = new TwoStacksInArray(5);
        stacks.stack1Push(1);
        stacks.stack2Push(2);
        stacks.stack2Push(3);
        stacks.stack2Push(4);
        stacks.stack2Push(5);
        stacks.stack2Push(6);
    }


}

class TwoStacksInArray {

    int[] arr;
    private int stack1Top;
    private int stack2Top;

    TwoStacksInArray(int arraySize) {
        this.arr = new int[arraySize];
        stack1Top = -1;
        stack2Top = arraySize;
    }

    public Integer stack1Push(int newElement) {
        if(stack1Top+1 < stack2Top) {
            arr[++stack1Top] = newElement;
        } else {
            System.out.println("Stack Overflow Exception");
        }
        return newElement;
    }

    public Integer stack2Push(int newElement) {
        if(stack2Top-1 > stack1Top) {
            arr[--stack2Top] = newElement;
        } else {
            System.out.println("Stack Overflow Exception");
        }
        return newElement;
    }

    public Integer stack1Pop() {
        int topElement = -999;
        if(stack1Top == -1) {
            System.out.println("Stack Overflow Exception");
        } else {
            topElement = arr[stack1Top];
            stack1Top--;
        }
        return topElement;
    }

    public Integer stack2Pop() {
        int topElement = -999;
        if(stack2Top == arr.length) {
            System.out.println("Stack Overflow Exception");
        } else {
            topElement = arr[stack2Top];
            stack2Top++;
        }
        return topElement;
    }
}
