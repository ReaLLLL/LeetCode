package com.leetcode.section2;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * @author alexsong
 * @version $Id: Solution167.java, v 0.1 2017年12月11日 下午10:32:32 alexsong Exp $
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;

        int i = 0, j = len-1;
        while (i<j){
            if(numbers[i] + numbers[j] < target){
                i++;
                continue;
            }else if(numbers[i] + numbers[j] > target){
                j--;
                continue;
            }else
                break;
        }

        int[] A = {i+1, j+1};

        return A;
    }
}
