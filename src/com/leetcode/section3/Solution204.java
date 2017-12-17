package com.leetcode.section3;

import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * @author alexsong
 * @version $Id: Solution204.java, v 0.1 2017年12月17日 下午10:02:02 alexsong Exp $
 */
public class Solution204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int[] p = new int[n];
        Arrays.fill(p, 1);
        for (int i = 2; i * i < n; i++)
        {
            if (p[i]==1)
            {
                for (int j = 2; j * i < n; j++)
                    p[i * j] = 0;
            }
        }

        int cnt = 0;
        for (int i = 2; i != n; i++)
            if (p[i] == 1)   cnt++;
        return cnt;
    }
}
