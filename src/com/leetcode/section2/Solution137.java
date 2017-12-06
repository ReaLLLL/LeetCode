package com.leetcode.section2;

/*
* Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
* */
public class Solution137 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0, sa = 0, sb = 0;
        for(int i = 0; i< nums.length; i++){
            sa= (~a&b&nums[i]) | (a&~b&~nums[i]);
            sb=(~a)&(b^nums[i]);
            a=sa;
            b=sb;
        }
        return b;
    }
}
