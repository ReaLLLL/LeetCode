package com.leetcode.section2;

/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * @author alexsong
 * @version $Id: Solution171.java, v 0.1 2017年12月12日 下午9:39:39 alexsong Exp $
 */
public class Solution171 {
    public int titleToNumber(String s) {
        char[] arr = s.toCharArray();

        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res = res*26 + (arr[i] - 64);
        }

        return res;
    }
}
