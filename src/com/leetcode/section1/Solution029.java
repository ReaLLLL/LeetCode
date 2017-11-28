package com.leetcode.section1;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 *
 * @author alexsong
 * @version $Id: Solution029.java, v 0.1 2017年11月22日 下午4:42:42 alexsong Exp $
 */
public class Solution029 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return Integer.MAX_VALUE;

        if(Math.abs(dividend) < Math.abs(divisor))
            return 0;

        return 0;
    }

    public static void main(String[] args){
        System.out.print(Math.abs(Integer.MIN_VALUE+1));
    }
}
