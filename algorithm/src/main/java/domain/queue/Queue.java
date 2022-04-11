package domain.queue;

public interface Queue<E> {
    void enqueue(E e);
    E dequeue();

    /**
     * 查看队列首的元素
     */
    E getFront();
    int getSize();
    boolean isEmpty();
}
