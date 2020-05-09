package com.yatish.String;

// Refer to 'S0_Appraches_Introduction' if you need information about back-tracking. in this program 'count' is 'l' used
// in 'permute' function.
public class S9_Permutation_BackTracking {

    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str.toString());
        else
        {
            // Make sure to make 'i = l' if you need permutations. if you make 'i = 0' then you get combinations.
            for (int i = l; i < r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
            }
        }
    }

    private String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {

        String str = "ABC";
        S9_Permutation_BackTracking obj = new S9_Permutation_BackTracking();
        obj.permute(str, 0, str.length());

    }
}
