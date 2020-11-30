package bfs.medium;

import bfs.TreeNode;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/binary-tree-right-side-view/")
@Enhance(reduce = {Stat.SPACE, Stat.TIME})
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> traverser = new LinkedList<>();

        if (root != null) traverser.offer(root);

        while (!traverser.isEmpty()) {
            TreeNode current = null;
            int currLevel = traverser.size();
            for (int i = 0; i < currLevel; i++) {
                current = traverser.poll();
                if (current.left != null) traverser.offer(current.left);
                if (current.right != null) traverser.offer(current.right);
            }
            answer.add(current.val);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
