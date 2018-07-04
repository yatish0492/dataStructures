package com.yatish.String;

public class S7_ReplaceWhiteSpaces {

	public static void main(String[] args) {
		
		String str = "a b c d  m  mm n    e";
		
		char[] charArray = str.toCharArray();
		int j = 0;
		// if character is space then goto next character and if the character is not space, then add the character to the same array from beginning
		for(int i = 0; i < charArray.length; i++) {
			if(charArray[i] == ' ') {
				continue;
			} else {
				charArray[j] = charArray[i];
				j++;
			}
		}
		
		str = new String(charArray);
		// Don't forget to substring it. at last.
		str = str.substring(0,j);
		
		System.out.print(str);
		

	}

}
