package graph.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/")
@Enhance(details = "Time complexity")
public class MaxLevelSumBinaryTree {

    private static class Pair { int level; TreeNode node;
        public Pair(int i, TreeNode node) {
            this.level = i; this.node = node;
        }
    }

    public static int maxLevelSum(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        int max = 0, currentSum = 0, currentLevel = 1, currentMaxLevel = 1;
        if(root != null)
            queue.add(new Pair(1, root));
        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            if(currentLevel != node.level) {
                currentMaxLevel = (currentSum > max) ? currentLevel : currentMaxLevel;
                max = (currentSum > max) ? currentSum : max;
                currentSum = 0; currentLevel = node.level;
            }
            currentSum += node.node.val;
            if(node.node.left != null) queue.add(new Pair(node.level + 1, node.node.left));
            if(node.node.right != null) queue.add(new Pair(node.level + 1, node.node.right));
        }
        return currentMaxLevel;
    }

    public static void main(String[] args) {
        System.out.println(maxLevelSum(new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0))));
    }
}
