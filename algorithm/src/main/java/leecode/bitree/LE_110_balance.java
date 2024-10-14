package leecode.bitree;

public class LE_110_balance {
    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalance;
    }

    private int maxDepth(TreeNode node) {
        if(node == null) return 0;

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        if(Math.abs(leftDepth - rightDepth) > 1) {
            isBalance = false;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
