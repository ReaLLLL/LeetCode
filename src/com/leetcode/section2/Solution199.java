package com.leetcode.section2;

import java.util.*;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * @author alexsong
 * @version $Id: Solution199.java, v 0.1 2017年12月13日 下午11:05:05 alexsong Exp $
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root == null)
            return  res;

        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        list1.add(root);

        while(list1.size() > 0){
            res.add(list1.get(list1.size()-1).val);
            while (list1.size()>0){
                TreeNode t = list1.remove(0);
                if(t.left != null)
                    list2.add(t.left);
                if(t.right != null)
                    list2.add(t.right);
            }

            if(list2.size() > 0){
                res.add(list2.get(list2.size()-1).val);
            }

            while (list2.size()>0){
                TreeNode t = list2.remove(0);
                if(t.left != null)
                    list1.add(t.left);
                if(t.right != null)
                    list1.add(t.right);
            }
        }

        return res;
    }
}
