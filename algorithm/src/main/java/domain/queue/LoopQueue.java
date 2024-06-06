package domain.queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] arr;
    private int front, tail;
    private int size;

    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        arr = (E[]) new Object[capacity]; // 由于不浪费空间, data静态数组的大小是capacity，而非capacity + 1
        front = tail = size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if (size >= arr.length)
            resize(arr.length * 2);
        arr[tail] = e;
        tail = (tail + 1) % arr.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        size--;
        if (size <= arr.length / 4 && arr.length / 2 != 0)
            resize(arr.length / 2);
        return ret;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newArr[i] = arr[(i + front) % arr.length];
        arr = newArr;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
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
        StringBuilder res = new StringBuilder();
//        res.append(String.format("Queue: size = %d , capacity = %d\n", size, arr.length));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(arr[(front + i) % arr.length]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
