package com.yatish.String;

// Leet Code Problem number 3

/*
    Problem Description
    --------------------
    we need to find the longest substring which doesn't have any characters repeated in it.

    eg:
        input --> "pwwkew"
        output --> "wke"  --> Here 'pwke' is a instance which doesn't have repeating character, it is not a substring
                                hence 'wke' is the result


     Logic
     ------
     1) Start iterating 2 pointers 'i' from 1st character and 'j' from 2nd character
     2) we keep incrementing 2nd pointer by one and
        if j index character and its previous character is same then we save the substring from 'i' to 'j' if already
            saved substring is shorter than this
            then move 'i' to 'j' position and repeat the same
     3) And condition so that if 'j' reaches end then we just save the substring from 'i' to 'j' f already
            saved substring is shorter than this

 */
public class S11_Longetst_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        String input = "pwwkew";

        int i = 0;
        int j = 1;

        String longestSubstringWithoutRepeatingChar = "";
        int stringLength = 0;

        while(i < input.length() && j < input.length()) {
            if((input.charAt(j) ==  input.charAt(j-1) && j-i > stringLength) || j == input.length()-1) {
                longestSubstringWithoutRepeatingChar = input.substring(i, j);
                stringLength = longestSubstringWithoutRepeatingChar.length();
                i = j;
            }
            j++;
        }

        System.out.println(longestSubstringWithoutRepeatingChar);
    }
}
