package com.yatish.String;

import java.util.Arrays;

/*
 * Complexity
 * ----------
 * If we use better algorithm for sorting like merge sort then it will give - Time Complexity: O(n log n) 
 * Time Complexity of removing duplicates logic : O(n)
 * 
 * Total = O(n log n)  + O(n)
 */
public class S4_RemoveDuplicateCharecters {

	public static void main(String[] args) {
		
		String str = "igeaakdkkllmmmmmkdkdslsdlpptpdpbpnpmppfpfrerf";
		char[] arr = str.toCharArray();
		
		//better to sort the characters first.
		Arrays.sort(arr);

		S4_RemoveDuplicateCharecters obj = new S4_RemoveDuplicateCharecters();
		System.out.println(obj.removeDuplicate(arr));
	}
	
	// we check the previous and current charecter, if both are different, if both are different we add that charecter to same array
	public String removeDuplicate(char[] charArray) {
		int j = 0;
		for(int i=1; i < charArray.length; i++) {
			if(charArray[i-1] == charArray[i]) {
				continue;
			} else {
				charArray[j] = charArray[i-1];
				j++;
			}
		}
		String str = new String(charArray);
		return str.substring(0,j);
	}

}
