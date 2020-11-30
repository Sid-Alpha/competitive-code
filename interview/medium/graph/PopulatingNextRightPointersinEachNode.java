package interview.medium.graph;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

@Question(
        url = "https://leetcode.com/explore/featured/card/top-interview-questions-medium/108/trees-and-graphs/789/",
        details = "Constant space complexity"
)
@Enhance(complexity = {Stat.SPACE, Stat.TIME}, details = "Don't use recursion")
public class PopulatingNextRightPointersinEachNode {

    public static Node connect(Node root) {
        if(root != null) connectionHelper(root.left, root.right);
        return root;
    }

    private static void connectionHelper(Node node1, Node node2) {
        if(node1 == null || node2 == null) return;
        node1.next = node2;
        connectionHelper(node1.left, node1.right);
        connectionHelper(node1.right, node2.left);
        connectionHelper(node2.left, node2.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
