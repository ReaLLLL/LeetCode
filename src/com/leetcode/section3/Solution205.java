package com.leetcode.section3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * @author alexsong
 * @version $Id: Solution205.java, v 0.1 2017年12月17日 下午10:10:10 alexsong Exp $
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        // 两个字符串都为空
        if (s == null && t == null) {
            return true;
        }
        // 只有一个为空
        else if (s == null || t == null) {
            return false;
        }
        // 两个字符串的长度都为0
        else if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        // 两个字符串的长度不相等
        else if (s.length() != t.length()) {
            return false;
        }

        // 保存映射关系
        Map<Character, Character> map = new HashMap<>(s.length());
        Set<Character> set = new HashSet<>(t.length());
        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            // 键未出现过，就保存映射关系
            if (!map.containsKey(sChar)) {
                if (set.contains(tChar)) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                    set.add(tChar);
                }
            }
            // 如是键已经出现过
            else {

                // 原先的键映射的值是map.get(sChar)，现在要映射的值是tChar
                // 如果两个值不相等，说明已经映射了两次，不符合，返回false
                if (map.get(sChar) != tChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
