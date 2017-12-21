package com.leetcode.section3;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * @author alexsong
 * @version $Id: Solution222.java, v 0.1 2017年12月21日 下午11:02:02 alexsong Exp $
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int l = getLeft(root) + 1;
        int r = getRight(root) + 1;

        if(l==r) {
            return (2<<(l-1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeft(TreeNode root) {
        int count = 0;
        while(root.left!=null) {
            root = root.left;
            ++count;
        }
        return count;
    }

    private int getRight(TreeNode root) {
        int count = 0;
        while(root.right!=null) {
            root = root.right;
            ++count;
        }
        return count;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
    }
}
