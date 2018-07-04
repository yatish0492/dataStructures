package com.yatish.String.CountingBased;

/*
 * Complexity
 * ----------
 * 	Time Complexity: O(n)
	Space Complexity: O(1) — Because we are using fixed space (Hash array) irrespective of input string size.
 */
public class S1_MaximumOccuringCharacter {

	/*
	 * 	Input string = “test”
		1: Construct character count array from the input string.
		  count['e'] = 1
		  count['s'] = 1
		  count['t'] = 2
		
		2: Return the index of maximum value in count array (returns ‘t’).
	 */
	public static void main(String[] args) {
		
		int[] count = new int[256];
		String str = "aabbbggggggg yyyyyyyyyyyyyyy";
		
		for(int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}
		
		int max = 0;
		char maxChar = str.charAt(0);
		for(int i = 0; i < str.length(); i++) {
			if(count[str.charAt(i)] > max) {
				max = count[str.charAt(i)];
				maxChar = str.charAt(i);
			}
		}
		
		System.out.println(maxChar);
		
	}

}
