package com.leetcode.section2;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * @author alexsong
 * @version $Id: Solution121.java, v 0.1 2017年12月01日 下午10:38:38 alexsong Exp $
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(0 == len)
            return 0;
        int low = prices[0];
        int maxProfit = 0;

        for(int i = 1;i<len;i++){
            maxProfit = Math.max(maxProfit, prices[i] - low);
            low = Math.min(low,prices[i]);
        }

        return maxProfit;
    }
}
