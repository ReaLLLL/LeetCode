package com.leetcode.section2;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution109.java, v 0.1 2017年11月29日 下午5:43:43 alexsong Exp $
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head)
            return null;

        if (null == head.next)
            return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode last = slow;
        while (null != fast.next && null != fast.next.next) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        last.next = null;
        TreeNode cur = new TreeNode(slow.val);
        if (head != slow)
            cur.left = sortedListToBST(head);

        cur.right = sortedListToBST(fast);
        return cur;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){this.val =x;}
}
