package com.yatish.Arrays;

/*
    Input -->  0 1 1 0 1 0 1 1 0 0
    Output --> 0 0 0 0 0 1 1 1 1 1

    Logic
    -----
     1) Iteration --> 1 pointer start from beginning and 1 pointer starts from end
     2) if both pointers meet then stop the iteration
     3) if start iterator value is 1
            then check if end iterator is 0
                if not then move to before value until we find 0
                make start iterator value as 0 and end iterator value as 1 OR you can swap them.
      */

public class A1_Sort0And1 {

    public static void main(String[] args) {
        int[] input = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0};

        int lastIndex = input.length - 1;
        for(int i = 0; i < input.length; i++) {
            if( lastIndex > i) {
                if (input[i] == 1) {
                    while (input[lastIndex] == 1) {
                        lastIndex--;
                    }
                    input[i] = 0;
                    input[lastIndex] = 1;
                }
            }
        }

        for( int a : input) {
            System.out.println(a);
        }
    }
}
