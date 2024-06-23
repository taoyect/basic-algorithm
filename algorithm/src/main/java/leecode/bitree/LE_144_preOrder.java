package leecode.bitree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LE_144_preOrder {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverseNR(root);
        return list;
    }

    private void traverse(TreeNode node) {
        if(node == null) return;
        list.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    private void traverseNR(TreeNode node) {
        if(node == null) return;
        Deque<Helper> stack = new ArrayDeque<>();
        stack.push(new Helper(node, true));
        while(!stack.isEmpty()) {
            Helper helper = stack.pop();
            if(helper.node == null) continue;
            if(helper.isFirstEntry) {
                stack.push(new Helper(helper.node.right, true));
                stack.push(new Helper(helper.node.left, true));
                stack.push(new Helper(helper.node, false));
            } else {
                list.add(helper.node.val);
            }
        }
    }
}
