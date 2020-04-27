package com.yatish.Trees.ExpressionTree;

/*
    Expression trees always have operands(Numbers) stored as leaf nodes. and the operators will be the middle nodes.

    	                  +
					-------------
					|		    |
					*		    -
				--------	  --------
				|	   |      |		 |
			    5	   4     100     20
 */
public class J1_Expression_Tree_Introduction {

    public static void main(String[] args) {
        ExpressionTree obj = new ExpressionTree();
        obj.root = new ExpressionNode("+");
        obj.root.left = new ExpressionNode("*");
        obj.root.right = new ExpressionNode("-");
        obj.root.left.left = new ExpressionNode("5");
        obj.root.left.right = new ExpressionNode("4");
        obj.root.right.left = new ExpressionNode("100");
        obj.root.right.right = new ExpressionNode("20");

        obj.printExpression(obj.root);
        System.out.println();

        System.out.println("Expression result = " + obj.evaluateExpression(obj.root));



    }
}

class ExpressionNode {
    String data;
    ExpressionNode left;
    ExpressionNode right;

    ExpressionNode(String data) {
        this.data = data;
    }
}

class ExpressionTree {
    ExpressionNode root;

    // Doing in-order traversal will give us actual expression.
    public void printExpression(ExpressionNode node) {
        if(node == null) {
            return;
        }
        printExpression(node.left);
        System.out.print(node.data);
        printExpression(node.right);
    }


    // Evaluate the expression.
    public int evaluateExpression(ExpressionNode node) {
        if(node == null) {
            return 0;
        }
        // leaf node. if it is leaf node that means its operand so we just return it.
        if(node.left == null && node.right == null) {
            return Integer.parseInt(node.data);
        }

        Integer leftValue = evaluateExpression(node.left);
        Integer rightValue = evaluateExpression(node.right);

        // Operations to apply
        if(node.data.equals("+")) {
            return leftValue + rightValue;
        } else if(node.data.equals("-")) {
            return leftValue - rightValue;
        } else if(node.data.equals("*")) {
            return leftValue * rightValue;
        } else {
            return leftValue / rightValue;
        }
    }
}
