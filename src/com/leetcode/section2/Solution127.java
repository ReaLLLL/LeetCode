package com.leetcode.section2;

import java.util.*;

/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord)
                || beginWord.length() != endWord.length())
            return 0;

        if (isOneWordDiff(beginWord, endWord))
            return 2;

        Queue<String> queue=new LinkedList<String>();
        HashMap<String,Integer> dist=new HashMap<String,Integer>();

        queue.add(beginWord);
        dist.put(beginWord, 1);

        while(!queue.isEmpty())
        {
            String head=queue.poll();

            int headDist=dist.get(head);
            //从每一个位置开始替换成a~z
            for(int i=0;i<head.length();i++)
            {
                for(char j='a';j<'z';j++)
                {
                    if(head.charAt(i)==j) continue;

                    StringBuilder sb=new StringBuilder(head);
                    sb.setCharAt(i, j);

                    if(sb.toString().equals(endWord)) return headDist+1;

                    if(wordList.contains(sb.toString())&&!dist.containsKey(sb.toString()))
                    {
                        queue.add(sb.toString());
                        dist.put(sb.toString(), headDist+1);
                    }
                }
            }
        }

        return 0;
    }
    private boolean isOneWordDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff >= 2)
                    return false;
            }
        }

        return diff == 1;
    }
}