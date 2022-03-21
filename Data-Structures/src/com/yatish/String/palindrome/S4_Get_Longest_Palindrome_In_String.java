package com.yatish.String.palindrome;

// Leet Code Problem number 5
// ***** This is one option with O(n^3) where n is length of string. Refer to 'S4_1_Get_Longest_Palindrome_In_String'
//          which does it in O(n^2). which is optimal *************************************************************

/*
    Problem Description
    --------------------
    Find the longest palindrome substring.

    eg:
        input --> cadccdeaaaaaa
        output --> aaaaaa  -->  There are 2 palindromes, 'dccd' and 'aaaaaa'. But longest one is 'aaaaaa'


    Logic
    ------
    1) iteration 2 for loop.
    2) we goto 'i' 1st character and 'j' last character if it is same then we check for palindrome for this substring,
            if not then we check i and j-1 character same logic above. until j>i
            Once j==i then we increment i and do the same iteration by reducing j.
    3) Once we get a substring which is palindrome. we store it in a variable and if we find any other palindrome greater
        than the size of the one in variable then we store that.



 */
public class S4_Get_Longest_Palindrome_In_String {

    public static void main(String[] args) {
        String input = "cadccdeaaaaaa";
        String longestPalindrome = "";

        for(int i = 0; i < input.length(); i++) {
            for(int j = input.length()-1 ; i < j; j--) {
                if(input.charAt(i) == input.charAt(j)) {
                    String subString = input.substring(i, j+1);
                    boolean isPalindrome = isPalindrome(subString);
                    if(isPalindrome && subString.length() > longestPalindrome.length()) {
                        longestPalindrome = subString;
                    }
                }
            }
        }
        System.out.println(longestPalindrome);
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

}
