package com.leetcode.section3;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 * @author alexsong
 * @version $Id: Solution201.java, v 0.1 2017年12月17日 下午9:42:42 alexsong Exp $
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int offset = 0;
        while(m!=n){
            m>>=1;
            n>>=1;
            offset++;
        }
        return m<<offset;
    }
}
