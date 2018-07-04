package com.yatish.String.palindrome;

/*
 * A set of characters can form a palindrome if at most one character occurs odd number of times and all characters occur even number of times.
 */
public class S3_Check_If_Characters_Can_Be_Rearranged_To_Form_Palindrom {

	public static void main(String[] args) {
		
		String str = "aabaajjkkllmmm";
		int[] charCount = new int[256];
		int singleCharCount = 0;
		
		//If string has only 1 or 2 characters, then they are always palindroms.
		if(str.length() <= 2) {
			System.out.println("Palindrom possible");
			return;
		}
		
		//Counting the charecters and storing in 'charCount' Array. index is character, which will be internally converted to ASCII value of it which is int.
		for(int i = 0; i < str.length(); i++) {
			charCount[str.charAt(i)]++;
		}
		
		for(int j = 0; j < 256; j++) {
			if(charCount[j]%2 == 1) {
				singleCharCount++;
			}
		}

		if(singleCharCount > 1) {
			System.out.println("Palindrom not possible");
		} else {
			System.out.println("Palindrom possible");
		}
	}

}
