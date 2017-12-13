package com.leetcode.section2;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * @author alexsong
 * @version $Id: Solution188.java, v 0.1 2017年12月13日 下午9:30:30 alexsong Exp $
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        /*
        *global[i][j]=max(local[i][j],global[i-1][j])
        *local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
         */
        if(prices==null || prices.length<2)
            return 0;

        int len = prices.length;

        int[] global = new int[k+1];
        int[] local = new int[k+1];

        for(int i = 0; i< len-1; i++){
            int diff = prices[i+1] - prices[i];
            for(int j = k; j > 0; j--){
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }

        return global[k];
    }
}
