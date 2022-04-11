package domain.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];//此处把data数组中front的元素，放到了newData的0的位置
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front)
            resize(2 * getCapacity());
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size <= getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n front [", size, getCapacity()));
        for(int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println("i:" + i + ", " + queue);
            if(i % 3 == 2) {
                System.out.println("queue.dequeue:" + queue.dequeue());
                System.out.println(queue);
            }
        }
    }
}
