package com.leetcode.section2;
/*
* Given a string S, find the length of the longest substring T that contains at most two distinct characters.
* Given S = “eceba”,
* T is “ece” which its length is 3.
* */
public class Solution157 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i=0,j=-1,ml =0;
        for(int k=1;k<s.length();k++){
            if(s.charAt(k)==s.charAt(k-1)){
                continue;
            }
            if(j>=0 && s.charAt(k)!=s.charAt(j)){
                ml = Math.max(ml,k-i);
                i = j+1;
            }
            j = k-1;
        }
        return Math.max(s.length()-i,ml);
    }
}
