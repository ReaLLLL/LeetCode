package com.leetcode.section2;

/*
* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
* Return a deep copy of the list.
* */
public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(null == head)
            return head;

        RandomListNode newHead = null;

        RandomListNode oldList = head;
        RandomListNode newList = newHead;
        RandomListNode oldNext = null;

        do{
            oldNext = oldList.next;
            newList = new RandomListNode(oldList.label);
            oldList.next = newList;
            newList.next = oldNext;

            if(null == newHead)
                newHead = newList;

            oldList = oldNext;
        }while (oldNext != null);

        oldList = head;
        while (oldList != null){
            if(oldList.random != null){
                oldList.next.random = oldList.random.next;
            }
            oldList = oldList.next.next;
        }

        oldList = head;
        newList = newHead;
        while (newList.next != null){
            oldList.next = newList.next;
            oldList = oldList.next;
            newList.next = oldList.next;
            newList = newList.next;
        }
        oldList.next = null;
        newList.next = null;

        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    public RandomListNode(int x) {
        this.label = x;
    }
}
