package com.leetcode.section2;

import java.util.Arrays;
import java.util.List;

/*
* Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
* determine if s can be segmented into a space-separated sequence of one or more dictionary words.
* You may assume the dictionary does not contain duplicate words.
* */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] tmp = new int[s.length() + 1];
        Arrays.fill(tmp, 0);

        tmp[0] = 1;
        for(int i =0 ; i<= s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(tmp[j] == 1 && wordDict.contains(s.substring(j,i))){
                    tmp[i] = 1;
                    break;
                }
            }
        }

        return tmp[s.length()] == 1;
    }
}
