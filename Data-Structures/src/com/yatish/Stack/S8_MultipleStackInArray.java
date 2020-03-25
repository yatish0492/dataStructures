package com.yatish.Stack;

public class S8_MultipleStackInArray {

    public static void main(String[] args) {
        MultipleStackInArray stacks = new MultipleStackInArray(7,2);

        stacks.push(1,0);
        stacks.push(2,0);
        stacks.push(3,0);
        stacks.push(1,1);
        stacks.push(2,1);
        stacks.push(3,1);
        stacks.push(4,1);

        /*
            Consider, you want to store 2 stacks in an array of size 7.
                data -->   index -->    0   1   2   3   4   5   6
                           array -->    1   2   3   1   2   3   4

                tops -->    index -->   0   1
                            array -->   2   6

        nextItemIndex -->  index -->    0   1   2   3   4   5   6
                           array -->    -1  0   1   -1  3   4   5
        */
        System.out.println(stacks.data);
    }
}

// We will take 3 arrays,
// data --> which will contain actual stack data
// tops --> which will contain the top index of corresponding stack
// nextItemIndex --> the next element in the stack index.
class MultipleStackInArray {

    Integer[] data;
    Integer[] tops;
    Integer[] nextItemIndex;
    Integer numOfStacks;
    Integer sizeOfArray;
    Integer freeSpaceIndex;

    MultipleStackInArray(Integer sizeOfArray, Integer numOfStacks) {
        this.numOfStacks = numOfStacks;
        this.sizeOfArray = sizeOfArray;
        data = new Integer[sizeOfArray];
        tops = new Integer[numOfStacks];
        nextItemIndex = new Integer[sizeOfArray];

        //Initializing top index of each stack with -1
        for(int i = 0; i < numOfStacks; i++ ) {
            tops[i] = -1;
        }

        // Initializing next indexes
        for(int i = 0; i < sizeOfArray-1; i++) {
            nextItemIndex[i] = i+1;
        }
        nextItemIndex[sizeOfArray-1] = -1;

        // Initializing the freeSpaceIndexFor adding new elment of any stack
        freeSpaceIndex = 0;

        /*
            Consider, you want to store 2 stacks in an array of size 7. After initializing.
                    data -->   index -->    0   1   2   3   4   5   6
                               array -->    0   0   0   0   0   0   0

                    tops -->    index -->   0   1
                                array -->   -1  -1

             nextItemIndex -->  index -->   0   1   2   3   4   5   6
                                array -->   1   2   3   4   5   6   -1
        */
    }


    public Integer push(Integer newElement, Integer stackNumber) {
        if(freeSpaceIndex == -1) {
            System.out.println("StackOverflow exception");
            return -999999;
        }
        Integer tempFreeSpaceIndex = freeSpaceIndex;
        freeSpaceIndex = nextItemIndex[freeSpaceIndex];

        data[tempFreeSpaceIndex] = newElement;
        nextItemIndex[tempFreeSpaceIndex] = tops[stackNumber];
        tops[stackNumber] = tempFreeSpaceIndex;
        return newElement;
    }

    public Integer pop(Integer stackNumber) {
        if(tops[stackNumber] == -1) {
            System.out.println("StackOverflow exception");
            return -999999;
        }
        Integer topStackIndex = tops[stackNumber];
        Integer poppedElement = data[topStackIndex];
        tops[stackNumber] = nextItemIndex[topStackIndex];
        nextItemIndex[topStackIndex] = freeSpaceIndex;
        freeSpaceIndex = topStackIndex;

        return poppedElement;
    }

}
