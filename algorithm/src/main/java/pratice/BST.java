package pratice;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;
        public Node(E e) {
            this.e = e;
        }
    }
//    private class Helper {
//        public boolean isFirstEntry;
//        public Node node;
//        public Helper(Node node, boolean isFirstEntry) {
//            this.node = node;
//            this.isFirstEntry = isFirstEntry;
//        }
//    }
    private Node root;
    @Getter
    private int size;

    public void add(E e) {
        if(e == null) return;
        root = add(root, e);
    }
    private Node add(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;

    }
    public void addNR(E e) {

    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void preOrderNR() {
        if(root == null) return;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.e + " ");
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
    }
//    public void preOrderNR2() {
//        if(root == null) return;
//        Deque<Helper> stack = new ArrayDeque<>();
//        stack.push(new Helper(root, true));
//        while(!stack.isEmpty()) {
//            Helper helper = stack.pop();
//            if(helper.node == null) continue;
//            if(helper.isFirstEntry) {
//                //左右中 -> 中右左
//                stack.push(new Helper(helper.node, false));
//                stack.push(new Helper(helper.node.right, true));
//                stack.push(new Helper(helper.node.left, true));
//            } else {
//                System.out.print(helper.node.e + " ");
//            }
//        }
//    }

    public void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    public void inOrderNR() {
        if(root == null) return;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.peek();
            while(curr.left != null) {
                curr = curr.left;
                stack.push(curr);
            }
            Node node = stack.pop();
            System.out.print(node.e + " ");

        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 6, 8, 4, 2};
        Arrays.stream(nums).forEach(bst::add);
        System.out.println(bst);
        bst.preOrderNR(); //5 3 2 4 7 6 8
    }
}
