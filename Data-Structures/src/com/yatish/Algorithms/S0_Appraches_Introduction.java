package com.yatish.Algorithms;

/*
    There are many ways of solving a problem in programing.
    1) backtracking
    2) Dynamic Programming.

    Backtracking
    ------------
        Backtracking appraoch is like boot-force. For example, Maze problem. in this we goto a point first come back
        and try going to other route and come-back. Basically i tries all possible route. basically permutation of
        everything.

        Code implementation(Basic skeleton)
        -----------------------------------
            func(Integer count, .....) {

                if(count == allElementsSize) {
                    // base condition. we have traversed all elements in one path, do what you want.
                    // NOTE: this is just one path later with next call, it will try other paths.
                }

                for(i = (0 or some value), i < something, i++) {

                    func(count + 1, .....)      --> recursively calling the function.

                }
           }
       In above skeleton code, this will make sure that all paths or all permutations are processed.
 */
public class S0_Appraches_Introduction {
}
