package domain.tree;

import domain.stack.ArrayStack2;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
//            left = right = null;
        }
    }

    private Node root;
    private int size;

//    public BST() {
//        root = null;
//        size = 0;
//    }

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

    // 向二分搜索树中添加新的元素e，非递归写法
    public void add2(E e){

        // 对二分搜索树是空的情况特殊处理
        // 此时，直接让 root 指向新的节点即可
        if(root == null){
            root = new Node(e);
            size ++;
            return;
        }

        // 用 p 来跟踪待插入节点的上一个节点
        // p 的作用相当于链表插入节点时，pre 的作用
        Node p = root;
        while(p != null){

            // 如果待插入的值小于当前 p 节点的值
            // 说明新插入的值要放在 p 的左子树
            if(e.compareTo(p.e) < 0){
                // 如果 p 的左子树为空，则在 p.left 上放入新的节点
                if(p.left == null){
                    p.left = new Node(e);
                    size ++;
                    return; // 注意这里直接 return
                }

                // 否则 p = p.left
                p = p.left;
            }
            // 如果待插入的值大于当前 p 节点的值
            // 说明新插入的值要放在 p 的右子树
            else if(e.compareTo(p.e) > 0){
                // 如果 p 的右子树为空，则在 p.right 上放入新的节点
                if(p.right == null){
                    p.right = new Node(e);
                    size ++;
                    return; // 注意这里直接 return
                }

                // 否则 p = p.right
                p = p.right;
            }
            // 如果待插入的值等于当前 p 节点的值，说明二分搜索树中已经有这个值了
            // 直接 return
            else return;
        }
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

    //层序遍历，广度优先遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node current = q.remove();
            System.out.print(current.e + " ");
            if(current.left != null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
        }
    }

    public E minimum() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root);
    }

    private E minimum(Node node) {
      if(node == null) return null;
      if(node.left != null)
          return minimum(node.left);
      return node.e;
    }

    public E minimumNR() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        if(root == null) return null;
        Node current = root;
        while(current.left != null)
            current = current.left;
        return current.e;
    }

    public E maximum() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root);
    }

    private E maximum(Node node) {
        if(node == null) return null;
        if(node.right != null)
            return maximum(node.right);
        return node.e;
    }

    public E maximumNR() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        if(root == null) return null;
        Node current = root;
        while(current.right != null)
            current = current.right;
        return current.e;
    }

    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    //删除以node为根的二分搜索树的最小节点，返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if(node == null) return null;
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if(node == null) return null;
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
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
