package com.leetcode.section1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * @author alexsong
 * @version $Id: Solution001.java, v 0.1 2017年11月21日 下午12:58:58 alexsong Exp $
 */
public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++)
        {
            map.put(nums[i],i);
        }
        for(int i = 0; i<nums.length; i++)
        {
            if( null != map.get(target-nums[i]) && i != map.get(target-nums[i]))
            {
                result[1] = map.get(target-nums[i]);
                result[0] = i;
                break;
            }
        }

        return result;
    }
}
