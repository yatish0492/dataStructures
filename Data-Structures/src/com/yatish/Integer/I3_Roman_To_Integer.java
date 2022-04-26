package com.yatish.Integer;

import java.util.List;

// Leet Code Problem number 13

/*
    Problem Description
    --------------------
    Given Roman characters mapping - M=1000, D=500, C=100, L=50, X=10, V=5, I=1
    We need to convert the Roman value to Numerical.

    eg:
        Input --> III
        Output --> 3

        Input --> IV
        Output --> 4

        Input --> MCMXCIV
        Output --> 1994

    Logic
    ------
    We will iterate from the reverse. for "MCMXCIV" first is 'V' then 'I' then 'C' etc.
        We consider following order(Decreasing) M,D,C,L,X,V,I
    If current iterator character is lesser than previous iterator character as per above order then we
        deduct corresponding integer value from output value
    else
        we add corresponding integer value to output value
 */
public class I3_Roman_To_Integer {

    public static void main(String[] args) {
        // Mappings M=1000, D=500, C=100, L=50, X=10, V=5, I=1
        List<Character> romanChars = List.of('M', 'D', 'C', 'L', 'X', 'V', 'I');
        int[] integerValues = {1000, 500, 100, 50, 10, 5, 1};

        String input = "MCMXCIV";
        int output = 0;

        int indexOfRomanCorrespondingNumber = romanChars.indexOf(input.charAt(input.length()-1));
        output = output + integerValues[indexOfRomanCorrespondingNumber];


        for(int i = input.length()-2; i >= 0; i--) {
            char currentRoman = input.charAt(i);
            char previousRoman = input.charAt(i+1);
            int indexOfCurrentRomanInArray = romanChars.indexOf(currentRoman);
            int indexOfPreviousRomanInArray = romanChars.indexOf(previousRoman);
            int currentRomanCorrespondingInteger = integerValues[indexOfCurrentRomanInArray];
            if(indexOfCurrentRomanInArray > indexOfPreviousRomanInArray) {
                output = output - currentRomanCorrespondingInteger;
            } else {
                output = output + currentRomanCorrespondingInteger;
            }
        }

        System.out.println(output);
    }
}
