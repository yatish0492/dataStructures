package com.yatish.Algorithms;

import java.util.Arrays;

/*
    Problem Description
    -------------------
    We need to find/search for an element in an array

    eg:
        Input --> array=5,4,3,2,1  search=9
        Output --> Not found

        Input --> array=5,4,3,2,1  search=2
        Output --> Found


    Logic
    ------
    1) Sort the input elements array
    2) We will goto mid element and check if that matches search element.
            if not then,
                if search element is greater than mid element,
                    then get middle of right set of elements and repeat 1)
                else if serach element is lesser than mid element,
                    then get middle of left set of elements and repeat 1)

     (Explaining with example logic)
     Input - 5,4,3,2,1    search=1
     1) Sort array --> 1,2,3,4,5,6,7
     2) mid element = 4
            4 is not the searching number(1),
                4 is greater than search number(1)
                    we get mid of left numbers (1,2,3), middle element = 2
                        2 is not the search number(1)
                            2 is greater than search number(1)
                                we get mid of left numbers (1), middle element = 1
                                    1 is the search number, So we return true;


 */
public class S1_Binary_Search {

    public static void main(String[] args) {
        int[] input = {5,6,3,4,8,1,9,2,7};
        int searchElement = 8;

        // Sort the array first ************************************* it works on only sorted array.
        input = Arrays.stream(input).sorted().toArray();


        System.out.println(binarySearch(input, 0, input.length-1, searchElement));

    }

    public static int binarySearch(int[] input, int low, int high, int searchNumber) {
        if(low <= high) {
            int mid = (low + high) / 2;

            if(input[mid] == searchNumber) {
                return mid;
            }

            if(searchNumber > input[mid]) {
                return binarySearch(input, mid+1, high, searchNumber);
            }

            if(searchNumber < input[mid]) {
                return binarySearch(input, low, mid-1, searchNumber);
            }
        }
        return -1;
    }


}
