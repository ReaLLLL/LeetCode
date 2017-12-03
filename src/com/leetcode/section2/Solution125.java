package com.leetcode.section2;

/*
 *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 */

public class Solution125 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if(len == 0)
            return true;

        char[] arr = s.toCharArray();

        int i = 0, j = len-1;
        while(i<=j){
            if(!Character.isLetterOrDigit(arr[i]))
                i++;
            else if(!Character.isLetterOrDigit(arr[j]))
                j--;
            else{
                if(Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
