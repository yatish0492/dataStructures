package com.yatish.String.palindrome;

public class S2_CheckIfStringIsRotationOfPalindrom {

	/*
	 * 	Input:  str = "aaaad"
		Output: 1  
		// "aaaad" is a rotation of a palindrome "aadaa"
		
		Input:  str = "abcd"
		Output: 0
		// "abcd" is not a rotation of any palindrome.

		Solution
		--------
		1) A Simple Solution is to take the input string, try every possible rotation of it and return true if a rotation is a palindrome. If no rotation is palindrome, then return false.
			Complexity
			----------
			Time Complexity: O(n2)
			Auxiliary Space: O(n) for storing rotations.
		2) An Optimized Solution can work in O(n) time. The idea is similar to this post. Following are steps.
			a) Let the given string be ‘str’ and length of string be ‘n’. Create a temporary string ‘temp’ which is of size 2n and contains str followed by str again. For example, let str be “aab”,
				temp would be “aabaab”.
			b) Now the problem reduces to find a palindromic substring of length n in str. If there is palindromic substring of length n, then return true, else return false.
			Complexity
			----------
			Time Complexity: O(n2)
			Auxiliary Space : O(1)
	 */
	public static void main(String[] args) {
		
		String str = "aaaaba";
		int length = str.length();
		str = str + str;
		
		int i = 0;
		int j = i + length-1;
		while(j < str.length()-1) {
			j = i + length-1;
			
			int m = i;
			int n = j;
			//Palindrom logic
			while(m <= n) {
				if(str.charAt(m) == str.charAt(n)) {
					m++;
					n--;
					if(m == n) {
						System.out.println("It is a Palindrom");
						return;
					}
					continue;
				} else {
					if(j == str.length()-1) {
						System.out.println("Not a Palindrom");
						return;
					}
					break;
				}
			}
			i++;
		
		}
		
		System.out.println("It is a Palindrom");
		

	}

}
