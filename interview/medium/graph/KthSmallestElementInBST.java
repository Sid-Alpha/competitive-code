package interview.medium.graph;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.UsedHints;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Question(url = "https://leetcode.com/explore/featured/card/top-interview-questions-medium/108/trees-and-graphs/790/")
@UsedHints
@Enhance(complexity = Stat.SPACE, details = "Don't use list")
public class KthSmallestElementInBST {


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverSeAndAdd(root, list, k);
        return list.get(k);
    }

    void traverSeAndAdd(TreeNode node, List<Integer> list, int k) {
        if(node == null || list.size() >= k) return;
        traverSeAndAdd(node.left, list, k);
        list.add(node.val);
        traverSeAndAdd(node.right, list, k);
    }


}
