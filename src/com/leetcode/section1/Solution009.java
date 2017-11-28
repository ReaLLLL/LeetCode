package com.leetcode.section1;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * @author alexsong
 * @version $Id: Solution009.java, v 0.1 2017年11月24日 下午3:08:08 alexsong Exp $
 */
public class Solution009 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int div = 1;
        while(div<=x/10)
            div *= 10;
        while(x>0)
        {
            if(x/div!=x%10)
                return false;
            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }
}
