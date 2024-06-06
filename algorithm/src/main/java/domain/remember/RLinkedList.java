package domain.remember;

import domain.BasicRem;
import utils.TestUtils;

import java.util.Objects;

/**
 * @author ct
 * @date 2024-06-06 11:25
 */
public class RLinkedList<E> implements BasicRem<E> {
    private Node dummyHead;
    private int size;

    public RLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        Node prev = dummyHead;
        for (int i = 1; i <= index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        Node prev = dummyHead;
        for (int i = 1; i <= index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public int indexOf(E e) {
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (Objects.equals(cur.e, e)) return i;
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

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
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

    public void removeElement(E e) {
        Node prev = dummyHead;
        for (int i = 1; i < size; i++) {
            if (prev.next != null && Objects.equals(prev.next.e, e)) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
                return;
            }
            prev = prev.next;
            if (prev == null) return;
        }
    }

    public static void main(String[] args) {
        TestUtils.test(new RLinkedList<>());
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
        }

        public Node() {
        }
    }
}
