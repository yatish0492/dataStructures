package com.yatish.Integer;

// Leet Code Problem number 7

/*
    Problem Description
    --------------------
    we need to reverse the integer. it can be negative or positive.

    eg:
        Input --> 123
        Output --> 321

        Input --> -123
        Output --> -321

        Input --> 120
        Output --> 21

     Logic
     -----
     Lets keep 'output' int value as 0. We take each number from right using %10 and then we start adding it to 'output'
      but one key thing, we need to multiply the existing 'output' by 10 before adding because when we add a new number
      previous 'output' numbers will move to the left making place for new number.

      Regarding handling negative number. If it is negative, then we multiply the number by -1 and do our logic then
            again we multiply the 'output' back with -1 at end.
 */
public class I1_Reverse_Integer {

    public static void main(String[] args) {
        int input = 0;
        int output = 0;
        boolean negative = false;

        if(input < 0) {
            negative = true;
            input = input * -1;
        }

        while(input > 0) {
            int number = input%10;
            output = output *10 + number;

            input = input/10;
        }

        if(negative) {
            output = output * -1;
        }

        System.out.println(output);
    }
}
