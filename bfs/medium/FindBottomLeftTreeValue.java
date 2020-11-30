package bfs.medium;

import bfs.TreeNode;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.LinkedList;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/find-bottom-left-tree-value/")
@Enhance(reduce = { Stat.SPACE, Stat.TIME })
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        int answer = 0;
        while (!q.isEmpty()) {
            int d = q.size();
            answer = q.peek().val;
            while (d-- > 0) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return answer;
    }

}
