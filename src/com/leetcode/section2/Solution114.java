package com.leetcode.section2;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * @author alexsong
 * @version $Id: Solution114.java, v 0.1 2017年11月30日 下午3:52:52 alexsong Exp $
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if(null == root)
            return;

        if(null != root.left){
            TreeNode rightLeaf = root.left;
            while (rightLeaf.right != null) rightLeaf = rightLeaf.right;
            rightLeaf.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        flatten(root.right);
    }
}