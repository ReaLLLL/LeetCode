package com.leetcode.section2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution116.java, v 0.1 2017年12月01日 上午12:04:04 alexsong Exp $
 */
public class Solution116 {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> list1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> list2 = new LinkedList<TreeLinkNode>();

        list1.offer(root);

        while(!list1.isEmpty()){
            TreeLinkNode t = list1.poll();
            while(t != null){
                if(t.left != null)
                    list2.offer(t.left);
                if(t.right != null)
                    list2.offer(t.right);
                TreeLinkNode p = list1.poll();
                t.next = p;
                t = p;
            }

            t = list2.poll();
            while(t != null){
                if(t.left != null)
                    list1.offer(t.left);
                if(t.right != null)
                    list1.offer(t.right);
                TreeLinkNode p = list2.poll();
                t.next = p;
                t = p;
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
