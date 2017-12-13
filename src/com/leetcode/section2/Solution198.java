package com.leetcode.section2;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution198.java, v 0.1 2017年12月13日 下午10:41:41 alexsong Exp $
 */
public class Solution198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;

        if(len == 1)
            return nums[0];

        if(len == 2)
            return Math.max(nums[0], nums[1]);

        int[] A = new int[len];
        A[0] = nums[0];
        A[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i<len;i++){
            A[i] = Math.max(nums[i]+A[i-2], A[i-1]);
        }

        return A[len-1];
    }
}
