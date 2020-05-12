package com.yatish.Stack;

import java.util.Stack;

/*
    Converting Infix to PostFix
 */
public class S9_1_InfixToPostFix {

    // Return the precedence number.
    public int getOperatorPrecedence(char operator) {
        switch(operator) {
            case '+' :
            case '-' :
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String infixToPostFix(String infix) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If it is Operand
            if(Character.isLetterOrDigit(ch)) {
                result = result + ch;
            }
            // if it is '('. push it to the stack.
            else if(ch == '(') {
                stack.push(ch);
            }
            // if it is ')'. then pop the elements and add it to result until '(' is encountered.
            else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result = result + stack.pop();
                }
                stack.pop(); // remove '(' but don't add to result.
            }
            // if it is 'operator'. then add it to result until if its precedence value is less than precedence
            //      value of stack top element. if we encounter '(' then return 'INVALID EXPRESSION'. after this
            //      if no '(' is encountered then add the character to the stack.
            else {
                while(!stack.isEmpty() && getOperatorPrecedence(ch) <= getOperatorPrecedence(stack.peek())) {
                    if (stack.peek() == '(') {
                        return "INVALID EXPRESSION";
                    }
                    result = result + stack.pop();
                }
                stack.push(ch);
            }
        }

        // add all the operators in the stack to result. if '(' is still present that means there is no proper ')'
        // for each '(' so we give 'INVALID EXPRESSION'
        while(!stack.isEmpty()) {
            if(stack.peek() == '(') {
                return "INVALID EXPRESSION";
            }
            result = result + stack.pop();
        }

        return result;
    }



    public static void main(String[] args) {
        S9_1_InfixToPostFix obj = new S9_1_InfixToPostFix();

        System.out.println(obj.infixToPostFix("1+2*10/5"));
        //System.out.println(obj.infixToPostFix("a+b*(c^d-e)^(f+g*h)-i"));
    }
}

