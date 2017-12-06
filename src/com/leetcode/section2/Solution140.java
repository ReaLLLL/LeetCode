package com.leetcode.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word.
*You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.
* */
public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
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

        //根据辅助数组生成序列
        List<String> ret = new ArrayList<String>();
        List<String> path = new ArrayList<String>();

        this.generate(s, wordDict, path, ret, 0, tmp);

        return ret;
    }

    protected void generate(String s, List<String> wordDict, List<String> path, List<String> ret, int start, int[] A){
        int len = s.length();

        if(start == len){
            StringBuilder sb = new StringBuilder("");
            for(String str : path){
                sb.append(str);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            ret.add(sb.toString());
            return;
        }

        if(A[start] == 0)
            return;

        for(int i = start; i<len;i++){
            String str = s.substring(start,i+1);
            if(!wordDict.contains(str))
                continue;

            path.add(str);

            generate(s, wordDict, path, ret, i+1, A);

            path.remove(path.size()-1);
        }
    }
}
