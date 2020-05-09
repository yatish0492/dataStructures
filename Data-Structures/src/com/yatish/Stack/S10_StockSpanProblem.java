package com.yatish.Stack;

/*
    What is Stock span problem?
        In a array of elements, which have the height of the stocks. Let's keep it simple basically the output should be
        as follows,
        Input -  [100, 80, 60, 70, 60, 75, 85]
        Output - [1,   1,  1,   2,  1,  4,  6] -> This is nothing but number of consecutive previous elements whose
                                                  numbers are less than or equal to current value including current node.
          1st value '1' -> '100' doesn't have previous element so '1'
          2nd value '1' -> '80' doesn't have any consecutive previous element less than or equal to '80' so '1'
          3rd value '1' -> '60' doesn't have any consecutive previous element less than or equal to '60' so '1'
          4th value '2' -> '70' have 1 consecutive previous element less than or equal to '70' so '2'
          5th value '1' -> '60' doesn't have any consecutive previous element less than or equal to '60' so '1'. you may
                            ask like, we have one 60 before '70'. But before '60' we have a value which is higher than
                            '60' so we stop there don't check any further elements.
          6th value '4' --> '75' have 3 consecutive elements '60, 70, 60' which are less than or equal to '75' so '4'
          7th value '6' --> '85' have 5 consecutive elements '80, 60, 70, 60, 75' which are less than or equal to '85'
                            so '6'

     * In case of Stock span prob. Input array values are height of the stocks. so basically we are trying to solve is
        giving the number of stocks values/bars which are lesser then current stock price.

    NOTE: In interview they might ask like twisting saying that these stock as building height.


    How do we solve this?
        Approach 1 --> take a 'for' loop iterate over each element. inside this for loop have another for loop which will
                        go back from current element backwards until elements are lesser or equal to current element.
                        then outer loop goes to next element and inner loop gets those elements.
        Approach 2 --> Using stack. Add first elment index(i) to stack. we will take a 'for' loop iterate over each
                        element. Inside the for loop, keep popping element indexes until we have the elements less than
                        current element.
                        then if stack is empty that means all the elements before current element were less than current
                        element so they were popped out. hence 'i' will be the span.
                        if stack still has elements then we get the number of popped elements by 'i-stack.peek()'
    * Appraoch 2 is used in this program.


 */

import java.util.Stack;

public class S10_StockSpanProblem {

    public Integer[] getSpans(Integer[] stockPrices) {
        Stack<Integer> stack = new Stack<>();
        Integer[] resultSpanArray = new Integer[stockPrices.length];
        stack.push(0);    // we need to initialize 1st element first and iterate over from next element.
        resultSpanArray[0] =1;  // we need to initialize 1st element result as we know.
        for(int i = 1; i < stockPrices.length; i++) {
            // popping all the element index which are less than current element.
            while(!stack.isEmpty() && stockPrices[stack.peek()] <= stockPrices[i]) {
                stack.pop();
            }

            // If empty means all the elements before were less than current element and is being poped. if stil elements
            // are there in stack that top element(index) is the element(index) which is higher than current element.
            // so 'i - stack.peek()' will give number of elements which are lesser than current element.
            if(stack.isEmpty()) {
                resultSpanArray[i] = i;
            } else {
                resultSpanArray[i] = i - stack.peek();
            }
            stack.push(i); // push next element.
        }
        return resultSpanArray;

    }


    public static void main(String[] args) {
        Integer[] stocksPrices = {100, 80, 60, 70, 60, 75, 85}; // remember while initializing array its {} not []
        S10_StockSpanProblem obj = new S10_StockSpanProblem();
        Integer[] result = obj.getSpans(stocksPrices);
        System.out.println("Done");
    }
}
