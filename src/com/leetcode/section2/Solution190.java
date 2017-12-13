package com.leetcode.section2;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * @author alexsong
 * @version $Id: Solution190.java, v 0.1 2017年12月13日 下午10:30:30 alexsong Exp $
 */
public class Solution190 {
    public int reverseBits(int n) {
        int[] A = new int[32];

        int i = 0, j = 1,res = 0;

        while(i<32){
            A[i] = (n & j)/j;
            j = j << 1;
            i++;
        }

        i = 0;
        while (i<32){
            res = res * 2 +A[i];
            i++;
        }

        return res;
    }

    public static void main(String[] args){
        Solution190 s = new Solution190();
        System.out.print(s.reverseBits(43261596));
    }
}
