package com.leetcode.section1;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * @author alexsong
 * @version $Id: Solution007.java, v 0.1 2017年11月21日 下午5:57:57 alexsong Exp $
 */
public class Solution007 {
    public int reverse(int x) {
        int res = 0;
        while(x!=0)
        {
            //注意溢出
            if(Math.abs(res) > Integer.MAX_VALUE/10)
                return 0;

            res = res*10 + x%10;
            x/=10;
        }
        return res;
    }

    public static void main(String[] args){
        Solution007 s = new Solution007();
        System.out.print(s.reverse(-1234567899));
    }
}
