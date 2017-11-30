package com.leetcode.section2;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * @author alexsong
 * @version $Id: Solution115.java, v 0.1 2017年11月30日 下午5:09:09 alexsong Exp $
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) dp[0][i] = 1;
        for (int i = 1; i < t.length() + 1; i++) dp[i][0] = 0;

        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                dp[i][j] = dp[i][j - 1] + (s.charAt(j - 1) == t.charAt(i - 1) ? dp[i - 1][j - 1] : 0);
            }
        }

        return dp[t.length()][s.length()];
    }

    public static void main(String[] args){
        Solution115 s = new Solution115();
        System.out.print(s.numDistinct("rabbbit","rabbit"));
    }
}
