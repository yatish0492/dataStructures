package com.yatish.Stack;

import java.util.Stack;

/*
    Next Greater element
    --------------------
    Input --> [13, 7, 6, 12]
    Output --> Element    Next Greater Element
                13      -->    -1     -> after '13' there is no greater element than '13' so we assign '-1'
                7       -->     12    -> after '7' next greater element is '12'
                6       -->     12    -> after '6' next greater element is '12'
                12      -->     -1    -> after '12' there is no greater element than '12' so we assign '-1'

    Solution
    ---------
    Appraoch 1   -->   We can have 2 for loops inside 1st one we will iterate over next elements and if we find
                        any greater than current then we will print that.
                        Complexity -> O(n*n)

    Approach 2   -->    Using stack. used in this program.
                        Complexity --> O(n)


 */
public class S11_NextGreaterElement {

    public void printNextGreaterElement(Integer[] input) {
        Stack<Integer> stack = new Stack();
        stack.push(input[0]);

        for(int i = 1; i < input.length; i++) {
            // The stack will have previous elements. so we will take each of them and check if the current element
            // is greater than them and print them.
            while(!stack.isEmpty() && input[i] > stack.peek()) {
                System.out.println(stack.peek() + "   -->   " + input[i]);
                stack.pop();
            }
            // we will add current element to stack as its next greater element will be found in next iteration.
            stack.push(input[i]);
        }

        //Whatever elements left in  stack didn't find a greater value so we just print '-1' for them.
        while(!stack.isEmpty()) {
            System.out.println(stack.pop() + "   -->   -1");
        }
    }

    public static void main(String[] args) {
        S11_NextGreaterElement obj = new S11_NextGreaterElement();
        Integer[] input = {13, 7, 6, 12};
        obj.printNextGreaterElement(input);
    }
}
