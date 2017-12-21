package com.leetcode.section3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * @author alexsong
 * @version $Id: Solution219.java, v 0.1 2017年12月21日 下午10:46:46 alexsong Exp $
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length<2) return false;
        //key=int, val=index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if(i-j<=k)
                    return true;
                else
                    map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
