package interview.medium.graph;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;
import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/")
@Enhance(complexity = Stat.TIME)
public class ZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = new LinkedList<>();
        if(root != null) traversalHelp(root, 0, finalList);

        return finalList;
    }

    private void traversalHelp(TreeNode root, int n, List<List<Integer>> finalList) {
        if(root == null) return;
        if(finalList.size() <= n) finalList.add(new LinkedList<>());
        if(n%2 == 0) finalList.get(n).add(root.val);
        else finalList.get(n).add(0, root.val);

        traversalHelp(root.left, n+1, finalList);
        traversalHelp(root.right, n+1, finalList);
    }

    public static void main(String[] args) {

    }
}
