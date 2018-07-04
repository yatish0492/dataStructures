package com.yatish.String;

public class S1_StringClassMethods {

	public static void main(String[] args) {
		
		String str = "Yatish";
		
		int length = str.length();
		String substr = str.substring(0, 5); // 1st parameter is inclusive and 2nd parameter is exclusive
		char[] arr = str.toCharArray();
		str.indexOf("a");
		str.indexOf("tis");
		char ch = str.charAt(1);
		String[] strarray = str.split("a");
		str.trim();
		System.out.println(str.matches(".*at.*")); //have to mention (.*) for 0 or more any character. If it is just * then it wont work.
		str.equalsIgnoreCase("Yatish");
		str.equals("yatish");
	}

}
