package domain.remember;

import domain.Array;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ct
 * @date 2024-06-05 14:59
 */
public class RArray<E> {
    E[] arr;
    int size;

    @SuppressWarnings("unchecked")
    public RArray(int capacity) {
        arr = (E[]) new Object[capacity];
        size = 0;
    }

    public RArray() {
        this(10);
    }

    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("size:%s, index:%s", size, index));
        }
        if(size >= arr.length) {
            resize(2 * arr.length);
        }
        System.arraycopy(arr, index, arr, index + 1, size - 1 - index + 1);
        arr[index] = e;
        size++;
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("size:%s, index:%s", size, index));
        }
        E tmp = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - 1 - (index + 1) + 1);

        arr[--size] = null;

        if(size <= arr.length / 4 && arr.length / 2 != 0) {
            resize(arr.length / 2);
        }

        return tmp;
    }

    private void resize(int newCapacity) {
        arr = Arrays.copyOf(arr, newCapacity);
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if(Objects.equals(e, arr[i])) return i;
        }
        return -1;
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("size:%s, index:%s", size, index));
        }
        return arr[index];
    }

    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("size:%s, index:%s", size, index));
        }
        arr[index] = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size -  1);
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public void removeElement(E e) {
        int index = indexOf(e);
        if(index < 0) return;
        remove(index);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, arr.length));
        res.append("[");
        for(int i = 0; i < size; i++) {
            if(i != size - 1)
                res.append(arr[i]).append(", ");
            else
                res.append(arr[i]).append("]\n");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        RArray<Integer> array = new RArray<>();
        for(int i = 0; i < 10; i++)
            array.addLast(i);
        System.out.println(array);
        array.remove(9);
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);
        array.removeElement(4);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);

        array.add(4, 4);
        System.out.println(array);
    }
}
