package com.leetcode.section2;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author alexsong
 * @version $Id: Solution104.java, v 0.1 2017年11月29日 上午11:51:51 alexsong Exp $
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        return null==root? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
