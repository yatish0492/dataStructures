package com.yatish.String;

/*
 * Complexity
 * ----------
 * Time Complexity: O(n)
 */
public class S3_ReverseString_Recursive {

	public static void main(String[] args) {
		
		String str="yatish";
		S3_ReverseString_Recursive obj = new S3_ReverseString_Recursive();
		obj.reverseString(str);

	}
	
	public void reverseString(String str) {
		if(str.length() == 1) {
			System.out.print(str.charAt(str.length()-1));
			return;
		}
		System.out.print(str.charAt(str.length()-1));
		reverseString(str.substring(0, str.length() -1));
	}

}
