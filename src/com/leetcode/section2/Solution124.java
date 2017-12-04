package com.leetcode.section2;

import java.util.ArrayList;

/**
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * @author alexsong
 * @version $Id: Solution124.java, v 0.1 2017年12月02日 下午6:13:13 alexsong Exp $
 */
public class Solution124 {
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(Integer.MIN_VALUE);
        helper(root,res);
        return res.get(0);
    }
    private int helper(TreeNode root, ArrayList<Integer> res)
    {
        if(root == null)
            return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int cur = root.val + (left>0?left:0)+(right>0?right:0);
        if(cur>res.get(0))
            res.set(0,cur);
        return root.val+Math.max(left, Math.max(right,0));
    }
}
