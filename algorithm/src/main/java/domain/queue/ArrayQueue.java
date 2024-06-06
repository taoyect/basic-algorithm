package domain.queue;

import domain.basic.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> arr;

    public ArrayQueue() {
        arr = new Array<>();
    }

    public ArrayQueue(int capacity) {
        arr = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        arr.addLast(e);
    }

    @Override
    public E dequeue() {
        return arr.removeFirst();
    }

    @Override
    public E getFront() {
        return arr.get(0);
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("front [");
        for(int i = 0; i < arr.size(); i++) {
            res.append(arr.get(i));
            if(i != arr.size() - 1) {
                res.append(", ");
            }
        }
        return res.append("] tail").toString();
    }

}
