package com.leetcode.section2;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution105.java, v 0.1 2017年11月29日 下午2:15:15 alexsong Exp $
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1){
            TreeNode t = new TreeNode(preorder[0]);
            return t;
        }

        return buildTree(preorder, 0 , inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preOrder, int preStart, int[] inOrder, int inStart, int inEnd){
        if(inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);
        if(inStart == inEnd)
            return root;

        int i = 0;
        for(i = inStart; i <= inEnd; i++){
            if(inOrder[i] == preOrder[preStart])
                break;
        }
        root.left = buildTree(preOrder, preStart+1, inOrder, inStart, i-1);
        root.right =buildTree(preOrder, preStart+(i-inStart+1), inOrder, i+1, inEnd);
        return root;
    }
}
