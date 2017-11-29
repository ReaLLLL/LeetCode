package com.leetcode.section2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * @author alexsong
 * @version $Id: Solution103.java, v 0.1 2017年11月28日 下午6:11:11 alexsong Exp $
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Queue<TreeNode> nodeQueue=new LinkedList<TreeNode>();
        boolean flag=true;
        if(null==root){
            return result;
        }
        nodeQueue.offer(root);
        while(0!=nodeQueue.size()){
            int size=nodeQueue.size();
            List level=new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                root=nodeQueue.remove();
                if(null!=root.left){
                    nodeQueue.offer(root.left);
                }
                if(null!=root.right){
                    nodeQueue.offer(root.right);
                }
                if(flag){
                    level.add(root.val);
                }else{
                    level.add(0,root.val);
                }
            }
            flag=!flag;
            result.add(level);
        }
        return result;
    }
}
