package domain.tree;

import domain.stack.ArrayStack2;
import lombok.Getter;

import java.util.*;

public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
//            left = right = null;
        }
    }
    @Getter
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
    public List<List<E>> levelOrder() {
        List<List<E>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<E> levelList = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                levelList.add(node.e);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            list.add(levelList);
        }
        return list;
    }

    public Node remove(Node root, E e) {
        if(root == null || e == null) return root;
        if(root.e == e) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            Node min = getMin(root.right); //找右子树的最小节点来替换root
            root.e = min.e;
            root.right = remove(root.right, min.e);
        } else if(e.compareTo(root.e) < 0) {
            root.left = remove(root.left, e);
        } else {
            root.right = remove(root.right, e);
        }
        return root;
    }

    public Node getMin(Node root) {
        while(root.left != null)
            root = root.left;
        return root;
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


    ///////////////[ 其他 ]////////////////////////////////////////////////
    public void addNR(E e) {
        if(root == null) { root = new Node(e);  size++; return; }
        Node p = root;
        while(p != null) {
            if(e.compareTo(p.e) < 0) {
                if(p.left == null) { p.left = new Node(e); size++; return; }
                p = p.left;
            } else if(e.compareTo(p.e) > 0){
                if(p.right == null) { p.right = new Node(e); size++; return; }
                p = p.right;
            } else {
                return;
            }
        }
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
    //层序遍历，广度优先遍历
    public void levelOrder1() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node current = q.remove();
            System.out.print(current.e + " ");
            if(current.left != null) q.add(current.left);
            if(current.right != null) q.add(current.right);
        }
    }
    public E minimum() {
        if(size == 0) throw new IllegalArgumentException("BST is empty!");
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
}
