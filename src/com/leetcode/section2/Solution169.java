package com.leetcode.section2;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author alexsong
 * @version $Id: Solution169.java, v 0.1 2017年12月12日 下午9:25:25 alexsong Exp $
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int[] A = new int[nums.length];
        Arrays.fill(A, 1);

        int i = 0, j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                A[i] = 0;
                A[j] = 0;
                while (A[i] == 0 && i < nums.length) i++;
                j++;
                if(i == j)
                    j++;
            }
            else
                j++;
        }
        for(i = 0; i< nums.length;i++){
            if(A[i] == 1)
                break;
        }

        return nums[i];
    }
}
