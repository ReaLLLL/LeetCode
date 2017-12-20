package com.leetcode.section3;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * @author alexsong
 * @version $Id: Solution215.java, v 0.1 2017年12月20日 下午11:20:20 alexsong Exp $
 */
public class Solution215 {
    //借用快速排序的思想，判断每次分割元素所在的位置与K比较
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1)
                return nums[pos];
            else if (pos > k - 1)
                right = pos - 1;
            else
                left = pos + 1;
        }
    }

    protected int partition(int[] nums, int left, int right) {
        int pivot = nums[left], l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums[l++], nums[r--]);
            }
            if (nums[l] >= pivot) ++l;
            if (nums[r] <= pivot) --r;
        }
        swap(nums[left], nums[r]);
        return r;
    }
}
