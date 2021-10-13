package BinarySearchTree;

public class P98_ValidBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long lowerBound, long upperBound) {
        if (node == null) {
            return true;
        }
        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }
        return isValidBST(node.left, lowerBound, node.val)
                && isValidBST(node.right, node.val, upperBound);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
