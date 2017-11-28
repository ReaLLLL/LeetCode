package com.leetcode.section1;

/*
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/

public class Solution005 {
    //已i为中心往两边扩展
    public String longestPalindrome_001(String s) {
        int maxLen = 1;
        int center = 1;
        StringBuilder newStr = new StringBuilder("#");
        for(int i = 0; i < s.length(); i++){
            newStr.append(s.charAt(i));
            newStr.append("#");
        }
        s = newStr.toString();

        for(int i = 1; i<s.length()-1; i++){
            int j = 1;
            while(i-j>=0 && i+j <= s.length()-1 && s.charAt(i+j) == s.charAt(i-j)){
                j++;
            }

            if(--j > maxLen){
                center = i;
                maxLen = j;
            }
        }
        return s.substring(center-maxLen, center+maxLen+1).replace("#","");
    }

    //MANACHER
    public String longestPalindrome_002(String s) {

        return null;
    }

    public static void main(String[] args){
        Solution005 s = new Solution005();
        System.out.print(s.longestPalindrome_001("abc"));
    }
}
