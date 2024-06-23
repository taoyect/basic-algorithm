package leecode.bitree;

public class LE_543_diameter {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);

        maxDiameter = Math.max(leftMax + rightMax, maxDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }
}
