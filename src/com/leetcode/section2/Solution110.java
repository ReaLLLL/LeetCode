package com.leetcode.section2;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * @author alexsong
 * @version $Id: Solution110.java, v 0.1 2017年11月29日 下午6:27:27 alexsong Exp $
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(null == root)
            return true;

        return depth(root) != -1;
    }

    public int depth(TreeNode root){
        if(null == root)
            return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if(leftDepth == -1 || rightDepth == -1 || (leftDepth - rightDepth) >1 || (leftDepth - rightDepth) < -1 )
            return -1;
        else
            return Math.max(leftDepth +1 , rightDepth + 1);
    }
}
