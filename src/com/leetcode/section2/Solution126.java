package com.leetcode.section2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given two words (beginWord and endWord), and a dictionary's word list,
*find all shortest transformation sequence(s) from beginWord to endWord, such that:Only one letter can be changed at a time.
* Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
*/
public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (beginWord.length() != endWord.length())
            return result;
        if (beginWord.isEmpty() || endWord.isEmpty())
            return result;
        if (wordList.size() == 0)
            return result;

        Queue<String> queue1 = new LinkedList<String>();
        Queue<String> queue2 = new LinkedList<String>();
        queue1.offer(beginWord);

        while (wordList.size() > 0 && !queue1.isEmpty()){
            while (!queue1.isEmpty()){
                String str = queue1.poll();
                for(int i = 0; i < str.length(); i++){
                    for(char j = 'a'; j<= 'z'; j++){
                        if(j==str.charAt(i))
                            continue;

                    }
                }
            }
        }
    }
}
