package com.leetcode.section2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 *
 * @author alexsong
 * @version $Id: Solution163.java, v 0.1 2017年12月11日 下午9:22:22 alexsong Exp $
 */
public class Solution163 {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i <= A.length; i++){
            String s = null;
            if(i == 0){
                s = this.generate(lower, A[0]);
                if(null != s)
                    res.add(s);

                continue;
            }

            if(i == A.length){
                s = this.generate(A[A.length -1], upper);
                if(null != s)
                    res.add(s);

                break;
            }

            s = this.generate(A[i-1], A[i]);
            if(null != s)
                res.add(s);
        }

        return res;
    }

    protected String generate(int start, int end){
        if(start == end || start == end-1 )
            return null;

        if(start == end - 2)
            return String.valueOf(start+1);

        return "".concat(String.valueOf(start+1)).concat("->").concat(String.valueOf(end-1));
    }

    public static void main(String[] args){
        Solution163 s = new Solution163();
        int[] A = {0, 1, 3, 50, 75};

        System.out.print(s.findMissingRanges(A, 0, 99));
    }
}
