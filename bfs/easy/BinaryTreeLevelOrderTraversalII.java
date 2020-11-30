package bfs.easy;

import bfs.TreeNode;
import jdk.nashorn.api.tree.Tree;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/binary-tree-level-order-traversal-ii/")
@Enhance(reduce = Stat.SPACE)
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root!=null) q.add(root);

        while (!q.isEmpty()) {
            int c = q.size();
            List<Integer> list = new LinkedList<>();
            while (c-- > 0) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

            answer.add(0, list);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
