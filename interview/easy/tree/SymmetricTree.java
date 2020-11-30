package interview.easy.tree;

import utils.info.Enhance;
import utils.tree.TreeNode;

@Enhance(details = "Iterative solution")
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode leftSide, TreeNode rightSide) {
        if(leftSide == null && rightSide == null) return true;

        return leftSide != null && rightSide != null && leftSide.val == rightSide.val &&
            isSymmetricHelper(leftSide.left, rightSide.right) &&
                isSymmetricHelper(leftSide.right, rightSide.left);
    }

    public static void main(String[] args) {
        System.out.println(new SymmetricTree().isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(2))));
        System.out.println(new SymmetricTree().isSymmetric(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(2, null, new TreeNode(4)))));
        System.out.println(new SymmetricTree().isSymmetric(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(2, null, null))));
    }
}
