package com.leetcode.section2;

import sun.security.x509.AttributeNameEnumeration;

import java.util.*;

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

        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        ArrayList<String> unVisited = new ArrayList<String>(wordList);

        if(unVisited.contains(beginWord))
            unVisited.remove(beginWord);

        queue1.offer(beginWord);

        if(unVisited.contains(beginWord))
            unVisited.remove(beginWord);

        while (unVisited.size() > 0 && !queue1.isEmpty()){
            while (!queue1.isEmpty()){
                String str = queue1.poll();
                for(int i = 0; i < str.length(); i++){
                    for(char j = 'a'; j<= 'z'; j++){
                        if(str.charAt(i)==j) continue;

                        StringBuilder sb=new StringBuilder(str);
                        sb.setCharAt(i, j);

                        if(unVisited.contains(sb.toString()))
                        {
                            queue2.add(sb.toString());
                            if(null == map.get(sb.toString())) {
                                Set<String> list = new HashSet<String>();
                                list.add(str);
                                map.put(sb.toString(), list);
                            }
                            else
                                map.get(sb.toString()).add(str);
                        }
                    }
                }
            }

            if(queue2.isEmpty())
                break;

            for(String s : queue2)
                unVisited.remove(s);

            queue1.addAll(queue2);
            queue2.clear();
        }

        if(map.containsKey(endWord))
            this.generatePath(map, new ArrayList<String>(), result, endWord, beginWord);

        return result;
    }

    public void generatePath(Map<String, Set<String>> map, List<String> tempPath, List<List<String>> result, String begin, String end){
        tempPath.add(0,begin);

        if(begin.equals(end)){
            List<String> ret = new ArrayList<>(tempPath);
            result.add(ret);
            return;
        }

        for(String str : map.get(begin)){
            generatePath(map, tempPath, result, str, end);
            tempPath.remove(0);
        }
    }

    public static void main(String[] args){
        List<String> dict = new ArrayList<String>();
        dict.add("ted");
        dict.add("tex");
        dict.add("red");
        dict.add("tax");
        dict.add("tad");
        dict.add("den");
        dict.add("rex");
        dict.add("pee");

        Solution126 s = new Solution126();
        System.out.print(s.findLadders("red", "tax", dict));
    }
}
