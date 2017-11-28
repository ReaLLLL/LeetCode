package com.leetcode.section1;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * @author alexsong
 * @version $Id: Solution022.java, v 0.1 2017年11月22日 下午4:27:27 alexsong Exp $
 */
public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        this.generate(n,n,"",list);
        return list;
    }

    public void generate(int leftNum, int rightNum, String s, List<String> list){
        if(leftNum==0&&rightNum==0){
            //当前无剩余左右括号了
            list.add(s);
        }

        if(leftNum > 0){
            //加一个左括号，并以此为基础递归计算
            generate(leftNum-1,rightNum,s+"(", list);
        }

        if(rightNum >0 && leftNum < rightNum){
            generate(leftNum,rightNum-1,s+")",list);
        }
    }

    public static void main(String[] args){
        Solution022 s = new Solution022();

        List<String> list = s.generateParenthesis(5);
        for(String str : list){
            System.out.println(str);
        }
    }
}

