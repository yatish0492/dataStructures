package com.yatish.Arrays;

import java.util.Arrays;

// Leet Code Problem number 16

/*
    Problem description
    --------------------
    we need to find one unique combinations of 3 numbers which results into the sum which is closest to the provided sum.

    eg:
        input:  array--> -1, 2, 1, -4    targetSum=1
        Output: [-1, 2, 1] sum=2
            explanation of example,
                    we have other combinations like -1,2,4 which will result in 3
                                                    2,1,-4 which will result in -1
                                                    -1,2,-1 which will result in 2
                                                    etc.
                    Among all these combinations, '2' is the closest to 'targetSum' i.e. '1'


            Sort Array -->      -1      2       1       -4                            targetSum = 1
                                -4      -1      1       2

            Iteration 1 -->     -4      -1      1       2
                                i       low             high        -4 -1 +2 = -3      closestSum= 3 (Math.abs -3 to 3)
                                                                                       high-- (closestSum > targetSum)


            Iteration 2 -->     -4      -1      1       2
                                i       low    high                 -4 -1 1 = -4      closestSum= 3 (as 4 > 3)
                                                                                       high-- (closestSum > targetSum)
                                                                                       high > low (exit loop)


            Iteration 3 -->     -4      -1      1       2
                                         i     low     high         -1 1 2 = 2        closestSum= 2 (as 2 < 3)
                                                                                       high-- (closestSum > targetSum)
                                                                                       high > low (exit loop)

           Iteration 4 -->     -4      -1      1       2
                                               i    low, high         End of iteration

            Output --> 2


     logic
     -----
     1. We need to sort the array in ascending order. Otherwise this logic doesn't work ****** IMPORTANT ********
     2. we iterate 'i' over each number in array
     3. for each 'i'
            do binary search logic,
            closestSum = MaxValue like 999999
            low = i+1;
            high = last index;
                while(low < high)
                    if sum of elements at i, low, high is less than 'closestSum'
                            closestSum = currentSum
                    if sum of elements at i, low, high is less than 'targetSum'
                            low++
                    else
                            high--

     ** We can apply this to find the actual 3 sum problem in 'A5_Three_Sum.java' but we need to sort the array before.


 */
public class A6_3SumClosest {

    public static void main(String[] args) {
        int[] input = {-1, 2, 1, -4};
        int sum = 1;
        int closestSum = Integer.MAX_VALUE;
        int closestSum3Num[] = {};

        Arrays.sort(input);

        for(int i = 0; i < input.length; i++) {
            int low = i + 1;
            int high = input.length - 1;
            while(low < high) {
                int tempSum = Math.abs(input[i] + input[low] + input[high]);
                if(tempSum < closestSum && tempSum != sum) {
                    closestSum = tempSum;
                    closestSum3Num = new int[]{input[i], input[low], input[high]};
                }
                if(closestSum < sum) {
                    low++;
                }
                else {
                    high--;
                }
            }
        }

        System.out.println("Closest Sum = " + closestSum);
        System.out.println("ClosestSum numbers = " + closestSum3Num);
    }
}
