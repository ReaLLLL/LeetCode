package com.leetcode.section2;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * @author alexsong
 * @version $Id: Solution108.java, v 0.1 2017年11月29日 下午5:21:21 alexsong Exp $
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(start == end)
            return root;

        root.left = start <= mid-1? sortedArrayToBST(nums, start,mid-1):null;
        root.right = end >= mid-1? sortedArrayToBST(nums, mid+1,end):null;

        return root;
    }
}
