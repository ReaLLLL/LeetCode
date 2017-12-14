package com.leetcode.section1;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * @author alexsong
 * @version $Id: Solution095.java, v 0.1 2017年12月14日 下午10:51:51 alexsong Exp $
 */
public class Solution095 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sum = m + n;
        int a = m-1, b=n-1;
        for(int i = sum-1; i >= 0; i--){
            if(nums1[a] > nums1[b]) {
                nums1[i] = nums1[a];
                a--;
            }else {
                nums1[i] = nums2[b];
                b--;
            }
        }
    }
}
