package com.leetcode.section1;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author alexsong
 * @version $Id: Solution031.java, v 0.1 2017年11月23日 下午9:10:10 alexsong Exp $
 */
public class Solution031 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(nums.length == 1)
            return;

        int i = len-2;
        for(; i>=0; i--){
            if(nums[i] < nums[i+1])
                break;
        }
        int j = len-1;
        if(i >= 0){
            for(; j>i; j--){
                if(nums[j] > nums[i])
                    break;
            }
            swap(nums, i, j);
        }

        Arrays.sort(nums, i+1, nums.length);
    }

    public void swap(int[] num, int id1, int id2){
        int tmp = num[id1];
        num[id1] = num[id2];
        num[id2] = tmp;
    }

    public static void main(String[] args){
        Solution031 s = new Solution031();

        int[] a = {1,5,1};

        s.nextPermutation(a);

        System.out.print(Arrays.toString(a));
    }
}
