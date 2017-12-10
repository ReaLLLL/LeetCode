package com.leetcode.section2;

/*
* Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
* flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
* */
public class Solution156 {
    public TreeNode upsideDownBinaryTree(TreeNode root){
        if(root == null || root.left == null)
            return root;

        TreeNode l = root.left;
        TreeNode r = root.right;
        TreeNode res = upsideDownBinaryTree(l);
        l.left = r;
        l.right = root;
        root.left = null;
        root.right = null;

        return res;
    }
}
