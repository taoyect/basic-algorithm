package domain.queue;

public class LoopQueue2<E> implements Queue<E> {
    private E[] arr;
    private int size;
    private int front, tail;

    @SuppressWarnings("unchecked")
    public LoopQueue2(int capacity) {
        arr = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue2() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % arr.length == front) { //如果放满了，就先扩容再放
            resize(2 * getCapacity());
        }
        arr[tail] = e;
        tail = (tail + 1) % arr.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        E ret = arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        size--;
        if(size <= (getCapacity() / 4) && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return arr[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private int getCapacity() {
        return arr.length - 1;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < size; i++)
            newArr[i] = arr[(front + i) % arr.length];
        arr = newArr;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n front [", size, getCapacity()));
        for(int i = front; i != tail; i = (i + 1) % arr.length) {
            res.append(arr[i]);
            if((i + 1) % arr.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
