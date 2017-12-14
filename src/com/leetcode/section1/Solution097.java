package com.leetcode.section1;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * @author alexsong
 * @version $Id: Solution097.java, v 0.1 2017年12月14日 下午10:18:18 alexsong Exp $
 */
public class Solution097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] S1 = s1.toCharArray();
        char[] S2 = s2.toCharArray();
        char[] S3 = s3.toCharArray();

        //return helper(S1, s1.length()-1, S2, s2.length()-1, S3, s3.length()-1);
        return helper(S1, S2, S3);
    }

    protected boolean helper(char[] s1, int idx1, char[] s2, int idx2, char[] s3, int idx3){
        if(idx1 < 0 || idx2 < 0)
            return false;

        if(s3[idx3] != s1[idx1] && s3[idx3] != s2[idx2])
            return false;

        if(s3[idx3] == s1[idx1] && s3[idx3] != s2[idx2])
            return helper(s1, idx1-1, s2, idx2, s3, idx3-1);

        if(s3[idx3] != s1[idx1] && s3[idx3] == s2[idx2])
            return helper(s1, idx1, s2, idx2-1, s3, idx3-1);

        return helper(s1, idx1-1, s2, idx2, s3, idx3-1) || helper(s1, idx1, s2, idx2-1, s3, idx3-1);
    }

    protected boolean helper(char[] s1, char[] s2, char[] s3){
        int m = s1.length;
        int n = s2.length;
        if(m+n != s3.length)
            return false;

        int[][] A = new int[m+1][n+1];

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(i==0 && j==0)
                    A[i][j] = 1;
                else if(i == 0)
                    A[i][j] = A[i][j-1] & (s2[j-1]==s3[j-1]?1:0);
                else if(j == 0)
                    A[i][j] = A[i-1][j] & (s1[i-1]==s3[i-1]?1:0);
                else
                    A[i][j] = (A[i][j-1] & (s2[j-1]==s3[i+j-1]?1:0)) | (A[i-1][j] & (s1[i-1]==s3[i+j-1]?1:0));
            }
        }

        return A[m][n]==1;
    }
}
