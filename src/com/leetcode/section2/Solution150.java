package com.leetcode.section2;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * @author alexsong
 * @version $Id: Solution150.java, v 0.1 2017年12月09日 上午12:01:01 alexsong Exp $
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;

                if(tokens[i].equals("+"))
                    res = num1 + num2;
                else if(tokens[i].equals("-"))
                    res = num1 - num2;
                else if(tokens[i].equals("*"))
                    res = num1 * num2;
                else if(tokens[i].equals("/"))
                    res = num1 / num2;

                stack.push(res);
            }
            else
                stack.push(Integer.valueOf(tokens[i]));
        }

        return stack.pop();
    }
}
