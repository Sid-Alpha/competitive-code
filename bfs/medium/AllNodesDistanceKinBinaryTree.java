package bfs.medium;

import bfs.TreeNode;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/")
@Enhance(reduce = {Stat.TIME, Stat.SPACE})
public class AllNodesDistanceKinBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, Integer> nodeToDistMap = new HashMap<>();
        nodeToDistMap.put(target.val, 0);
        computeDists(root, target, nodeToDistMap);
        List<Integer> answer = new LinkedList<>();
        Queue<TreeNode> traverser = new LinkedList<>();
        traverser.offer(root);

        while (!traverser.isEmpty()) {
            TreeNode curr = traverser.poll(), left = curr.left, right = curr.right;
            int currDist = nodeToDistMap.get(curr.val);
            if (left != null) {
                if (!nodeToDistMap.containsKey(left.val)) {
                    nodeToDistMap.put(left.val, currDist+1);
                    if (currDist + 1 == K)
                        answer.add(left.val);
                }
                else if (nodeToDistMap.get(left.val) == K) answer.add(left.val);
                traverser.offer(left);
            }

            if (right != null) {
                if (!nodeToDistMap.containsKey(right.val)) {
                    nodeToDistMap.put(right.val, currDist+1);
                    if (currDist + 1 == K)
                        answer.add(right.val);
                }
                else if (nodeToDistMap.get(right.val) == K) answer.add(right.val);
                traverser.offer(right);
            }
        }

        if (nodeToDistMap.get(root.val) == K) answer.add(root.val);
        return answer;
    }

    private int computeDists(TreeNode currNode, TreeNode target, Map<Integer, Integer> nodeToDistMap) {
        if (currNode == null) return -1;
        if (currNode.val == target.val) return 0;
        int L = computeDists(currNode.left, target, nodeToDistMap), R = computeDists(currNode.right, target, nodeToDistMap);
        if (L != -1) {
            nodeToDistMap.put(currNode.val, L + 1);
            return L+1;
        }
        else if (R != -1) {
            nodeToDistMap.put(currNode.val, R + 1);
            return R+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(2)), null);
        AllNodesDistanceKinBinaryTree allNodesDistanceKinBinaryTree = new AllNodesDistanceKinBinaryTree();
        System.out.println(allNodesDistanceKinBinaryTree.distanceK(root, new TreeNode(2), 1));
    }
}
