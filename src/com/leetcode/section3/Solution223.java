package com.leetcode.section3;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * @author alexsong
 * @version $Id: Solution223.java, v 0.1 2017年12月21日 下午11:13:13 alexsong Exp $
 */
public class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        return (C - A) * (D - B) + (H - F) * (G - E) - (Math.max((Math.min(G, C) - Math.max(A, E)), 0) * Math.max((Math.min(D, H) - Math.max(B, F)), 0));
    }
}
