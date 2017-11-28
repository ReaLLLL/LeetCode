package com.leetcode.section2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @author alexsong
 * @version $Id: Solution102.java, v 0.1 2017年11月28日 下午5:44:44 alexsong Exp $
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(null == root)
            return resultList;

        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();

        list1.offer(root);
        while(list1.size()>0){
            List<Integer> res1 = new ArrayList<Integer>();
            while(list1.size()>0){
                TreeNode t = list1.poll();
                if(t.left != null)
                    list2.offer(t.left);
                if(t.right != null)
                    list2.offer(t.right);
                res1.add(t.val);
            }
            resultList.add(res1);

            List<Integer> res2 = new ArrayList<Integer>();
            while(list2.size()>0){
                TreeNode t = list2.poll();
                if(t.left != null)
                    list1.offer(t.left);
                if(t.right != null)
                    list1.offer(t.right);
                res2.add(t.val);
            }
            if (res2.size()>0)
                resultList.add(res2);
        }

        return resultList;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}