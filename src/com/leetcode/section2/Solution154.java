package com.leetcode.section2;

/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
* Find the minimum element.The array may contain duplicates.
* */
public class Solution154 {
    public int findMin(int[] nums) {
        if(nums.length ==1 )
            return nums[0];

        for(int i = nums.length -2; i >= 0; i--){
            if(nums[i] > nums[i+1])
                return nums[i+1];
        }

        return nums[0];
    }
}
