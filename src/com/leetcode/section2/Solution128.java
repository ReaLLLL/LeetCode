package com.leetcode.section2;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 * @author alexsong
 * @version $Id: Solution128.java, v 0.1 2017年12月04日 下午5:19:19 alexsong Exp $
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;

        Set<Integer> set = new HashSet<Integer>();
        int i = 0;
        for(i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int maxLen = 0;

        for(i = 0; i < len; i++){
            if(set.contains(nums[i])){
                int tmp = nums[i];
                int tLen = 0;
                while(set.contains(tmp)){
                    set.remove(tmp);
                    tmp++;
                    tLen++;
                }
                tmp = nums[i]-1;
                while (set.contains(tmp)) {
                    set.remove(tmp);
                    tmp--;
                    tLen++;
                }
                maxLen = Math.max(tLen, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        int[] A = {400,3,100,1,4,2};
        Solution128 s = new Solution128();
        System.out.println(s.longestConsecutive(A));
    }
}
