package examples;

import java.util.*;

public class PreOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root!=null) stack.add(root);

        while(!stack.isEmpty()) {
            Node node= stack.pop();
            list.add(node.val);
            ListIterator<Node> li = node.children.listIterator(node.children.size());
            while(li.hasPrevious()) stack.push(li.previous());
        }

        return list;
    }

    public List<Integer> postOrder(Node root){
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();

        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    void testMethod() {

    }

}
