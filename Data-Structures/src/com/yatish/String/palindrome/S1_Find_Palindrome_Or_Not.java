package com.yatish.String.palindrome;

public class S1_Find_Palindrome_Or_Not {

	public static void main(String[] args) {
		
		String str = "aaab";
		
		int i = 0;
		int j = str.length() - 1;
		while(i < j) {
			if(str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
				continue;
			} else {
				System.out.println("Not a palindrom");
				return;
			}
		}
		System.out.println("It is a palindrom");

	}

}
