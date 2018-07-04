package com.yatish.String;

public class S8_Reverse_Array_Without_Affecting_Specal_Charecters {

	/*
	 * 	input:   str = "a,b$c"
		Output:  str = "c,b$a"
		Note that $ and , are not moved anywhere.  
		Only subsequence "abc" is reversed
		
		Input:   str = "Ab,c,de!$"
		Output:  str = "ed,c,bA!$"
	 * 
	 */
	public static void main(String[] args) {
		
		String str = "ab!ba";
		
		S8_Reverse_Array_Without_Affecting_Specal_Charecters obj = new S8_Reverse_Array_Without_Affecting_Specal_Charecters();
		obj.reverse(str);
	}
	
	//Finds whether if the character is alphabet or not
	public boolean isAlphabet(char ch) {
		if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			return true;
		}
		return false;
	}
	
	public void reverse(String str) {
		char[] charArray = str.toCharArray();
		int i = 0;
		int j = charArray.length - 1;
		// instead of using for loop and complex calculations just use 'while(i<j)'. we will swap the characters within the same string only.
		while(i < j) {
			if(!isAlphabet(charArray[i])) {
				i++;
			} else if(!isAlphabet(charArray[j])) {
				j--;
			} else {
				char temp = charArray[i];
				charArray[i] = charArray[j];
				charArray[j] = temp;
				i++;
				j--;
			}
		}
		
		for(int k = 0; k < charArray.length; k++) {
			System.out.print(charArray[k]);
		}
		
	}

}
