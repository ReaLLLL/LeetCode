package com.leetcode.section1;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * @author alexsong
 * @version $Id: Solution015.java, v 0.1 2017年11月22日 下午3:44:44 alexsong Exp $
 */
public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;)
        {
            List<List<Integer>> t = twoSum(nums, i+1, 0-nums[i]);

            if(t.size()>0)
            {
                for(List<Integer> l : t) {
                   l.add(0,nums[i]);
                }
                list.addAll(t);
            }
            i++;
            while(i<nums.length-1 && nums[i]==nums[i-1] ) i++;
        }

        return list;
    }

    public List<List<Integer>> twoSum(int[] nums, int begin, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = begin, j=nums.length-1;
        while (i<j){
            if(nums[i]+nums[j]>target){
                do {
                    j--;
                }
                while(j!=i && nums[j]==nums[j+1]);
            }
            else if(nums[i] + nums[j]<target){
               do{
                   i++;
               } while(j!=i && nums[i]==nums[i-1]);
            }
            else {
                List<Integer> t = new ArrayList<Integer>();
                t.add(nums[i]);
                do{
                    i++;
                } while(j!=i && nums[i]==nums[i-1]);

                t.add(nums[j]);
                do {
                    j--;
                }
                while(j>=i && nums[j]==nums[j+1]);

                result.add(t);
            }
        }

        return result;
    }

    public static void main(String[] args){
        //int[] a = {-1,0,1,2,-1,-4};
        int[] a = {0,0,0};
        Solution015 s = new Solution015();
        System.out.print(s.threeSum(a));
    }
}
