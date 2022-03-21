package com.yatish.Arrays;

// Leet Code Problem number 189

/*
    Input --> 1 2 3 4 5 6 7 8 9
    rotateCount --> 3
    Output --> 6 7 8 9 1 2 3 4 5

    Input --> 1 2 3 4 5 6 7 8 9
    rotateCount --> 7
    Output --> 2 3 4 5 6 7 8 9 1

    Logic
    ------
    1) Reverse complete the array
    2) reverse array from start to 'rotateCount'
    3) reverse array from 'rotateCount + 1' to end

    eg:
        1 2 3 4 5 6 7 8 9
      1)  9 8 7 6 5 4 3 2 1
      2)  6 7 8 9 5 4 3 2 1
      3)  6 7 8 9 1 2 3 4 5

 */
public class A2_RotateArray {

    public static void main(String[] args) {
        char[] input = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int rotateCount = 7;

        input = reverseArray(input, 0, input.length-1);
        input = reverseArray(input, 0, rotateCount);
        input =reverseArray(input, rotateCount+1, input.length-1);

        System.out.println(input);

    }

    public static char[] reverseArray(char[] arr, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            char temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;

            startIndex++;
            endIndex--;
        }

        return arr;
    }

}
