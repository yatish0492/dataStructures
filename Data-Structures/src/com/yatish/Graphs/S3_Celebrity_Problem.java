package com.yatish.Graphs;

/*
    celebrity means he doesn't know any one but all other people know him. Basically in matrix, it should have '0' for
    all the elements of the row and '1' for all the elements of the column. In this program matrix index '2' is
    celebrity.

    NOTE: We can solve this using 'stacks' as well. check it out in 'S12_Celebrity_Problem.java'
 */
public class S3_Celebrity_Problem {

    Integer[][] matrix = {  {0, 0, 1, 0},
                            {0, 0, 1, 0},
                            {0, 0, 0, 0},
                            {0, 0, 1, 0}};

    boolean knows(int a, int b)
    {
        if(matrix[a][b] == 1) {
            return true;
        }
        return false;
    }


    int findCelebrity(int n)
    {
        // Start from first row last element.
        int a = 0;
        int b = n - 1;

        // come towards left until you find '1'. once you get '1' then move down until you find '0'.once you get '0' then
        //  same repeats move left until you find '1'. same story continues 'a' and 'b' meets(a=b).
        while (a < b)
        {
            if (knows(a, b))
                a++;
            else
                b--;
        }

        return verifyIfCelebrityOrNot(a, n);
    }

    // Check if a is actually a celebrity or not. by checking if complete row is of '0' and other column elements
    // are '1'
    public Integer verifyIfCelebrityOrNot(Integer celebrityIndex, Integer n) {
        for (int i = 0; i < n; i++)
        {
            if (i != celebrityIndex && (knows(celebrityIndex, i) ||
                    !knows(i, celebrityIndex)))
                return -1;
        }
        return celebrityIndex;
    }


    public static void main(String[] args) {
        S3_Celebrity_Problem obj = new S3_Celebrity_Problem();
        System.out.println(obj.findCelebrity(4));
    }
}
