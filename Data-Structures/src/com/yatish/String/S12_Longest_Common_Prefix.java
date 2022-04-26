package com.yatish.String;

// Leet Code Problem number 14

/*
    Problem Description
    --------------------
    We need to find the longest commom prefix string among array of strings.

    eg:
        Input --> flowers, flowing, flight
        Output --> fl

        Input --> dog, racecar, car
        Output --> ""


    Logic
    ------
    1) We find the smallest string among the array of strings
    2) we take first half of smallest string from middle i.e. substring
    3) We check if all the strings starts with this substring.
        if it starts with it, then we increase end index by 1 and again do step 3) until next substring doesn't meet this condition
        if not starts with it, then we decrease end index by 1 and again do step 3)
    4) substring we got after step 3 is the output

    (Explaining with Logic - 1)
    ---------------------------
    input -->  flowers, flowing, flight
    1) the smallest string(length=6) --> 'flight'
    2) middle = 3, substring(0,3) --> 'fli'
    3) not all string start with 'fli'
            reducing one character 'fl'
                all strings start with 'fl' so it is the output


    (Explaining with Logic - 2)
    ---------------------------
    input -->  flowers, flowering, floweringsky
    1) the smallest string(length=6) --> 'flowers'
    2) middle = 3, substring(0,3) --> 'flo'
    3) all the strings start with 'flo'
            increasing one character 'flow'
                all string start with 'flow'
                    increasing one character 'flowe'
                        all string starts with 'flowe'
                            increasing one character 'flower'
                                all strings starts with 'flower'
                                    increasing one character 'flowers'
                                        not all strings start with 'flowers' so exiting and output is 'flower'


     One more approach but less efficient than above one
     ----------------------------------------------------
     we start with first character and check if all string starts with it.
        if yes, then increase to one more character and check until it fails.

     This has complexity of O(n) whereas above solution complexity is o(n * log n). o(log n) is the complexity of binary search.

 */
public class S12_Longest_Common_Prefix {

    public static void main(String[] args) {
        String[] inputs = {"aatish", "yashaaa", "yashaswini"};

        System.out.println(findLongedPrefix(inputs));
    }

    public static String findLongedPrefix(String[] strs) {
        String output = "";

        String minLengthString = strs[0];

        for(String str: strs) {
            if(str.length() < minLengthString.length()) {
                minLengthString = str;
            }
        }

        int low = 0;
        int high = minLengthString.length();

        int middle = (low+high)/2;
        while(middle >= 0 && middle < minLengthString.length()) {
            String prefixStr = minLengthString.substring(0, middle);

            if(isCommonPrefix(strs, prefixStr)) {
                output = prefixStr;
                middle++;
            } else {
                if(output.isEmpty()) {
                    middle--;
                } else {
                    return output;
                }
            }

        }
        return output;
    }

    public static boolean isCommonPrefix(String[] strs, String prefixStr) {
        if(prefixStr.isEmpty()) {
            return false;
        }

        for(int i = 0; i < strs.length; i++) {
            if(!strs[i].startsWith(prefixStr)) {
                return false;
            }
        }
        return true;
    }

}


