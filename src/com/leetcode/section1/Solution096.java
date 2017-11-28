package com.leetcode.section1;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * @author alexsong
 * @version $Id: Solution096.java, v 0.1 2017年11月27日 下午9:23:23 alexsong Exp $
 */
public class Solution096 {
    public int numTrees(int n) {
        int[] tmp = new int[n+1];
        tmp[0] = 1;
        tmp[1] = 1;

        for(int i = 2; i <= n;i++)
            for(int j = 0; j < i; j++)
                tmp[i] += tmp[j]*tmp[i-j-1];

        return tmp[n];
    }

    public static void main(String[] args){
        Solution096 s = new Solution096();

        System.out.print(s.numTrees(19));
    }
}
