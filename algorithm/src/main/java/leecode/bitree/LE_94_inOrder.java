package leecode.bitree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LE_94_inOrder {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverseNR(root);
        return list;
    }

    private void traverse(TreeNode node) {
        if(node == null) return;
        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }

    public void traverseNR(TreeNode node) {
        if(node == null) return;
        Deque<leecode.bitree.Helper> stack = new ArrayDeque<>();
        stack.push(new leecode.bitree.Helper(node, true));
        while(!stack.isEmpty()) {
            leecode.bitree.Helper helper = stack.pop();
            if(helper.node == null) continue;
            if(helper.isFirstEntry) {
                //左中右->右中左
                stack.push(new leecode.bitree.Helper(helper.node.right, true));
                stack.push(new leecode.bitree.Helper(helper.node, false));
                stack.push(new Helper(helper.node.left, true));
            } else {
                list.add(helper.node.val);
            }
        }
    }

}
