package bfs.medium;

import bfs.Node;
import utils.info.Question;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/n-ary-tree-level-order-traversal/")
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) q.add(root);
        List<List<Integer>> answer = new LinkedList<>();

        while (!q.isEmpty()) {
            List<Integer> subAnswer = new LinkedList<>();
            int count = q.size();

            while (count-- > 0) {
                Node curr = q.poll();
                subAnswer.add(curr.val);
                for (Node n : curr.children) if (n != null) q.add(n);
            }

            answer.add(subAnswer);
        }

        return answer;
    }

    public static void main(String[] args) {

    }

}
