package com.leetcode.section2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * @author alexsong
 * @version $Id: Solution117.java, v 0.1 2017年12月01日 上午12:35:35 alexsong Exp $
 */
public class Solution117 {
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
