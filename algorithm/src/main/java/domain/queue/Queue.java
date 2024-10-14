package domain.queue;

public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront(); // 查看队列首的元素
    int size();
    boolean isEmpty();
}
