package com.yatish.Integer;

// Leet Code Problem number 12

/*
    Problem Description
    --------------------
    Given Roman characters mapping - M=1000, D=500, C=100, L=50, X=10, V=5, I=1
    We need to convert the integer value to Roman.

    eg:
        Input --> 3
        Output --> III

        Input --> 4
        Output -> IV

        Input --> 9
        Output --> IX

        Input --> 58
        Output --> LVIII

        Input --> 1994
        Output --> MCMXCIV


     Logic
     ------
     We will iterate over integerArray and find the integer in integerArray which is lesser than inputNumber, then we add corresponding roman characters
        those many number of times, which the inputNumber can be divided by this number. Then we reduce inputNumber by that amount
        and do the same until inputNumber becomes 0.

     1) We will create following roman to integer map
            romanArray = "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
            integerArray = 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        We need to have values lesser than as well from given map like 'IV', 'IX', 'XL' etc.
     2) iterate over each integer in integerArray,
        if integer in integerArray is less than inputNumber then,
            multiplier = inputNumber/integer
            concatinate corresponding index roman character 'multiplier' number of times to output string
            reduce inputNumber by integer*multiplier because, we have added that much of roman characters.
        else if integer in integerArray is greater than inputNumber then,
            continue to next integer in integerArray
      3) Do step 2 until inputNumber becomes 0.

 */
public class I2_Integer_To_Roman {

    public static void main(String[] args) {
        // Mappings M=1000, D=500, C=100, L=50, X=10, V=5, I=1
        String[] romanChars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] integerValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int input = 1994;
        String output = "";

        while(input != 0) {
            for(int i = 0; i < integerValues.length; i++) {
                if(integerValues[i] <= input) {
                    int multiplier = input/integerValues[i];
                    for(int j = 0; j < multiplier; j++) {
                        output = output + romanChars[i];
                    }
                    input = input - integerValues[i]*multiplier;
                }
            }
        }

        System.out.println(output);
    }
}
