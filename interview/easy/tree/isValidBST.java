package interview.easy.tree;

import utils.tree.TreeNode;

public class isValidBST {

//    public boolean isValidBST(TreeNode root) {
//        if(root == null) return true;
//        return (root.left == null || (root.val > maxOfLeftSubTree(root.left).val && isValidBST(root.left)))
//                && (root.right == null || (root.val < minOfrRightSubTree(root.right).val && isValidBST(root.right)));
//    }
//
//    public TreeNode maxOfLeftSubTree(TreeNode node) {
//        if(node == null) return node;
//        return max(maxOfLeftSubTree(node.left), maxOfLeftSubTree(node.right), node);
//    }
//
//    public TreeNode minOfrRightSubTree(TreeNode node) {
//        return min(maxOfLeftSubTree(node.left), maxOfLeftSubTree(node.right), node);
//    }
//
//    public TreeNode max(TreeNode... nodes) {
//        TreeNode max = null;
//        for(TreeNode node : nodes) {
//            if(node == null)
//                continue;
//            max = (max==null)? node : ((node.val > max.val)? node : max);
//        }
//        return max;
//    }
//
//    public TreeNode min(TreeNode... nodes) {
//        TreeNode min = null;
//        for(TreeNode node : nodes) {
//            if(node == null)
//                continue;
//            min = (min==null)? node : ((node.val < min.val)? node : min);
//        }
//        return min;
//    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTHelper(root.left, null, root) && isValidBSTHelper(root.right, root, null);
    }

    public boolean isValidBSTHelper(TreeNode root, TreeNode lB, TreeNode uB) {
        if(root == null) return true;
        if(lB != null && root.val <= lB.val) return false;
        if(uB != null && root.val >= uB.val) return false;

        return (root.left == null || isValidBSTHelper(root.left, lB, root )) &&
                (root.right == null || isValidBSTHelper(root.right, root, uB));
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(10, new TreeNode(5), new TreeNode(15, new TreeNode(6), new TreeNode(20)));
        System.out.println(new isValidBST().isValidBST(head));
    }
}
