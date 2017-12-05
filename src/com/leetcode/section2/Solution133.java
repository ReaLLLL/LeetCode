package com.leetcode.section2;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors
 *
 * @author alexsong
 * @version $Id: Solution133.java, v 0.1 2017年12月05日 下午11:09:09 alexsong Exp $
 */
public class Solution133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(null == node)
            return null;

        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        stack.push(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node,newNode);
        while(!stack.isEmpty())
        {
            UndirectedGraphNode top = stack.pop();
            for(int i=0;i<top.neighbors.size();i++)
            {
                if(!map.containsKey(top.neighbors.get(i)))
                {
                    newNode = new UndirectedGraphNode(top.neighbors.get(i).label);
                    map.put(top.neighbors.get(i),newNode);
                    stack.push(top.neighbors.get(i));
                }
                map.get(top).neighbors.add(map.get(top.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
