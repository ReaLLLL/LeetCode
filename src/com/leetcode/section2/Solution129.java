package com.leetcode.section2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * @author alexsong
 * @version $Id: Solution129.java, v 0.1 2017年12月04日 下午11:51:51 alexsong Exp $
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return this.helper(root, 0);
    }

    private int helper(TreeNode root, int sum)
    {
        if(root == null)
            return 0;
        if(root.left==null && root.right==null)
            return sum*10+root.val;
        return helper(root.left,sum*10+root.val)+helper(root.right,sum*10+root.val);
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        Solution129 s = new Solution129();
        System.out.print(s.sumNumbers(node1));
    }
}
