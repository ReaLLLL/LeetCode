package com.leetcode.section2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * @author alexsong
 * @version $Id: Solution107.java, v 0.1 2017年11月29日 下午4:18:18 alexsong Exp $
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            resultList.add(0, res1);

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
                resultList.add(0, res2);
        }

        return resultList;
    }
}
