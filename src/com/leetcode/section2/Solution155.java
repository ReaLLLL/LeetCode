package com.leetcode.section2;

import java.util.Vector;

public class Solution155 {
}

class MinStack {

    /** initialize your data structure here. */
    Vector<Integer> vec;
    int minVal;
    public MinStack() {
        vec = new Vector<>();
        minVal = 0;
    }

    public void push(int x) {
        vec.add(0, x);
        if(vec.size() == 1)
            minVal = x;
        else
            minVal = Math.min(minVal,x);
    }

    public void pop() {
        int t = this.vec.remove(0);
        if(t == this.minVal){
            this.minVal = Integer.MAX_VALUE;
            for(int x : this.vec)
                this.minVal = Math.min(this.minVal, x);
        }
    }

    public int top() {
        return this.vec.get(0);
    }

    public int getMin() {
        return this.minVal;
    }
}

