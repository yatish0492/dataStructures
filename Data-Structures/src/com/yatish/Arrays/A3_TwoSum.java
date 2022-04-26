package com.yatish.Arrays;

import java.util.HashMap;
import java.util.Map;

// Leet Code Problem number 1

/*
    Problem description
    --------------------
    we have array of numbers. we try to find 2 elements in the array which will give is the sum.
    eg:
        input --> 2, 5, 6, 8, 11, 20
        input sum --> 16

        Output --> 1,4

    Logic
    -----
    1) We iterate each array element
    2) if the number required to add to current element to get the sum is already there in map then we print them
    3) if the not present in map then we add current element with its index as value.

 */
public class A3_TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 11, 20};
        int sum = 16;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if(map.containsKey(diff)) {
                System.out.println("The 2 elements indexes that sum up is - " +  map.get(diff) + "," + i);
            }
            map.put(arr[i], i);
        }
    }
}
