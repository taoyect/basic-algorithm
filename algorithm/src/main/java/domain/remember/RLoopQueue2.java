package domain.remember;

import domain.queue.Queue;

/**
 * @author ct
 * @date 2024-06-06 14:00
 */
public class RLoopQueue2<E> implements Queue<E> {
    E[] arr;
    int front,tail;
    int size;

    @SuppressWarnings("unchecked")
    public RLoopQueue2(int capacity) {
        arr = (E[]) new Object[capacity];
        front = tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(size > arr.length) {
            resize(2 * arr.length);
        }
        arr[tail] = e;
        tail = (tail + 1) % arr.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        }
        arr = newArr;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("queue is empty!");
        }
        E tmp = arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        size--;

        if(size <= arr.length / 4 && arr.length / 2 != 0) {
            resize(arr.length / 2);
        }
        return tmp;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("queue is empty!");
        }
        return arr[front];
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
        StringBuilder res = new StringBuilder("front [");
        for (int i = 0; i < size; i++) {
            res.append(arr[(front + i) % arr.length]);
            if(i != size - 1) {
                res.append(",");
            }
        }
        return res.append("] tail").toString();
    }
}
