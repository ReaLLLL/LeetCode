package com.leetcode.section3;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * @author alexsong
 * @version $Id: Solution202.java, v 0.1 2017年12月17日 下午9:48:48 alexsong Exp $
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (n != 1) {
            int t = 0;
            while (n != 0) {
                t += (n % 10) * (n % 10);
                n /= 10;
            }
            n = t;
            if (s.contains(n)) break;
            else s.add(n);
        }
        return n == 1;
    }
}
