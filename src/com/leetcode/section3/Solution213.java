package com.leetcode.section3;

/**
 * House Robber II
 *
 * @author alexsong
 * @version $Id: Solution213.java, v 0.1 2017年12月18日 下午10:50:50 alexsong Exp $
 */
public class Solution213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0 || len ==2)
            return 0;

        if(len == 1)
            return nums[0];

        return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
    }

    protected int helper(int[] nums, int start, int end){
        int a = 0, b = 0;
        for (int i = start; i < end; ++i) {
            int m = a, n = b;
            a = n + nums[i];
            b = Math.max(m, n);
        }
        return Math.max(a, b);
    }
}
