package com.yatish.String;

import java.util.LinkedHashSet;
import java.util.Set;

public class S5_RemoveDuplicateUsingHashing {

	/*
	 * Complexity
	 * ----------
	 * Time Complexity: O(n)
	 */
	public static void main(String[] args) {
		
		String str="igeaakdkkllmmmmmkdkdslsdlpptpdpbpnpmppfpfrerf";
		char[] charArray = str.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		
		for(int i = 0; i < charArray.length; i++) {
			charSet.add(charArray[i]);
		}
		
		for(Character ch : charSet) {
			System.out.print(ch);
		}		

	}

}
