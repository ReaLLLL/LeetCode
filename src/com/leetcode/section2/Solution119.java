package com.leetcode.section2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3, Return [1,3,3,1].
 *
 * @author alexsong
 * @version $Id: Solution119.java, v 0.1 2017年12月01日 上午9:45:45 alexsong Exp $
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args){
        Solution119 s = new Solution119();
        System.out.println(s.getRow(31));
    }
}
