package com.leetcode.section2;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution131.java, v 0.1 2017年12月05日 下午10:16:16 alexsong Exp $
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        //构建数组A[][]，其中A[i][j]=1 表示字符串S[i...j]为回文子串
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<>();

        if(null == s || s.length() == 0){
            result.add(list);
            return result;
        }

        int[][] A = new int[s.length()][s.length()];
        this.generate(s, A);
        this.dfs(s, 0, A, list, result);

        return result;
    }

    public void generate(String s, int[][] A){
        char[] arr = s.toCharArray();
        for(int i = arr.length-1; i>=0;i--){
            for(int j = i; j<arr.length;j++){
                if(i==j)
                    A[i][j] = 1;
                else
                    if(arr[j] == arr[i]){
                        if(j==i+1 || A[i+1][j-1] == 1){
                            A[i][j] = 1;
                        }
                    }
            }
        }
    }

    public void dfs(String s, int begin, int[][] A, List<String> list, List<List<String>> result){
        if(begin == s.length()){
            result.add(list);
            return;
        }

        for(int i = begin; i<s.length(); i++){
            if(A[begin][i] == 1){
                List<String> tmp = new ArrayList<>(list);
                tmp.add(s.substring(begin,i+1));
                this.dfs(s, i+1, A, tmp, result);
            }
        }
    }



}
