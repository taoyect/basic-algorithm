package leecode.bitree;

public class LE_222_CompleteBT {

    public int countNodes(TreeNode root) {
        // 沿最左侧和最右侧分别计算高度
        TreeNode l = root, r = root;
        int lh = 0, rh = 0;
        while(l != null) {
            l = l.left;
            lh++;
        }
        while(r != null) {
            r = r.right;
            rh++;
        }

        // 如果左右侧计算的高度相同，则是一棵满二叉树
        if(lh == rh) {
//            return
        }
        return 0;
    }

    /**
     * 普通二叉树:递归解法
     */
    public int countNodes2(TreeNode root) {
        return root == null ? 0 : countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    /**
     * 考虑遍历
     *     int count = 0;
     *     public int countNodes1(TreeNode root) {
     *         traverse(root);
     *         return count;
     *     }
     *
     *     private void traverse(TreeNode node) {
     *         if(node == null) return;
     *         count++;
     *         traverse(node.left);
     *         traverse(node.right);
     *     }
    */
}
