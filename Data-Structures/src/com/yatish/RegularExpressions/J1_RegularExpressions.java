package com.yatish.RegularExpressions;

public class J1_RegularExpressions {

	public static void main(String[] args) {
		
		String str = "";
		str.matches("[abc]");  // the string should contain only 1 character and that character should be either only 'a' or 'b' or 'c'
		str.matches("[^abc]"); // the string should contain only 1 character and that character can be any character but not 'a' or 'b' or 'c'
		str.matches("[a-zA-Z]"); // The string should contain only 1 character and the character should be either in range of 'a-z' or 'A-Z'
		str.matches("[0-9]"); // The string should contain only 1 character and the character should be in the range of '0-9'
		str.matches("."); // The string should contain only 1 character and that character can be any character.
		str.matches("r?"); // The string should contain only 0 or 1 'r'
		str.matches("rr?"); // The string should contain only 0 or 1 'rr'
		str.matches(".?"); // The string should contain any character 0 or 1 time.
		str.matches("r+"); // The string should contain only 1 or more 'r'
		str.matches(".+"); // The string should contain any character 1 or more times.
		str.matches("r*"); // The string should contain only 0 or more 'r'
		str.matches(".*"); // The string should contain any character 0 or more
		str.matches("\\s"); // The string should contain only 1 character and that should be any kind of white space, it is short form of [\t\n\x0B\f\r]. NOTE: it is small 's' not big
		str.matches(".*ABC"); // The string should contain 'abc' at last and there can be 0 or more any characters before it like 'uihewrfabc' or '348uiifabc' or 'abc'
		
		/*
		 * Use of '(' ')'
		 * 
		 * If we want to apply an operation on a collection of items in regular expressions, then if you have to use it like consider following example,
		 * consider we want the sequence to be 'a5k7k3', we want to say that there should be 0 or more occurrence of alternating alphabet and number, if we specify the regular expression as 
		 * '[a-z][0-9]*', it is not correct it means 'd2323' or 'a' or 'd7' etc. In this case we have to use () like '([a-z][0-9])*' so that the '*' is applied on both [a-z] and [0-9].
		 */
		str.matches("[a-z][1-9]*");

	}

}
