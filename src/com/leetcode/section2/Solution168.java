package com.leetcode.section2;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * @author alexsong
 * @version $Id: Solution168.java, v 0.1 2017年12月11日 下午10:47:47 alexsong Exp $
 */
public class Solution168 {
    public String convertToTitle(int n) {
        if(n==0)
            return "Z";

        if(n<=26)
            return ""+(char)(64+n);

        return convertToTitle((n-1)/26)+convertToTitle(n%26);
    }

    public static void main(String[] args){
        Solution168 s = new Solution168();

        System.out.print(s.convertToTitle(52));
    }
}
