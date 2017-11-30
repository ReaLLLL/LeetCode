package com.leetcode.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * @author alexsong
 * @version $Id: Solution113.java, v 0.1 2017年11月30日 上午12:32:32 alexsong Exp $
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(null == root)
            return resultList;
        List<Integer> list = new ArrayList<Integer>();
        helper(root, sum, resultList, list);
        return resultList;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> resultList, List<Integer> stack){
        if(null == root)
            return;

        stack.add(root.val);
        if(sum == root.val && null != root.left && null != root.right)
            resultList.add(stack);

        helper(root.left, sum-root.val, resultList, stack);
        helper(root.right, sum-root.val, resultList, stack);

        stack.remove(stack.size()-1);
    }
}
