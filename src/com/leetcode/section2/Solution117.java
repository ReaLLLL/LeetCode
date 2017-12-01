package com.leetcode.section2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * @author alexsong
 * @version $Id: Solution117.java, v 0.1 2017年12月01日 上午12:35:35 alexsong Exp $
 */
public class Solution117 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return result;

        for(int i = 1; i <= numRows; i++){
            if(i<=2)
                result.add(this.generate(null,i));
            else
                result.add(this.generate(result.get(i-2), i));
        }
        return result;
    }

    public List<Integer> generate(List<Integer> pre, int k){
        List<Integer> res = new ArrayList<Integer>(k);
        res.add(1);
        for(int i = 1; i < k-1; i++)
            res.add(pre.get(i-1)+pre.get(i));
        if(k>1)
            res.add(1);

        return res;
    }

    public static void main(String[] args){
        Solution117 s = new Solution117();
        System.out.println(s.generate(2));
    }
}
