package com.yatish.Algorithms;

public class S1_Knapsack {

	public static void main(String[] args) {
		
		/*
		 *  a[][] will have data as follows,
		 *  -------------------------------
		 *  | ProductID | profit | weight |
		 *  -------------------------------
		 *        1			200		20
		 *        2			100		10
		 *        3			150		8
		 *        4			50		6
		 *        
		 *        
		 *  Total capacity of bag/truck = 200
		 */
		//int a[][] = {{1,200,20},{2,100,10},{3,150,8},{4,50,6}};
		
		 int val[] = new int[]{200, 100, 150,50};
		    int wt[] = new int[]{20,10,8,6};
		    int  W = 20;
		    int n = val.length;
		System.out.println(Knapsack.knapSack(W, wt, val, n));
		
		
		
		

	}
	
	

}

class Knapsack
{
 
    // A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }
      
   // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
         int i, w;
     int K[][] = new int[n+1][W+1];
      
     // Build table K[][] in bottom up manner
     for (i = 0; i <= n; i++)
     {
         for (int j = 0; j <= W; j++)
         {
             if (i==0 || j==0)
                  K[i][j] = 0;
             else if (wt[i-1] <= j)
                   K[i][j] = max(val[i-1] + K[i-1][j-wt[i-1]],  K[i-1][j]);
             else
                   K[i][j] = K[i-1][j];
         }
      }
      
      return K[n][W];
    }
}
