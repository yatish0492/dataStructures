package com.yatish.String.palindrome;

// Leet Code Problem number 5

/*
    Problem Description
    --------------------
    Find the longest palindrome substring.

    eg:
        input --> cadccdeaaaaaa
        output --> aaaaaa  -->  There are 2 palindromes, 'dccd' and 'aaaaaa'. But longest one is 'aaaaaa'


    Logic
    -----
    we go to each character from start. For each character, we try to find the palindrome by expanding left and right character
        both one by one.
    1) Iterate i from 0 to string length
    2) find even number of character palindrome and odd number of character palindrome around the character of each index 'i'
        (Odd number of character palindrome)
        for each 'i' we call following logic with both left and right 'i'
        (Even number of character palindrome)
        for each 'i' we call following logic with both left as 'i' and right as 'i+1'

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindrome = s.substring(left, right+1);
                left--;
                right++;
        }




 */
public class S4_1_Get_Longest_Palindrome_In_String {

    public static void main(String[] args) {
        String input = "cadccdeaaaaaa";

        String palindrome = "";

        for(int i = 0; i < input.length(); i++) {
            String oddPalindrome = getSurroundingPalindrome(input, i, i);
            if(oddPalindrome.length() > palindrome.length()) {
                palindrome = oddPalindrome;
            }
            String evenPalindrome = getSurroundingPalindrome(input, i, i+1);
            if(evenPalindrome.length() > palindrome.length()) {
                palindrome = evenPalindrome;
            }

        }
        System.out.println(palindrome);
    }

    public static String getSurroundingPalindrome(String s, int left, int right) {

        String palindrome = "";
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindrome = s.substring(left, right+1);
            left--;
            right++;
        }
        return palindrome;
    }

}
