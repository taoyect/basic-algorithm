package domain.basic;

import java.util.Objects;

/**
 * @author ct
 * @date 2024-06-07 9:14
 */
public class LinkedListR<E> implements BasicRem<E> {

    private Node head;
    private int size;

    @Override
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("failed. Illegal index.");
        }
        head = add(head, index, e);
        size++;
    }

    private Node add(Node h, int index, E e) {
        if(index == 0) {
            return new Node(e, h);
        }
        h.next = add(h.next, index - 1, e);
        return h;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("failed. Illegal index.");
        }
        RemoveDto dto = remove(head, index);
        head = dto.h;
        size--;
        return dto.e;
    }

    private RemoveDto remove(Node h, int index) {
        if(index == 0) {
            Node delNode = h;
            h = h.next;
            delNode.next = null;
            return new RemoveDto(h, delNode.e);
        }

        RemoveDto dto = remove(h.next, index - 1);
        h.next = dto.h;
        return new RemoveDto(h, dto.e);
    }

    @Override
    public int indexOf(E e) {
        return indexOf(head, e, 0);
    }

    private int indexOf(Node h, E e, int depth) {
        if(h == null) return -1;
        if(Objects.equals(h.e, e)) return depth;

        return indexOf(h.next, e, depth + 1);
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");

        return get(head, index);
    }

    private E get(Node h, int index) {
        if(index == 0) return h.e;

        return get(h.next, index - 1);
    }

    @Override
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("failed. Illegal index.");

        set(head, index, e);
    }

    private void set(Node h, int index, E e) {
        if(index == 0) h.e = e;
        else set(h.next, index - 1, e);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = new Node(null, head);
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            res.append(cur.e);
            if (i != size - 1) {
                res.append(" -> ");
            }
        }
        return res.toString();
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public void removeElement(E e) {
        head = removeElement(head, e);
    }

//            Node delNode = h;
//            h = delNode.next;
//            delNode.next = null;
//            return h;
    private Node removeElement(Node h, E e) {
        if(h == null) return null;
        if(Objects.equals(h.e, e)) {
            size--;
            return h.next;
        }
        h.next = removeElement(h.next, e);
        return h;
    }

    @Override
    public void removeAllElement(E e) {
        head = removeAllElement(head, e);
    }

    private Node removeAllElement(Node h, E e) {
        if(h == null) return null;
        h.next = removeAllElement(h.next, e);
        if(Objects.equals(h.e, e)) {
            h = h.next;
            size--;
        }
        return h;
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

    private class RemoveDto {
        public Node h;
        public E e;

        public RemoveDto(Node head, E e) {
            this.h = head;
            this.e = e;
        }
    }

}
