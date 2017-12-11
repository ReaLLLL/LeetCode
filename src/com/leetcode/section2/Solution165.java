package com.leetcode.section2;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * @author alexsong
 * @version $Id: Solution165.java, v 0.1 2017年12月10日 下午9:28:28 alexsong Exp $
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 ==null) return 0;

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n1 = v1.length;
        int n2 = v2.length;

        int i=0;

        while(i<n1 || i<n2) {
            int x1 = i<n1 ? Integer.parseInt(v1[i]) : 0;
            int x2 = i<n2 ? Integer.parseInt(v2[i]) : 0;
            if(x1 > x2) return 1;
            else if(x1 < x2) return -1;
            else ++i;
        }

        return 0;
    }

    public static void main(String[] args){
        String v1 = "1";
        String v2 = "0";

        Solution165 s = new Solution165();

        System.out.print(s.compareVersion(v1, v2));
    }
}
