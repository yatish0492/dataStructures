package com.yatish.Stack;

import java.util.Stack;

/*
    Evaluating String expression
    ----------------------------
    A expression cannot be solved directly as it involves '(' and ')' also. so we will need to find a way to solve it.

    Solution
    --------
        We will use stack. to solve this by using 2 stacks.
            1st stack --> for storing operators
            2nd stack --> for storing numbers

    eg: '2 + 4*4 + 6'
                                            Number stack
                                            ------------
             2           +           4            *          4           +            6         solve remaining
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            |   |       |   |       |   |       |   |       |   |       |   |       |   |       |   |       |   |
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            |   |       |   |       |   |       |   |       | 4 |       |   |       | 6 |       |   |       |   |
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            |   |       |   |       | 4 |       | 4 |       | 4 |       |16 |       |16 |       |22 |       |   |
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            | 2 |       |   |       | 2 |       | 2 |       | 2 |       | 2 |       | 2 |       | 2 |       |24 |
            -----       -----       -----       -----       -----       -----       -----       -----       -----

                                            Operator stack
                                            --------------
              2           +           4           *           4           +           6
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            |   |       |   |       |   |       |   |       |   |       |   |       |   |       |   |       |   |
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            |   |       |   |       |   |       |   |       |   |       |   |       |   |       |   |       |   |
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            |   |       |   |       |   |       | * |       | * |       | + |       | + |       |   |       |   |
            -----       -----       -----       -----       -----       -----       -----       -----       -----
            |   |       | + |       |   |       | + |       | + |       | + |       | + |       | + |       |   |
            -----       -----       -----       -----       -----       -----       -----       -----       -----
                    you might ask                                   pop                     pop  operator   pop operator
                    like why didn't we pop                          operator * and          + and pop 2     + and pop 2
                    operator and 2 numbers                          pop 2                   numbers         numbers
                    and solve it? as we can see there               numbers and             solve 6+16 and  solve 22+2
                    is no previous operator only so.                solve 4*4 and           push 22 to      and push 24
                    if operator stack is empty then                 push 16 to number       number stack.   to number
                    we don't solve top 2 numbers in                 stack and add new                       stack.
                    stack                                           operator + to                           Final remaining
                                                                    operator stack.                         number is
                                                                                                            result '16'

          NOTE: when we got '*' also we didn't pop operator + and 2 numbers and solve 2+4. because as per BODMAS
                precedence rule. we need to solve * and / first and then solve + and - so we didn't. in program we
                can check like if current operator is '*' or '/' and previous operator is '+' or '-' then we don't
                solve previous 2 numbers and we just add that operator to operators stack.
 */
public class S13_Evaluate_Expression {

    // make sure that first is 'b' and second is 'a' because in stack number order is reverse. so while sending
    // arguments also we will be sending accordingly.
    private int calculate(char operator, int b, int a) {
        switch (operator) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
            case '/':
                if(a == 0) {
                    throw new RuntimeException("Unsupported operation");
                }
                return a / b;
        }
        return 0;
    }


    private boolean isSolvingThisOperationAsPerBODMASRule(char currentOperator, char previousOperator) {
        if(previousOperator == '(' || previousOperator == ')') {
            return false; // returning false because we cannot apply '(' ')' to the numbers
        } else if ((previousOperator == '+' || previousOperator == '-') &&
                (currentOperator == '*' || currentOperator == '/')) {
            return false; // this violates BODMAS rules as mentioned in 'NOTE' of description in this program.
        }
        return true;
    }


    public int evaluate(String exp) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();

        char[] chars = exp.toCharArray();

        for(int i = 0; i < chars.length; i++) {

            // if it is a number
            if(Character.isDigit(chars[i])) {
                // converting ch to number and if its more than one digit then taking all numbers
                StringBuffer buffer = new StringBuffer();
                buffer.append(chars[i]);
                while((i+1) < chars.length && Character.isDigit(chars[i+1])) {
                    buffer.append(chars[i+1]);
                    i++;
                }

                // add number to stack.
                numberStack.push(Integer.parseInt(buffer.toString()));
            }

            // if it is '('
            else if(chars[i] == '(') {
                operatorsStack.push(chars[i]);
            }

            // if it is ')' solve all numbers until '('. you may ask like why are we not checking BODMAS rule here
            // and blindly calculating? since '(' would have occurred and we have went through each operator in it
            // and control goes to 'chars[i] == operator' 'else if' section and in that we have already checked
            // BODMAS rule and solved so we are not checking here again.
            else if(chars[i] == ')') {
                while(operatorsStack.peek() != '(') {
                    int result = calculate(operatorsStack.pop(), numberStack.pop(), numberStack.pop());
                    numberStack.push(result);
                }
                operatorsStack.pop(); // remove '('
            }

            // it it is 'operator'
            else if(chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                if(!operatorsStack.isEmpty()) {
                    boolean approved = isSolvingThisOperationAsPerBODMASRule(chars[i], operatorsStack.peek());
                    if(approved) {
                        int result = calculate(operatorsStack.pop(), numberStack.pop(), numberStack.pop());
                        numberStack.push(result);
                    }
                    operatorsStack.push(chars[i]);
                } else {
                    operatorsStack.push(chars[i]);
                }
            }

        }

        // Solving remaining in the stack.
        while(!operatorsStack.isEmpty()) {
            int result = calculate(operatorsStack.pop(), numberStack.pop(), numberStack.pop());
            numberStack.push(result);
        }

        //Final remaining number is result. Returning it.
        return numberStack.pop();
    }

    public static void main(String[] args) {
        S13_Evaluate_Expression obj = new S13_Evaluate_Expression();
        System.out.println(obj.evaluate("2+4*4+6"));
    }

}
