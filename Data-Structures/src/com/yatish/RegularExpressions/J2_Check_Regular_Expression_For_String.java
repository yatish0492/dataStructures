package com.yatish.RegularExpressions;

// Leet Code Problem number 10

/*
    Problem Description
    --------------------
    Check whether the string matches the regular expression. (Consider only . and * in regex)

    eg:
        Input --> string="aa" regex="a"
        Output --> false

        Input --> string="aa" regex="a*"
        Output --> true

        Input --> string="ab" regex=".*"
        Output --> true

        Input --> string="mississippi" regex="mis*is*p*"
        Output --> false

     Logic
     ------
     (while loop) We will go over each character of regex until iterators reaches end of regex OR input string
         if 'alphabet'
            if 'alphabet' is not followed by '*'
                then we just check if they are same in string and regex. move to next characters in string and regex
            if 'alphabet' is followed by '*'
                then move to next character in regex only and back to the loop. "continue;"
        if '*'
            then we check if previous character is present in string, if present we move iterator till it ends.
        if '.'
            if followed by *
                if there is a next character after * in regex then
                    get all the characters after * until the character which has its next value as . or *
                    in input string, move the pointer till end of above all characters got from above step, last occurance
                    eg: Input --> string="abbcbbd" regex=".*bbb*"
                            In '.*bbb*', After '.*' we have 'bb' as the substring before a character which has its next character followed by '*'
                            Now we find 'bb' substring last occurrance in 'abbcbbd' and move the pointer to its end. basically move the
                                pointer to index '6'. NOTE: 'abbcbbd' has 2 occurance of substring 'bb'. String.lastIndexOf() function can be used
                                to get index '4' and then we can add substring length '2' to it and get '6'
                    if input string doesnt have 'bb' in it, i.e. String.lastIndexOf() returns -1 then we just return false. regex not match
            if not followd by *
                then we just go over to next character in both regex and input string.
       After the loop. iterator of input string should have reached end if not then we return false. else true.

       Illustration
       ------------

       Input String                     Regex
       ---------------------------------------------------
        i                               j
        abcaaadaabx                     a.*aaa*b.

                    Regex(j) is an alphabet --> check if they are equal and increase i and j by 1

         i                               j
        abcaaadaabx                     a.*aaa*b.

              Regex(j) is '.' followed by '*' --> we take 'aa' and find its last occurance in input string

                i                            j
        abcaaadaabx                     a.*aaa*b.

              Regex(j) is an alphabet 'a' but followed by * --> we just increment j by 1

                 i                            j
        abcaaadaabx                     a.*aaa*b.

              Regex(j) is an '*' --> We find previous alphabet('a') and check if it is present in string at 'i' if present
                                             then we move 'i' until we find different alphabet. in this case 'a' is not
                                             present at 'i' position in index.
                                             Move j by one position.

                 i                             j
        abcaaadaabx                     a.*aaa*b.

               Regex(j) is an alphabet --> check if they are equal and increase i and j by 1

                  i                             j
        abcaaadaabx                     a.*aaa*b.

               Regex(j) is '.' not followed by '*' --> hence just increase i and j by 1

                  i                             j
        abcaaadaabx                     a.*aaa*b.

                As 'j' has reached the end. we check if 'i' also has reached the end which is 'true' so regex successful
                    match. If 'i' had not reached the end then it was a failed regex match.


 */
public class J2_Check_Regular_Expression_For_String {

    public static void main(String[] args) {
        String input = "abcdaab";
        String regex = "a.*aaa*b";

        System.out.println(checkRegularExpressionMatch(input, regex));
    }

    public static boolean checkRegularExpressionMatch(String input, String regex) {

        int i = 0;
        int j = 0;

        while(j < regex.length() && i < input.length()) {

            switch(regex.charAt(j)) {
                case '.' : if(j+1 < regex.length() && regex.charAt(j+1) == '*') {
                                if(j+2 < regex.length()) {
                                    int tempindex = j+3;
                                    while(tempindex < regex.length() && regex.charAt(tempindex) != '.' && regex.charAt(tempindex) != '*') {
                                        tempindex++;
                                        j++;
                                    }
                                    String subString = regex.substring(j+2, tempindex);
                                    int index = input.lastIndexOf(subString);
                                    if(index == -1) {
                                        return false;
                                    } else {
                                        i = index + subString.length();
                                    }
                                    j = j + 2;
                                } else {
                                    return true;
                                }
                            } else {
                                i++;
                                j++;
                            }
                            break;

                case '*' :  char previousChar = regex.charAt(j-1);
                            while(i < input.length() && input.charAt(i) == previousChar) {
                                i++;
                            }
                            j++;
                            break;

                default:    if(j+1 < regex.length() && regex.charAt(j+1) == '*') {
                                j++;
                                break;
                            }
                            if(input.charAt(i) != regex.charAt(j)) {
                                return false;
                            }
                            i++;
                            j++;
            }
        }
        if(i != input.length()) {
            return false;
        }
        return true;
    }
}
