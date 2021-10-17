package test;


import java.util.ArrayDeque;
import java.util.Queue;

public class P100_SameTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isSameTree(treeNode1, treeNode2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        ArrayDeque<TreeNode> que1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> que2 = new ArrayDeque<>();
        que1.addLast(p);
        que2.addLast(q);

        while (!que1.isEmpty()) {
            p = que1.removeFirst();
            q = que2.removeFirst();

            if (!check(p, q)) return false;
            if (p != null) {
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    que1.addLast(p.left);
                    que2.addLast(q.left);
                }

                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    que1.addLast(p.right);
                    que2.addLast(q.right);
                }
            }
        }
        return true;
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val;
    }
}
