package com.leetcode.section2;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author alexsong
 * @version $Id: Solution111.java, v 0.1 2017年11月30日 上午12:05:05 alexsong Exp $
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if(null == root)
            return 0;

        if(root.left == null)
            return minDepth(root.right)+1;

        if(root.right == null)
            return minDepth(root.left)+1;

        return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
    }
}
