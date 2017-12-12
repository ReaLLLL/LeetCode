package com.leetcode.section2;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * @author alexsong
 * @version $Id: Solution172.java, v 0.1 2017年12月12日 下午9:52:52 alexsong Exp $
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        return n / 5 == 0 ? 0 : n /5 + trailingZeroes(n / 5);
    }
}
