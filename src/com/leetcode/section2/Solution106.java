package com.leetcode.section2;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * @author alexsong
 * @version $Id: Solution106.java, v 0.1 2017年11月29日 下午2:54:54 alexsong Exp $
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 1){
            TreeNode t = new TreeNode(postorder[0]);
            return t;
        }

        return buildTree(postorder, postorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] postOrder, int postEnd, int[] inOrder, int inStart, int inEnd){
        if(inStart > inEnd || postEnd <0)
            return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);
        if(inStart == inEnd)
            return root;

        int i = 0;
        for(i = inStart; i <= inEnd; i++){
            if(inOrder[i] == postOrder[postEnd])
                break;
        }
        root.left = buildTree(postOrder, postEnd-(inEnd-i+1), inOrder, inStart, i-1);
        root.right =buildTree(postOrder, postEnd-1, inOrder, i+1, inEnd);
        return root;
    }
}
