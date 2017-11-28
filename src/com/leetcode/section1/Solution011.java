package com.leetcode.section1;

/**
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * @author alexsong
 * @version $Id: Solution011.java, v 0.1 2017年11月22日 下午12:15:15 alexsong Exp $
 */
public class Solution011 {
    public int maxArea(int[] height) {
        int rLimit = height.length-1;
        int lLimit = 0;
        int max = Math.min(height[lLimit],height[rLimit])*(rLimit-lLimit);

        while(lLimit < rLimit){
            if(height[lLimit] < height[rLimit])
                lLimit++;
            else
                rLimit--;
            max = Math.max(Math.min(height[lLimit],height[rLimit])*(rLimit-lLimit),max);
        }

        return max;
    }

    public static void main(String[] args){
        Solution011 s = new Solution011();
        int[] height = {1,1};
        System.out.print(s.maxArea(height));
    }
}
