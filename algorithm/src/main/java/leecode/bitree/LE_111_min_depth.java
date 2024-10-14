package leecode.bitree;

public class LE_111_min_depth {

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null) {
            minDepth = 0;
        }
        traverse(root, 1);
        return minDepth;
    }

    private void traverse(TreeNode node, int depth) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, depth);
            return;
        }

        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }

}
