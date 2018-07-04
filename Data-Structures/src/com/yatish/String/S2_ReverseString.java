package com.yatish.String;

public class S2_ReverseString {

	/*
	 * Complexity
	 * ----------
	 * Time Complexity: O(n)
	 */
	public static void main(String[] args) {
		
		String str="yatish";
		
		for(int i=str.length()-1; i >=0; i--) {
			System.out.print(str.charAt(i));
		}

	}

}
