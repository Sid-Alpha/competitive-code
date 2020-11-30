package bfs.easy;

import bfs.TreeNode;
import utils.info.Question;

import java.util.LinkedList;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/minimum-depth-of-binary-tree/")
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root!=null) q.add(root);
        int d = 0, dep;
        TreeNode curr;

        while (!q.isEmpty()) {
            dep = q.size();
            d++;
            while (dep-- > 0) {
                curr = q.poll();
                if (curr.left == null && curr.right == null) return d;
                else {
                    if (curr.left!=null) q.add(curr.left);
                    if (curr.right!=null) q.add(curr.right);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
