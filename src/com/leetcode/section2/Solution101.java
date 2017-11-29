package com.leetcode.section2;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * @author alexsong
 * @version $Id: Solution101.java, v 0.1 2017年11月28日 上午10:33:33 alexsong Exp $
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(null == root)
            return true;
        else
            return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null)
            return true;

        if(n1 == null || n2 == null)
            return false;

        if(n1.val != n2.val)
            return false;

        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
}
