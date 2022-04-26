package com.yatish.Arrays;

// Leet Code Problem number 11

/*
    Problem Description
    --------------------
    Consider a bar chart. x and y axis with unit 0, 1,2,3,4...
    the input integer in array means at each index of x axis 0,1,2,3,4... a bar with its value will be there.
    eg:
        |
        |
        |
     8  |       |                   |
     7  |       |                   |       |
     6  |       |   |               |       |
     5  |       |   |       |       |       |
     4  |       |   |       |   |   |       |
     3  |       |   |       |   |   |   |   |
     2  |       |   |   |   |   |   |   |   |
     1  |___|___|___|___|___|___|___|___|___|______________________
            0   1   2   3   4   5   6   7   8   9   10

     you need to select 2 pillars among 8 which can form tank walls which will store more water
     In above, wall number at 1 and 8 index in x-axis will store maximum water.


     Logic
     -----
     1) We will start with 2 iterators from x-axis index '0'(i) and last '8'(j). until they doesn't cross each other.
     2) initialize 'maxArea' with 0
     3) find area with walls at index '0' and '8'.
            '0' index value is 1 and '8' index value is 7. we have to take minimum of it which is 1
            we take the distance each wall which is 8-0= 8
            1*8 = 8
     4) if area is greater than 'maxArea' then assign current area to 'maxArea'
     5) if 'i' wall is lesser than 'j' wall then,
            i++
        else
            j--
 */
public class A4_Container_With_Most_Water {

    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = 0;

        int i = 0;
        int j = input.length -1;

        while(i < j) {
            int minHeightBar = Math.min(input[i], input[j]);

            int area = minHeightBar * (j-i);
            if(area > maxArea) {
                maxArea = area;
            }

            if(input[i] < input[j]) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(maxArea);
    }
}
