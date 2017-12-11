package com.leetcode.section2;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an input string, reverse the string word by word.
 *
 * @author alexsong
 * @version $Id: Solution151.java, v 0.1 2017年12月09日 下午11:28:28 alexsong Exp $
 */
public class Solution151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        //return String.join(" ", words);
        return null;
    }
}
