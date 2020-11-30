package interview.easy.tree;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        levelOrderHelper(root, 0, l);
        return l;
    }

    private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> list) {
        if(node == null) return;
        if(list.size() < level + 1) list.add(new ArrayList<>());
        list.get(level).add(node.val);
        levelOrderHelper(node.left, level+1, list);
        levelOrderHelper(node.right, level+1, list);
    }

    public static void main(String[] args) {

    }
}
