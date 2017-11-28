package com.leetcode.section1;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * @author alexsong
 * @version $Id: Solution093.java, v 0.1 2017年11月27日 下午2:03:03 alexsong Exp $
 */
public class Solution093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String >();
        if (s.length() < 4 || s.length() > 12)
            return list;

        int len = s.length();
        StringBuffer sb = new StringBuffer();

        for(int i = 1; i < 4; i++){
            if(isValid(s.substring(0,i))){
                for(int j=i+1; j<Math.min(len-1,i+4);j++){
                    if(isValid(s.substring(i,j))){
                        for(int k = j+1;k < len; k++){
                            if(isValid(s.substring(j,k)) && isValid(s.substring(k))){
                                sb.setLength(0);
                                sb.append(s.substring(0,i));
                                sb.append('.');
                                sb.append(s.substring(i,j));
                                sb.append('.');
                                sb.append(s.substring(j,k));
                                sb.append('.');
                                sb.append(s.substring(k));

                                list.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }

        return list;
    }

    public boolean isValid(String str) {
        if (str.length() > 4)
            return false;

        if (str.length() > 1 && str.charAt(0) == '0')
            return false;

        if (Integer.valueOf(str) > 255)
            return false;

        return true;
    }

    public static void main(String[] args){
        Solution093 s = new Solution093();

        System.out.print(s.restoreIpAddresses("90000"));
    }
}
