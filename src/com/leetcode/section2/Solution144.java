package com.leetcode.section2;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution144.java, v 0.1 2017年12月07日 下午6:25:25 alexsong Exp $
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        this.visit(root, res);

        return res;
    }

    protected void visit(TreeNode root, List<Integer> list){
        if(root == null)
            return;

        list.add(root.val);
        visit(root.left, list);
        visit(root.right, list);
    }
}
