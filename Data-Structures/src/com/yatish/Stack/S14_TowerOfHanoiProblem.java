package com.yatish.Stack;

import java.util.Stack;

/*
    Tower of Hannoi Probalem
    ------------------------
    There will be 3 poles. in 1st pole there will be disks labeled 1,2,3,4..n. we need to move the disks to the 3rd
    pole such that the order of disks still remains same 1,2,3,4..n.

    NOTE: number labelled on disk specifies its magnitude. disk '3' is bigger than disk '2'. disks will be arranged in
            mountain shape(increasing size towards bottom) in the poles. while moving disk also we need maintain this
            mountain shape onlyincreasing size towards bottom).


    Solution
    --------
        We need a temporary pole to solve this. The number of moves required to achieve this is found by,
            formula -->  2^(num_of_disks) - 1
        Go through the code to understand solution.
 */
public class S14_TowerOfHanoiProblem {

    // if any of the pole/stack is empty then move the disk to that pole/stack irrespective of 'from' and 'to'
    // poles/stack. if either of them are not empty, then see which top disk is smaller and move that disk
    // to other pole/stack.
    public void moveDiskBetweenTwoPoles(Stack<Integer> from, Stack<Integer> to) {
        if(from.isEmpty()) {
            from.push(to.pop());
        } else if(to.isEmpty()) {
            to.push(from.pop());
        } else if(to.peek() < from.peek()) {
            from.push(to.pop());
        } else {
            to.push(from.pop());
        }
    }

    public void moveDiskdsToDestinationPole(Stack source, Stack temp, Stack dest) {
        // Number of moves requires to move disks from source to destination such that same order
        // is retained.
        int num_of_disks = source.size();
        int total_num_of_moves_required = (int) (Math.pow(2, num_of_disks) - 1);

        // ************ 'i' should start with 'i=1' not 'i=0' ************
        for(int i = 1; i <= total_num_of_moves_required; i++) {
            if(i % 3 == 1) {
                moveDiskBetweenTwoPoles(source, dest); // if 'i%3 = 1' then move disk from source to dest
            } else if(i % 3 == 2) {    // NOTE : see disk moving logic in 'moveDiskBetweenTwoPoles()' there is a twist.
                moveDiskBetweenTwoPoles(source, temp); // if 'i%3 = 2' then move disk from source to temp
            } else if(i % 3 == 0) {
                moveDiskBetweenTwoPoles(temp, dest);   // if 'i%3 = 0' then move disk from temp to dest
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> destinationStack = new Stack<>();

        sourceStack.push(3);
        sourceStack.push(2);
        sourceStack.push(1);

        S14_TowerOfHanoiProblem obj = new S14_TowerOfHanoiProblem();
        obj.moveDiskdsToDestinationPole(sourceStack, tempStack, destinationStack);
        System.out.println("Done");


    }
}
