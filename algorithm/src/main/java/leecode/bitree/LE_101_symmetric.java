package leecode.bitree;

public class LE_101_symmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTree(root, root);
    }

    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }
}
