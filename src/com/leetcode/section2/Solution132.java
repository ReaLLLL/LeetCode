package com.leetcode.section2;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * @author alexsong
 * @version $Id: Solution132.java, v 0.1 2017年12月05日 下午10:39:39 alexsong Exp $
 */
public class Solution132 {
    public int minCut(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[arr.length + 1];
        int[][] A = new int[s.length()][s.length()];

        for(int i = arr.length-1; i >= 0 ;i--){
            count[i] = Integer.MAX_VALUE;
            for(int j = i; j < arr.length; j++){
                if(arr[i]==arr[j] &&(j-i<2 || A[i+1][j-1] ==1)){
                    A[i][j] = 1;
                    count[i] = Math.min(1+count[j+1], count[i]);
                }
            }
        }

        return count[0] - 1;
    }
}
