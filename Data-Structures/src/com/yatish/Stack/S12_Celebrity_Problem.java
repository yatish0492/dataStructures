package com.yatish.Stack;

import java.util.Stack;

/*
    celebrity means he doesn't know any one but all other people know him. Basically in matrix, it should have '0' for
    all the elements of the row and '1' for all the elements of the column. In this program matrix index '2' is
    celebrity.

    NOTE: We can solve this using not using 'stacks' as well. check it out in 'S3_Celebrity_Problem.java'
 */
public class S12_Celebrity_Problem {
    Integer[][] matrix = {  {0, 0, 1, 0},
                            {0, 0, 1, 0},
                            {0, 0, 0, 0},
                            {0, 0, 1, 0}};

    boolean knows(int a, int b)
    {
        if(matrix[a][b] == 1) {
            return true;
        }
        return false;
    }


    int findCelebrity(int n)
    {
        Stack<Integer> stack = new Stack<>();

        // Add sequential numbers till n to stack. i.e. 0,1,2,3
        for(int i = 0; i < n; i++) {
            stack.push(i);
        }

        // we will pop out 2 elements from the stack 'a' and 'b'. Then check if 'a' know 'b',
        // if 'a' knows 'b' then,
        //      'a' can't be celebrity as he knows 'b'
        //      So, we will add back 'b' to stack so in next iteration 'b' will be checked for celebrity.
        // if 'a' doesn't know 'b' then,
        //      'b' can't be celebrity as celebrity needs to be known by everyone
        //      So, we will add back 'a' to stack so in next iteration 'a' will be checked for celebrity.
        while(stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if(knows(a,b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        // The last element remaining in the stack can be the celebrity.
        Integer celebrityIndex = stack.pop();
        return verifyIfCelebrityOrNot(celebrityIndex,n);
    }

    // Check if a is actually a celebrity or not. by checking if complete row is of '0' and other column elements
    // are '1
    public Integer verifyIfCelebrityOrNot(Integer celebrityIndex, Integer n) {
        for (int i = 0; i < n; i++)
        {
            if (i != celebrityIndex && (knows(celebrityIndex, i) ||
                    !knows(i, celebrityIndex)))
                return -1;
        }
        return celebrityIndex;
    }


    public static void main(String[] args) {
        S12_Celebrity_Problem obj = new S12_Celebrity_Problem();
        System.out.println(obj.findCelebrity(4));
    }
}
