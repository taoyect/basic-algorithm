package domain.tree;

import domain.stack.ArrayStack2;

public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }
    //向以node为根节点的二分搜索树中插入元素e, 递归方式
    //返回插入新节点后二分搜索树的根
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

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null) return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }
    //前序遍历以node为根的二分搜索树，递归方式
    private void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.e + " ");//访问当前节点做操作
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历以node为根的二分搜索树，非递归方式
    public void preOrderNR() {
        if(root == null) return;
        ArrayStack2<Node> stack = new ArrayStack2<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.e + " ");
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }
    }

    public void inOrder() {
        inOrder(root);
    }
    //中序遍历以node为根的二分搜索树，递归方式
    private void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.e + " ");//访问当前节点做操作
        inOrder(node.right);
    }

    public void inOrderNR() {
        if(root == null) return;
        ArrayStack2<Node> stack = new ArrayStack2<>();
        Node current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.e + " ");
            current = current.right;
        }
    }

    public void postOrder() {
        postOrder(root);
    }
    //后序遍历以node为根的二分搜索树，递归方式
    private void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");//访问当前节点做操作
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null){
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left,depth + 1, res);
        generateBSTString(node.right,depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}
