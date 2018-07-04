package com.yatish.String;

/*
 * Complexity
 * ----------
 * 	Time Complexity: O(n), where n is the length of our string
	Auxiliary Space – O(1).
 */
public class S6_PangramCheck {

	//Panagram check means, we need to check whether the string contains all character from a-z in it or not irrespective of case.
	public static void main(String[] args) {
		
		String str="abcdefghijklmnopqrstuvwxyz";
		
		S6_PangramCheck obj = new S6_PangramCheck();
		System.out.println(obj.isPangram(str));

	}
	
	public boolean isPangram(String str) {
		
		int[] AtoZCharacterCount = new int[26];
		char[] charArray = str.toCharArray();
		for(int i=0; i < charArray.length; i++) {
			int index = 0;
			//finding if character is uppercase. and finding index like 0 for A and 1 for B using substraction from 'A'
			if(charArray[i] <= 'Z' && charArray[i] >= 'A') {
				index = charArray[i] - 'A';
			//Finding if character is lowercase.
			} else if (charArray[i] <= 'z' && charArray[i] >= 'a') {
				index = charArray[i] - 'a';
			}
			AtoZCharacterCount[index] = ++AtoZCharacterCount[index];
		}
		
		
		for(int j = 0; j < 26; j++) {
			if(AtoZCharacterCount[j] == 0) {
				return false;
			}
		}
		return true;
	}

}
