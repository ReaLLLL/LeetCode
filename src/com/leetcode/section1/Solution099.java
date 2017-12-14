package com.leetcode.section1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * @author alexsong
 * @version $Id: Solution100.java, v 0.1 2017年12月14日 下午9:37:37 alexsong Exp $
 */
public class Solution099 {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();

        midTravesal(root, nodeList, list);
        Collections.sort(list);
        for(int i = 0; i< list.size(); i++){
            nodeList.get(i).val = list.get(i);
        }
    }

    protected void midTravesal(TreeNode root, List<TreeNode> nodeList, List<Integer> list){
        if(root == null)
            return;

        midTravesal(root.left, nodeList, list);
        list.add(root.val);
        nodeList.add(root);
        midTravesal(root.right, nodeList, list);
    }

    protected void morrisTravesal(TreeNode root){

    }
}
