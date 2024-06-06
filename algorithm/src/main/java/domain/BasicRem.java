package domain;

/**
 * @author ct
 * @date 2024-06-06 11:51
 */
public interface BasicRem<E> {
    void add(int index, E e);
    E remove(int index);
    int indexOf(E e);
    E get(int index);
    void set(int index, E e);
    int size();
    boolean isEmpty();
    String toString();

    void addFirst(E e);
    void addLast(E e);
    E removeFirst();
    E removeLast();
    boolean contains(E e);
    void removeElement(E e);

}
