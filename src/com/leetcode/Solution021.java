package com.leetcode;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Solution021.java, v 0.1 2017年11月22日 下午6:04:04 alexsong Exp $
 */
public class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l2)
            return l1;
        else if(l1 == null)
            return mergeTwoLists(l2, l1);
        else{
            if(l1.val<=l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
