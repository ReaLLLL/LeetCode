package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 *
 * @author alexsong
 * @version $Id: Solution003.java, v 0.1 2017年11月21日 下午12:59:59 alexsong Exp $
 */
public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxSize = 0;
        int tmpSize = 0;
        int start = 0;
        for(int i = 0; i<s.length();i++)
        {
            if(map.get(charArray[i]) == null || map.get(charArray[i]) < start)
            {
                tmpSize++;
                maxSize++;
            }
            else
            {
                start = map.get(charArray[i])+1;
                tmpSize = i-start;
                maxSize = Math.max(maxSize,tmpSize);
            }
            map.put(charArray[i],i);
        }
        return maxSize;
    }
}
