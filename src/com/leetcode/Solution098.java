package com.leetcode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * @author alexsong
 * @version $Id: Solution098.java, v 0.1 2017年11月25日 下午11:16:16 alexsong Exp $
 */
public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, long mn, long mx) {
        if (null == root) return true;
        if (root.val <= mn || root.val >= mx) return false;
        return isValidBST(root.left, mn, root.val) && isValidBST(root.right, root.val, mx);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
