package com.leetcode.section2;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * @author alexsong
 * @version $Id: Solution135.java, v 0.1 2017年12月05日 下午11:38:38 alexsong Exp $
 */
public class Solution135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return 1;

        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);

        for(int i = 1; i <ratings.length; i++)
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;

        for(int i = len-2; i>=0; i--)
            if(ratings[i] > ratings[i+1]&& candy[i] <= candy[i + 1])
                candy[i] = candy[i+1]+1;

        int total = 0;
        for(int i = 0; i <len; i++){
            total += candy[i];
        }

        return total;
    }
}
