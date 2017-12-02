package com.leetcode.section2;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * @author alexsong
 * @version $Id: Solution120.java, v 0.1 2017年12月01日 下午6:41:41 alexsong Exp $
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row-1).size();

        int[][] A = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i == 0){
                    A[i][j] = triangle.get(0).get(0);
                    continue;
                }

                if(j == 0)
                    A[i][j] = A[i-1][j] + triangle.get(i).get(j);
                else if(j == i)
                    A[i][j] = A[i-1][j-1] + triangle.get(i).get(j);
                else
                    A[i][j] = Math.min(A[i-1][j-1], A[i-1][j]) + triangle.get(i).get(j);
            }
        }

        int min = A[row-1][0];
        for(int i = 1; i < col; i++){
            min = Math.min(min, A[row-1][i]);
        }

        return min;
    }
}
