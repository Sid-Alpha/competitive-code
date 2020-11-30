package bfs.easy;

import bfs.Node;
import utils.info.Question;

import java.util.LinkedList;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/maximum-depth-of-n-ary-tree/")
public class MaximumDepthofNaryTree {

    public int maxDepth(Node root) {
        Queue<Node> q = new LinkedList<>();
        int depth = 0, levelCount = -1;
        if (root != null) q.add(root);

        while (!q.isEmpty()) {
            depth++;
            levelCount = q.size();
            while (levelCount-- > 0) {
                for (Node n : q.poll().children)
                    if (n != null) q.add(n);
            }
        }

        return depth;
    }

    public static void main(String[] args) {
//        MaximumDepthofNaryTree depth = new MaximumDepthofNaryTree();
    }
}
