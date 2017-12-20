package com.leetcode.section3;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * @author alexsong
 * @version $Id: Solution209.java, v 0.1 2017年12月18日 下午10:20:20 alexsong Exp $
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE, left = 0, sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
