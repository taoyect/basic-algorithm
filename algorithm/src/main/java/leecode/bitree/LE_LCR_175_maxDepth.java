package leecode.bitree;

public class LE_LCR_175_maxDepth {
    int maxDepth = 0;
    public int calculateDepth(TreeNode root) {
        traverse(root, 1);
        return maxDepth;
    }

    private void traverse(TreeNode node, int depth) {
        if(node == null) return;
        maxDepth = Math.max(maxDepth, depth);
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }
}
