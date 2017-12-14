package com.leetcode.section1;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * @author alexsong
 * @version $Id: Solution100.java, v 0.1 2017年12月14日 下午9:37:37 alexsong Exp $
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if((p == null && q != null) || (q == null && p != null))
            return false;

        return p.val==q.val? (isSameTree(p.left,q.left) && isSameTree(p.right, q.right)) : false;
    }
}
