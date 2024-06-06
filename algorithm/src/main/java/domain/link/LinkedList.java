package domain.link;

import lombok.Getter;

import java.util.Objects;

public class LinkedList<E> {

    private Node dummyHead;
    @Getter
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //===================================【增】================================================
    //在链表的index(0-based)位置前添加新的元素e【非常用操作，仅练习用】
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("failed. Illegal index.");
        Node prev = dummyHead; // i = 0 的prev
        for (int i = 1; i <= index; i++) {
            prev = prev.next;
        }
//             Node node = new Node(e);
//             node.next = prev.next;
//             prev.next = node;
        prev.next = new Node(e, prev.next);

        size++;
    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    //===================================【删】================================================
    //删除链表的第index(0-based)位置的元素【非常用操作，仅练习用】
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");
        Node pre = dummyHead;
        for (int i = 1; i <= index; i++) { //找第i个元素的prev
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //===================================【改】================================================
    //修改链表的第index(0-based)位置的元素为e【非常用操作，仅练习用】
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //===================================【查】================================================
    //获取链表的第index(0-based)位置的元素【非常用操作，仅练习用】
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");

        Node cur = dummyHead;   //current
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    //查找链表中是否有元素e
    public boolean contains(E e) {
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            if (Objects.equals(cur.e, e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (Objects.equals(cur.e, e)) return i;
        }
        return -1;
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

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
         linkedList.add(2, 666);
        System.out.println(linkedList);
        System.out.println("get 2: " + linkedList.get(2));
        System.out.println("indexOf 4: " + linkedList.indexOf(4));
        System.out.println("contains 888: " + linkedList.contains(888));
        linkedList.set(3, 999);
        System.out.println("indexOf 999: " + linkedList.indexOf(999));
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
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
