package com.leetcode.section1;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 * @author alexsong
 * @version $Id: Solution032.java, v 0.1 2017年11月24日 下午3:29:29 alexsong Exp $
 */
public class Solution032 {
    public int longestValidParentheses(String s) {
        if (null==s || s.length() <= 1)
            return 0;

        int[] pos = new int[s.length()];
        int i = 0, j = 0, tmpLen = 0, maxLen = 0;
        for(i=0;i<s.length();i++)
            pos[i] = -1;

        i=0;
        while (i<s.length() && j<s.length()){
            while(i<s.length()){
                if(s.charAt(i) == '(' && pos[i] == -1)
                    break;
                i++;
            }

            j = i+1;
            while(j<s.length()){
                if(s.charAt(j) == ')' && pos[j] == -1)
                    break;
                j++;
            }

            while (j<s.length()){
                if(s.charAt(j) == ')') {
                    if(s.charAt(j-1) == '('){
                        pos[j-1] = j;
                        i = j-1;
                    }
                    else{
                        while(i>-1) {
                            if (s.charAt(i) == '(' && pos[i] == -1) {
                                pos[i] = j;
                                break;
                            }
                            i--;
                        }
                    }
                }
                j++;

                if(i==-1) {
                    i=0;
                    break;
                }
            }
        }

        i = 0;
        while(i<s.length()){
            if(pos[i]!=-1){
                tmpLen += (pos[i] - i + 1);
                i = pos[i]+1;
            }
            else {
                tmpLen = 0;
                i++;
            }
            maxLen = Math.max(maxLen, tmpLen);
        }
        return maxLen;
    }

    public int longestValidParentheses_002(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len < 2)
            return 0;
        int[] counters = new int[len+1];
        int c = 0;
        counters[0] = -1;
        int max = 0;
        int i = 0;
        while(i < len) {
            if ('(' == chars[i]) {
                c = c + 1;
                counters[c] = i;
                i = i +1;
                continue;

            }
            if (c > 0) {
                c = c - 1;
                int m = i - counters[c];
                if(m > max)
                    max = m;
                i = i +1;
                continue;
            }
            counters[0] = i;
            i = i +1;
        }
        return max;
    }

    public static void main(String[] args){
        Solution032 s = new Solution032();
        System.out.println(s.longestValidParentheses("(((()))()))"));
    }
}
