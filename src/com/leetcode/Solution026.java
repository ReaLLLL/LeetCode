package com.leetcode;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * @author alexsong
 * @version $Id: Solution026.java, v 0.1 2017年11月22日 上午12:19:19 alexsong Exp $
 */
public class Solution026 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;

        while(j<nums.length){
            if(nums[i]!=nums[j])
                nums[++i]=nums[j];
            j++;
        }
        return i+1;
    }

    public static void main(String[] args){
        //int[] a = {1,2,2,3,4,5,5,7,8,8};
        int[] a = {1,1,2,3};

        Solution026 s = new Solution026();

        System.out.print(s.removeDuplicates(a));
    }
}
