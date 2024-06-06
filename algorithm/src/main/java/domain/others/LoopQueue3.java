package domain.others;

import domain.queue.Queue;

/**
 * 在这一版本的实现中，我们完全不使用size，只使用front和tail来完成LoopQueue的所有逻辑
 */
public class LoopQueue3<E> implements Queue<E> {

        private E[] arr;
        private int front, tail;

        @SuppressWarnings("unchecked")
        public LoopQueue3(int capacity){
            arr = (E[])new Object[capacity + 1];
            front = 0;
            tail = 0;
        }

        public LoopQueue3(){
            this(10);
        }

        public int getCapacity(){
            return arr.length - 1;
        }

        @Override
        public boolean isEmpty(){
            return front == tail;
        }

        @Override
        public int size(){
            // 注意此时getSize的逻辑:
            // 如果tail >= front，非常简单，队列中的元素个数就是tail - front
            // 如果tail < front，说明我们的循环队列"循环"起来了，此时，队列中的元素个数为：
            // tail - front + data.length
            // 画画图，看能不能理解为什么？
            //
            // 也可以理解成，此时，data中"没有元素的数组下标数目"为 front - tail,
            // 有元素个数的 就是 data.length - (front - tail) = data.length + tail - front
            return tail >= front ? tail - front : tail - front + arr.length;
        }

        @Override
        public void enqueue(E e){
            if((tail + 1) % arr.length == front)
                resize(getCapacity() * 2);
            arr[tail] = e;
            tail = (tail + 1) % arr.length;
        }

        @Override
        public E dequeue(){
            if(isEmpty())
                throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
            E ret = arr[front];
            arr[front] = null;
            front = (front + 1) % arr.length;
            if(size() <= getCapacity() / 4 && getCapacity() / 2 != 0)
                resize(getCapacity() / 2);
            return ret;
        }

        @Override
        public E getFront(){
            if(isEmpty())
                throw new IllegalArgumentException("Queue is empty.");
            return arr[front];
        }

        @SuppressWarnings("unchecked")
        private void resize(int newCapacity){
            E[] newArr = (E[])new Object[newCapacity + 1];
            int size = size();
            for(int i = 0 ; i < size; i ++)
                newArr[i] = arr[(i + front) % arr.length];
            arr = newArr;
            front = 0;
            tail = size;
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append(String.format("Queue: size = %d , capacity = %d\n", size(), getCapacity()));
            res.append("front [");
            for(int i = 0; i < size(); i++) {
                res.append(arr[(front + i) % arr.length]);
                if(i != size() - 1)
                    res.append(", ");
            }
            res.append("] tail");
            return res.toString();
        }

}
