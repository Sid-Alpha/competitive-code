package interview.medium.graph;

import utils.info.Question;
import utils.info.Unfinished;
import utils.tree.TreeNode;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/")
@Unfinished
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    // Preorder - Root left right
    // Inorder - left Root right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        return null;
    }

    public static void main(String[] args) {

    }

}
