package domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 动态数组
 * capacity: 数组的容量
 * size: 数组中实际存放的元素个数
 */
public class Array<E> {
    private E[] data;

    @Getter
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    @SuppressWarnings("unchecked")
    public void resize(int newCapacity) {
//        E[] newData = (E[])new Object[newCapacity];
//        for(int i = 0; i < size; i++)
//            newData[i] = data[i];
//        data = newData;
       data = Arrays.copyOf(data, newCapacity);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        rangeCheckForAdd(index);
        if(size >= data.length) {
            resize(2 * data.length);
        }
//        for(int i = size - 1; i >= index; i--)
//            data[i + 1] = data[i];
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    public E get(int index) {
        rangeCheckForAdd(index);
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        rangeCheckForAdd(index);
        data[index] = e;
    }

    public boolean contains(E e) {
        for(int i = 0; i < size; i++) {
            if(Objects.equals(data[i], e))
                return true;
        }
        return false;
    }

    /**
     * 查找中元素e所在的索引，不存在则返回-1
     */
    public int indexOf(E e) {
        for(int i = 0; i < size; i++) {
            if(Objects.equals(data[i], e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，并返回删除的元素
     */
    public E remove(int index) {
        rangeCheckForAdd(index);
        E temp = data[index];
        System.arraycopy(data, index + 1, data, index, size - (index + 1));
//        for(int i = index + 1; i < size; i++) {
//            data[i - 1] = data[i];
//        }
        size--;
        data[size] = null;  // loitering objects != memory leak

        if(size <= data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return temp;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = indexOf(e);
        if(index != -1)
            remove(index);
    }

    public void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++) {
            if(i != size - 1)
                res.append(data[i]).append(", ");
            else
                res.append(data[i]).append("]");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for(int i = 0; i < 10; i++)
            array.addLast(i);
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
