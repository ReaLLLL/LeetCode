package com.leetcode.section2;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * @author alexsong
 * @version $Id: Solution149.java, v 0.1 2017年12月08日 下午11:57:57 alexsong Exp $
 */
public class Solution149 {
    public int maxPoints(Point[] points) {
        int res = 0, n = points.length;
        for (int i = 0; i < n; ++i) {
            int duplicate = 1;
            for (int j = i + 1; j < n; ++j) {
                int cnt = 0;
                long x1 = points[i].x, y1 = points[i].y;
                long x2 = points[j].x, y2 = points[j].y;
                if (x1 == x2 && y1 == y2) {++duplicate;continue;}
                for (int k = 0; k < n; ++k) {
                    int x3 = points[k].x, y3 = points[k].y;
                    if (x1*y2 + x2*y3 + x3*y1 - x3*y2 - x2*y1 - x1 * y3 == 0) {
                        ++cnt;
                    }
                }
                res = Math.max(res, cnt);
            }
            res = Math.max(res, duplicate);
        }
        return res;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
