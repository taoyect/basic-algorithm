package domain.remember;


import domain.queue.Queue;

public class RLoopQueue<E> implements Queue<E> {
   E[] arr;
   int size, front, tail;

   @SuppressWarnings("unchecked")
   public RLoopQueue(int capacity) {
       arr = (E[]) new Object[capacity];
       size = front = tail = 0;
   }

   public RLoopQueue() {
       this(10);
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
    public void enqueue(E e) {
        if(size >= arr.length) {
            resize(arr.length * 2);
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
        E temp = arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        size--;

        if(size <= arr.length / 4 && arr.length / 2 != 0) {
            resize(arr.length / 2);
        }
        return temp;
    }

    @Override
    public E getFront() {
        return arr[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, arr.length));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(arr[(front + i) % arr.length]);
            if (i != size - 1) res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        RLoopQueue<Integer> queue = new RLoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                System.out.println("queue.dequeue:" + queue.dequeue());
                System.out.println(queue);
            }
        }
    }
}
