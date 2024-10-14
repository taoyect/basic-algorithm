package domain.basic;

import utils.TestUtils;

import java.util.Objects;

/**
 * 新增、删除等增删Node的操作，用prev
 * 查询、修改e等用cur
 */
public class LinkedList<E> implements BasicRem<E> {

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        size = 0;
    }

//             Node node = new Node(e);
//             node.next = prev.next;
//             prev.next = node;
    //在链表的index(0-based)位置前添加新的元素e【非常用操作，仅练习用】
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("failed. Illegal index.");
//========================================================
// 找到i=index的prev
        Node prev = dummyHead; // i = 0 的prev
        for (int i = 1; i <= index; i++) {  //循环完后找到i=index的prev
            prev = prev.next;
        }
//========================================================
        prev.next = new Node(e, prev.next);
        size++;
    }

    //删除链表的第index(0-based)位置的元素【非常用操作，仅练习用】
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");
//========================================================
// 找到i=index的prev
        Node pre = dummyHead;
        for (int i = 1; i <= index; i++) { //找第i个元素的prev
            pre = pre.next;
        }
//========================================================
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public int indexOf(E e) {
//========================================================
// 找i=0...size-1的cur
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (Objects.equals(cur.e, e)) return i;
        }
//========================================================
        return -1;
    }

    //获取链表的第index(0-based)位置的元素【非常用操作，仅练习用】
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");
//========================================================
// 找到i=index的cur
        Node cur = dummyHead;   //current
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
//========================================================
        return cur.e;
    }

    //修改链表的第index(0-based)位置的元素为e【非常用操作，仅练习用】
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");
//========================================================
// 找到i=index的cur
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
//========================================================
        cur.e = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            res.append(cur.e);
            if (i != size - 1) {
                res.append(" -> ");
            }
        }
        return res.toString();
    }

    //===================================【其他】==================================
    public void addFirst(E e) { //在链表头添加新的元素e
        add(0, e);
    }

    public void addLast(E e) {   //在链表末尾添加新的元素e
        add(size, e);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

//    Node delNode = prev.next;
//    prev.next = delNode.next;
//    delNode.next = null;
    public void removeElement(E e) {
        Node prev = dummyHead;
//        int s = size;
        for (int i = 0; i < size;) {
            if (prev == null || prev.next == null) return;
            Node cur = prev.next;
            if (Objects.equals(cur.e, e)) {
                prev.next = cur.next;
                size--;
                return;
            } else {
                prev = cur;
                i++;
            }
        }
//  最佳实现
//        while(prev.next != null) {
//            if(Objects.equals(e, prev.next.e)) {
//                prev.next = prev.next.next;
//                size--;
//                return;
//            } else {
//                prev = prev.next;
//            }
//        }
    }

    @Override
    public void removeAllElement(E e) {
        Node prev = dummyHead;  //i=0的prev
//        int s = size;
        for (int i = 0; i < size;) {
            if(prev == null || prev.next == null) return;
            Node cur = prev.next;
            if(Objects.equals(cur.e, e)) {
                //类比动态数组，相当于i+1位置的值会挪到i的位置，所以i不用++
                prev.next = cur.next;
                size--;
            } else {
                prev = cur;
                i++;
            }
        }
//  最佳实现
//        Node prev = dummyHead;
//        while(prev.next != null) {
//            if(Objects.equals(e, prev.next.e)) {
//                prev.next = prev.next.next;
//                size--;
//            } else {
//                prev = prev.next;
//            }
//        }

        //如果没有dummyHead, 需要把头节点先单独考虑
//        Node head = dummyHead.next;
//        while(head != null && Objects.equals(e, head.e)) {
//            Node delHead = head;
//            head = head.next;
//            delHead.next = null;
//        }
//
//        if(head == null) return;    //全部都删完了
//
//        Node prev = head;
//        while(prev.next != null) {
//            if(Objects.equals(e, prev.next.e)) {
//                Node delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
//                size--;
//            } else {
//                prev = prev.next;
//            }
//        }
    }

    public static void main(String[] args) {
        TestUtils.test(new LinkedList<>());
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            next = null;
        }

        public Node() {
            this.e = null;
            next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
