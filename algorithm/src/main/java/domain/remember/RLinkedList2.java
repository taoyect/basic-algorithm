package domain.remember;

import java.util.Objects;

/**
 * @author ct
 * @date 2024-06-05 15:34
 */
public class RLinkedList2<E> {
    Node dummyHead;
    int size;

    public RLinkedList2() {
        dummyHead = new Node();
        size = 0;
    }

    public void add(int index, E e) {
        Node prev = dummyHead;
        for (int i = 1; i <= index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 1; i <= index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public int indexOf(E e) {
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if(Objects.equals(cur.e, e)) return i;
        }
        return -1;
    }

    public E get(int index) {
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public void set(int index, E e) {
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        RLinkedList2<Integer> linkedList = new RLinkedList2<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(0, i);
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
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
        }
    }
}
