package pratice;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Helper {
    public int level;
    public boolean isFirstEntry;
    public TreeNode node;

    public Helper(TreeNode node, int level, boolean isFirstEntry) {
        this.node = node;
        this.level = level;
        this.isFirstEntry = isFirstEntry;
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
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }



    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static TreeNode generateTree() {
        Integer[] nums = {1,2,2,2,null, 2};
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(nums));
        TreeNode root = new TreeNode(list.get(0));
        root.left = new TreeNode(list.get(1));
        root.right = new TreeNode(list.get(2));
        root.left.left = new TreeNode(list.get(3));
        root.right.left = new TreeNode(list.get(5));
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();
        System.out.println();
    }


}
