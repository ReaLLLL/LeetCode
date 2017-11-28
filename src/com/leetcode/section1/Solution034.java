package com.leetcode.section1;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution034.java, v 0.1 2017年11月22日 下午5:03:03 alexsong Exp $
 */
public class Solution034 {
    public final int[] res = {-1,-1};

    public int[] searchRange(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;

        if(nums[0] > target || nums[end] < target)
            return res;

        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] >= target)
                end = mid;
            else
                start = mid+1;
        }

        res[0] = start;

        end = nums.length-1;
        start = 0;

        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] > target)
                end = mid;
            else
                start = mid+1;
        }
        res[1] = start;

        return res;
    }


}
