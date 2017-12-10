package com.leetcode.section2;

/*
* Find the contiguous subarray within an array (containing at least one number) which has the largest product.
* For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution152 {
    public int maxProduct(int[] A) {
        if(A==null || A.length==0)
            return 0;
        if(A.length == 1)
            return A[0];
        int max_local = A[0];
        int min_local = A[0];
        int global = A[0];
        for(int i=1;i<A.length;i++)
        {
            int max_copy = max_local;
            max_local = Math.max(Math.max(A[i]*max_local, A[i]), A[i]*min_local);
            min_local = Math.min(Math.min(A[i]*max_copy, A[i]), A[i]*min_local);
            global = Math.max(global, max_local);
        }
        return global;
    }

    public static void main(String[] args){
        Solution152 s = new Solution152();
        //int[] A = {0,2,0,3,-2,4,-1};
        int[] A = {2,-5,-2,-4,3};

        System.out.print(s.maxProduct(A));
    }
}
