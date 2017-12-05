package com.leetcode.section2;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * @author alexsong
 * @version $Id: Solution134.java, v 0.1 2017年12月05日 下午11:28:28 alexsong Exp $
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int cur = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < len; i++){
            cur += (gas[i] - cost[i]);
            total += (gas[i] - cost[i]);

            if(cur < 0)
            {
                start = i;
                cur = 0;
            }
        }

        return total < 0? -1 : start+1;
    }
}
