package com.yatish.String.Anagram;

import java.util.Arrays;

public class S2_CheckAnagram {

	/*
	 * Method 1 (Use Sorting)
		1) Sort both strings
		2) Compare the sorted strings
	 */
	public static void main(String[] args) {
		
		String str1 = "abcdef";
		String str2 = "dbafec";
		
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		System.out.println(new String(charArray1).equals(new String(charArray2)));

	}

}
