package com.yatish.Stack;

/*
    *******************************************************************************************************************
    NOTE : No need to remember conversion of expressions from infix to prefix to postfix vice versa etc. As these kind
            of problems are not asked in interview.
    *******************************************************************************************************************

    a+b  --> Infix
    ab+  --> Postfix
    +ab  --> Prefix

    Why do we need 'Prefix' and 'Postfix' when we have 'Infix' which we all use and can easily understand?
        We humans are habituated to infix to understand but computer finds 'Prefix' and 'Postfix' easy and efficient
        to solve. Computer requires multiple iterations while solving 'infix' expression, whereas it requires single
        iteration for solving 'Prefix' and 'Postfix'.

        eg: Consider, '1 + 2 * 10 / 5'. Computer needs to first go through it till '10/5' solve it to '2'and then
            go over it again and then solve '2*2' to '4' and then need to go over it again to solve '1+4' to 5.
            So it needs 3 iterations to solve 'Infix' expression. where as it can solve 'prefix' and 'postfix' in
            just one iteration.


 */
public class S9_0_InfixPrefixPostfixIntroduction {
}
