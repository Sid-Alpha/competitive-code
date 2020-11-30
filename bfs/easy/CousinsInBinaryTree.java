package bfs.easy;

import bfs.TreeNode;
import javafx.util.Pair;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.LinkedList;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/cousins-in-binary-tree/")
@Enhance(reduce = {Stat.SPACE, Stat.TIME})
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        Pair<Integer, TreeNode> first = null, second = null;
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            int currDepth = q.size();
            while (currDepth-- > 0) {
                root = q.poll();
                if (root.left != null) {
                    q.add(root.left);
                    if (root.left.val == x) first = new Pair<>(depth, root);
                    else if (root.left.val == y) second = new Pair<>(depth, root);
                }
                if (root.right != null) {
                    q.add(root.right);
                    if (root.right.val == x) first = new Pair<>(depth, root);
                    else if (root.right.val == y) second = new Pair<>(depth, root);
                }

            }
            if (first != null && second != null) break;

        }

        return first!=null && second!=null && (first.getKey().equals(second.getKey())) && first.getValue() != second.getValue();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));
        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        System.out.println(cousinsInBinaryTree.isCousins(root, 5, 4));
    }
}
