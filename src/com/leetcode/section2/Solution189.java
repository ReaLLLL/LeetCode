package com.leetcode.section2;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * @author alexsong
 * @version $Id: Solution189.java, v 0.1 2017年12月12日 下午10:45:45 alexsong Exp $
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        if(k % nums.length ==0)
            return;

        int n = nums.length, start = 0, i = 0, cur = nums[i], cnt = 0;
        while (cnt++ < n) {
            i = (i + k) % n;
            int t = nums[i];
            nums[i] = cur;
            if (i == start) {
                ++start; ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
    }
}
