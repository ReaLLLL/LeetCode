package com.leetcode.section2;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * @author alexsong
 * @version $Id: Solution112.java, v 0.1 2017年11月30日 上午12:18:18 alexsong Exp $
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        return false;

        if(root.val == sum && isLeaf(root))
            return true;

        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    public static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
