package com.yatish.Graphs;

import java.util.ArrayList;
import java.util.List;

/*

 **** BackTracking approach and its kind of brute-force and gets all permutations and check.  ****
 ******* Complexity of this program is  O(n!) ******************

                                          "0"
                                        /  |  \
                                       /   |   \
                                      /    |    \
                                     /     |20   \
                                 10 /      |      \ 15
                                   /       |       \
                                  /        |        \
                                 /        "3"        \
                                /   25   /   \   30   \
                               /  -------     -------- \
                              "1" -------------------- "2"
                                          35

       Let's take initial least distance for TSP as "Integer.MAX_VALUE" = 2147483647
       Consider we start from "0",
                then we goto "1" -> cost = 10
                then we goto "2" -> cost = 10+35 = 45
                then we goto "3" -> cost = 45+30 = 75
                then we goto "0" -> cost = 75+20 = 95
       Now since '95' is lesser than '2147483647'. Current cost is '95'. then it will go back 2 steps and goto till
       "1" then it will try another root,
                then we goto "3" -> cost = 10+25 = 35
                then we goto "2" -> cost = 35+30 = 65
                then we goto "0" -> cost = 65+15 = 80
       Now since '80' is lesser than '95'. Current cost is '80'. then it will go back 3 steps and goto till
       "0" then it will try another root last time it went to "2" now we will try "2",
                then we goto "2" -> cost = 15
                then we goto "1" -> cost = 15+35 = 50
                then we goto "3" -> cost = 50+25 = 75
                then we goto "0" -> cost = 75+20 = 95
      Now since '95' is greater then '80' we will retian '80' only. Next it will go back 2 steps and try goint to "3"
      and theb "1" from "2". And in next to that step it will go again 3 steps back and try going "3" from "0" instead
      of "2".
      same wise it goes to all the possible routes. it goes from goes back in different route and basically try all sort
      of permutations with this.


 */
public class S2_Travelling_Sales_Problem_BackTracking {

    // Since optimal path keeps on changing with recursion. we are storing this final path in class property/member.
    public static List<Integer> finalPath = new ArrayList<>();


    static int tsp(int[][] graph, boolean[] v,
                   int currPos, int n,
                   int count, int cost, int ans, List<Integer> changinPathBasedOnBacktracking)
    {

        // Always the base function in case of backtracking problems are when have processed all elements. in this case
        // count = n means we have visited all 4 nodes.
        if (count == n && graph[currPos][0] > 0)
        {
            if((cost + graph[currPos][0]) < ans) {
                finalPath = List.copyOf(changinPathBasedOnBacktracking);
            }
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        // once we reach the last node we get call back from recursion to its calling function stack, there the 'count'
        // value will be less. say like count = 1 and i = 1 then we call the recursive with 'count+1' then when we get
        // back the call from recursion, 'count' value will be still 1 and 'i' value will also be '1' but in the next
        // iteration of 'for' loop 'i' will become '2' but 'count' still remains '1'. by doing this we keep tract of
        // how many does are visited using 'count' and we can change the nodes we goto using changing 'i' value.
        for (int i = 0; i < n; i++)
        {
            // this condition makes sure the node is not visited and there is a connection from 'currPos' to 'i' node
            // if there is no connection then we can't go so we are checking this condition.
            if (v[i] == false && graph[currPos][i] > 0)
            {

                // Mark as visited
                v[i] = true;
                changinPathBasedOnBacktracking.add(i);
                ans = tsp(graph, v, i, n, count + 1,
                        cost + graph[currPos][i], ans, changinPathBasedOnBacktracking);

                // Mark 'i' node as unvisited. we are marking last visited node as not visited because this is
                // back-tracking. we need to come back and try another route so. based on we we get back the
                // call back form each recursion this unvisited node goes back till the root element.
                v[i] = false;
                changinPathBasedOnBacktracking.remove(new Integer(i));
            }
        }
        return ans;
    }


    public static void main(String[] args)
    {

        // n is the number of nodes i.e. V
        int n = 4;

        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        // Boolean array to check if a node
        // has been visited or not
        boolean[] v = new boolean[n];

        // Path tracking
        List<Integer> changinPathBasedOnBacktracking = new ArrayList<>();

        // Mark 0th node as visited
        v[0] = true;
        changinPathBasedOnBacktracking.add(0);
        int ans = Integer.MAX_VALUE;

        // Find the minimum weight Hamiltonian Cycle
        ans = tsp(graph, v, 0, n, 1, 0, ans, changinPathBasedOnBacktracking);

        // ans is the minimum weight Hamiltonian Cycle
        System.out.println(ans);
        System.out.println("path ->" + finalPath);
    }
}
