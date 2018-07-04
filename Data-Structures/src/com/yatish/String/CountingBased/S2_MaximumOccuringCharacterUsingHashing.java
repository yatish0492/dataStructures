package com.yatish.String.CountingBased;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class S2_MaximumOccuringCharacterUsingHashing {

	/*
	 * Just instead of using int[] we use HashMap thats all :P
	 */
	public static void main(String[] args) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		String str = "aabbbggggggg yyyyyyyyyyyyyyy";
		
		for(int i = 0; i < str.length(); i++) {
			Integer count = map.get(str.charAt(i));
			if(count == null) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), ++count);
			}
		}
		
		
		int max = 0;
		Character maxChar = ' ';
		Set<Character> keys = map.keySet();
		for(Character each : keys) {
			if(max < map.get(each)) {
				max = map.get(each);
				maxChar = each;
			}
		}
		
		
		System.out.println(maxChar);

	}

}
