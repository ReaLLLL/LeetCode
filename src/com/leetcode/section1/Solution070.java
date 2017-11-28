package com.leetcode.section1;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * @author alexsong
 * @version $Id: Solution070.java, v 0.1 2017年11月23日 下午11:47:47 alexsong Exp $
 */
public class Solution070 {
    private final int[] tmp = new int[100];

    public int climbStairs(int n) {
        if(n==1||n==2){
            tmp[n]=n;
            return tmp[n];
        }

        if(tmp[n] > 0)
            return tmp[n];

        tmp[n] = climbStairs(n-1)+climbStairs(n-2);
        return tmp[n];
    }

    public int climbStairs_002(int n) {
        //dynamic programming
        //each step one / two
        if(n<=0)
            return 0;
        if(n == 1)
            return 1;
        int pre = 1;
        int cur = 2;
        for(int i = 2;i < n; i++){
            int tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args){
        Solution070 s = new Solution070();
        System.out.println(s.climbStairs(44));

        System.out.println(s.climbStairs_002(44));
    }
}
