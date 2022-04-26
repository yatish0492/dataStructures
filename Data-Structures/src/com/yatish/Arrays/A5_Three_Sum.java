package com.yatish.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Leet Code Problem number 15

/*
    Problem description
    --------------------
    we need to find all unique combinations of 3 numbers which results into the sum provided.

    eg:
        input:  array--> -1, 2, 3, 1, -1, -2, -1    sum=0
        Output: [-1, -1, 2], [-2, -1, 3]

    Logic
    -----
    1) we iterate 'i' over each number in array
    2) for each 'i'
            we go to each next number 'j' until last of array.
                we add 'j' number to a map/set.
                we sum up numbers at 'i' and 'j' and get diff number required to get the sum(diff = sum - (input[i] + input[j]))
                if 'diff' is already present in map/set. then we add that 3 numbers to result input[i], input[j], diff


    NOTE: It is similar to 'A3_TwoSum'. here we add 2 numbers of different combination and find the diff number to get the sum.

    ALTERNATE SOLUTION : Refer 'A6_3SumClosest.java'. But we need to sort the array before for using this. whereas in this class
                            we are not sorting the array.
                            same can be used with changing following logic in 'A6_3SumClosest.java'
                                if(tempSum < closestSum && tempSum != sum) {
                                    closestSum = tempSum;
                                    closestSum3Num = new int[]{input[i], input[low], input[high]};
                                }
                         To
                                if(tempSum == sum) {
                                    output.add(threeNumbersFormingSum)
                                }
 */
public class A5_Three_Sum {

    public static void main(String[] args) {
        int[] input = {-1, 2, 3, 1, -1, -2, -1};
        int sum = 2;

        Set<List<Integer>> output = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < input.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < input.length; j++) {
                int diff = sum - (input[i] + input[j]);
                if(map.containsKey(diff)) {
                    List<Integer> threeNumbersFormingSum = List.of(input[i], input[j], diff);
                    // We need to sort. because, there can be multiple combinations for same 3 numbers like,
                    // [-1, 2, -1], [-1, -1, 2], [2, -1, -1] so we should have only one set instead of 3 so we sort it
                    // when adding to set of list it will take care of removing duplicates.
                    threeNumbersFormingSum = threeNumbersFormingSum.stream().sorted().collect(Collectors.toList());
                    output.add(threeNumbersFormingSum);
                }
                map.put(input[j], j);
            }
        }

        System.out.println(new ArrayList(output));

    }
}
