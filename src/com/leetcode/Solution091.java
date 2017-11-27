package com.leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * @author alexsong
 * @version $Id: Solution091.java, v 0.1 2017年11月27日 下午3:37:37 alexsong Exp $
 */
public class Solution091{
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

    public static void main(String[] args){
        Solution091 s = new Solution091();
        System.out.print(s.numDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
    }
}
