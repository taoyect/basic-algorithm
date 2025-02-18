package domain.tree;

import lombok.Getter;

import java.util.*;

/**
 * 1. 不包含重复元素
 *
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }
    @Getter
    private Node root;
    private int size;

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
    private Node add(Node r, E e) {
        if(r == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(r.e) < 0)
            r.left = add(r.left, e);
        else if(e.compareTo(r.e) > 0)
            r.right = add(r.right, e);
        return r;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    //看以node为根的二分搜索树中是否包含元素e, 递归
    private boolean contains(Node r, E e) {
        if(r == null) return false;
        if(e.compareTo(r.e) == 0)
            return true;
        else if(e.compareTo(r.e) < 0)
            return contains(r.left, e);
        else
            return contains(r.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }
    //前序遍历以node为根的二分搜索树，递归方式
    //访问该节点的操作在“访问左右子树”前面
    private void preOrder(Node r) {
        if(r == null) return;    //节点为null，没什么好遍历的了
        System.out.print(r.e + " ");//访问当前节点做操作
        preOrder(r.left);
        preOrder(r.right);
    }

    public void inOrder() {
        inOrder(root);
    }
    //中序遍历以r为根的二分搜索树，递归方式 【中序遍历的结果是顺序的】
    //左 --> 中 --> 右
    private void inOrder(Node r) {
        if(r == null) return;
        inOrder(r.left);
        System.out.print(r.e + " ");//访问当前节点做操作
        inOrder(r.right);
    }

    public void postOrder() {
        postOrder(root);
    }
    //后序遍历以r为根的二分搜索树，递归方式
    private void postOrder(Node r) {
        if(r == null) return;
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.e + " ");//访问当前节点做操作
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

//    public void levelOrder(Node r) {
//        if (r == null) return;
//        Queue<Node> q = new LinkedList<>();
//        q.offer(r);
//        while (!q.isEmpty()) {
//            Node cur = q.poll(); //current
//
//            System.out.print(cur.e + " "); // 访问当前节点
//
//            // 将当前节点的所有子节点加入队列
//            if (cur.left != null) q.offer(cur.left);
//            if (cur.right != null) q.offer(cur.right);
//        }
//    }

    public List<List<E>> levelOrder(Node r) {
        List<List<E>> list = new ArrayList<>();
        if(r == null) return list;
        Queue<Node> q = new LinkedList<>();
        q.offer(r);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<E> levelList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {  // 遍历当前层的所有节点
                Node cur = q.poll();
                levelList.add(cur.e);
                if(cur.left != null) q.offer(cur.left); //必须要判断null，以避免空指针异常
                if(cur.right != null) q.offer(cur.right);
            }
            list.add(levelList);
        }
        return list;
    }

    //[[2, 4, 6, 8], [3, 7], [5]]
    public List<List<E>> bottomUpLevelOrder(Node r) {
        List<List<E>> list = new ArrayList<>();
        if(r == null) return list;
        Queue<Node> q = new LinkedList<>();
        q.offer(r);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<E> levelList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {  // 遍历当前层的所有节点
                Node cur = q.poll();
                levelList.add(cur.e);
                if(cur.left != null) q.offer(cur.left); //必须要判断null，以避免空指针异常
                if(cur.right != null) q.offer(cur.right);
            }
            list.add(0, levelList);
        }
        return list;
    }

    //[[5], [7, 3], [2, 4, 6, 8]]
    public List<List<E>> zigzagLevelOrder(Node r) {
        List<List<E>> list = new ArrayList<>();
        if(r == null) return list;
        Queue<Node> q = new LinkedList<>();
        q.offer(r);
        boolean leftToRight = true; // 用于标记当前层的遍历方向
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<E> levelList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {  // 遍历当前层的所有节点
                Node cur = q.poll();
                levelList.add(cur.e);
                // 将当前节点的左右子节点加入队列
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            if(!leftToRight) {  // 如果是偶数层，则反转当前层的顺序
                Collections.reverse(levelList);
            }
            list.add(levelList);

            leftToRight = !leftToRight; // 反转遍历方向
        }
        return list;
    }

    public Node remove(Node r, E e) {
        if(r == null) return null;
        if(e.compareTo(r.e) < 0) {
            r.left = remove(r.left, e);
            return r;
        } else if(e.compareTo(r.e) > 0) {
            r.right = remove(r.right, e);
            return r;
        }
        if(r.left == null) { //待删除节点左子树为空的情况
            Node rightNode = r.right;
            r.right = null;
            size--;
            return rightNode;
        }
        if(r.right == null) { //待删除节点右子树为空的情况
            Node leftNode = r.left;
            r.left = null;
            size--;
            return leftNode;
        }
        //待删除节点左右子树均不为空的情况：用右子树最小节点顶替待删除节点的位置 (1962 Hibbard Deletion)
        Node successor = min(r.right);
        successor.right = removeMin(r.right);
        successor.left = r.left;
        r.left = null;
        r.right = null;
        return successor;
    }

    //删除以r为根的二分搜索树的最小节点，返回删除节点后新的二分搜索树的根
    public Node removeMin(Node r) {
        if(r == null) return null;
        if(r.left == null) {
            Node rightNode = r.right;
            r.right = null;
            size--;
            return rightNode;
        }
        r.left = removeMin(r.left);
        return r;
    }

    public Node removeMinNR(Node r) {
        if(r == null) return null;
        if(r.left == null) {
            Node rightNode = r.right;
            r.right = null;
            size--;
            return rightNode;
        }
        Node pre = null;
        Node root = r; //记录根节点
        while(r.left != null) {
            pre = r;
            r = r.left;
        }
        pre.left = r.right;
        r.right = null; //显式断开node.right
        return root;
    }

    //返回以r为根的二分搜索树的最小值所在的节点
    private Node min(Node r) {
        if(r.left == null) return r;
        return min(r.left);
    }
    public Node minNR(Node r) {
        while(r.left != null)
            r = r.left;
        return r;
    }

    private Node max(Node r) {
        if(r.right == null) return r;
        return max(r.right);
    }
    private Node maxNR(Node r) {
        while(r.right != null)
            r = r.right;
        return r;
    }
//    public Node remove(Node root, E e) {
//        if(root == null || e == null) return root;
//        if(root.e == e) {
//            //better: Node temp = root.right; root.right = null; return temp; size--
//            if(root.left == null) return root.right;
//            if(root.right == null) return root.left;
//            Node min = getMin(root.right); //找右子树的最小节点来替换root
//            root.e = min.e;
//            root.right = remove(root.right, min.e);
//        } else if(e.compareTo(root.e) < 0) {
//            root.left = remove(root.left, e);
//        } else {
//            root.right = remove(root.right, e);
//        }
//        return root;
//    }

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
    private Node addNR(Node r, E e) {
        if(r == null) {
            size++;
            return new Node(e);
        }
        Node current = r;
        while (true) {
            if (e.compareTo(current.e) < 0) {
                if (current.left == null) { current.left = new Node(e); size++; return r; } // 插入到左子树
                current = current.left; // 向左子树继续查找
            } else if (e.compareTo(current.e) > 0) {
                if (current.right == null) { current.right = new Node(e); size++; return r; } // 插入到右子树
                current = current.right; // 向右子树继续查找
            } else {
                return r;  // 如果元素相等，直接返回，不做任何插入
            }
        }
    }

    //前序遍历以node为根的二分搜索树，非递归方式
    public void preOrderNR() {
        if(root == null) return;
        Deque<Node> stack = new ArrayDeque<>();
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
        Deque<Node> stack = new ArrayDeque<>();
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
    public E min() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return min(root).e;
    }

    public E max() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return max(root).e;
    }

    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin() {
        E ret = min();
        root = removeMin(root);
        return ret;
    }

    public E removeMax() {
        E ret = max();
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
