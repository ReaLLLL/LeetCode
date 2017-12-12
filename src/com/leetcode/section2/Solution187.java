package com.leetcode.section2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * @author alexsong
 * @version $Id: Solution187.java, v 0.1 2017年12月12日 下午10:33:33 alexsong Exp $
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        char[] arr = s.toCharArray();
        List<String> res = new ArrayList<String>() ;
        List<Integer> st = new ArrayList<Integer>();

        int cur = 0, i = 0;
        while (i < 9) cur = cur << 3 | (arr[i++] & 7);
        while (i < s.length()) {
            cur = ((cur & 0x7ffffff) << 3) | (arr[i++] & 7);
            if (st.contains(cur))
                res.add(s.substring(i - 10, i));
            else
                st.add(cur);
        }
        return res;
    }
}
