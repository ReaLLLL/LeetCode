package com.leetcode.section2;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * @author alexsong
 * @version $Id: Solution191.java, v 0.1 2017年12月13日 下午10:39:39 alexsong Exp $
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int i = 0, j = 1,res = 0;

        while(i<32){
            if((n & j)/j == 1)
                res++;
            j = j << 1;
            i++;
        }
        return res;
    }
}
