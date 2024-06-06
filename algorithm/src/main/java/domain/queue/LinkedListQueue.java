package domain.queue;

public class LinkedListQueue<E> implements Queue<E> {

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
    }

    @Override
    public void enqueue(E e) {
        if(tail == null) { //tail为空时, head肯定也为空
            head = tail = new Node(e);
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        retNode.next = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d\n", size));
        res.append("front [ ");
        Node cur = head;
        while(cur != null) {
            res.append(cur.e).append(" ");
            cur = cur.next;
        }
        res.append("] tail");
        return res.toString();
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
