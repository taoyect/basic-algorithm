package domain.basic;

import domain.BasicRem;

import java.util.Arrays;
import java.util.Objects;

/**
 * 动态数组
 * capacity: 数组的容量
 * size: 数组中实际存放的元素个数
 */
public class Array<E> implements BasicRem<E> {
    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public void add(int index, E e) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if(size >= data.length) {
            resize(2 * data.length);
        }
//        for(int i = size - 1; i >= index; i--)
//            data[i + 1] = data[i];
        /**
         * If the src and dest arguments refer to the same array object,
         * then the copying is performed as
         * if the components at positions srcPos through srcPos+length-1
         * were first copied to a temporary array with length components
         * and then the contents of the temporary array were copied into positions destPos
         * through destPos+length-1 of the destination array.
         *
         * 看jdk的说明，System.arraycopy会先复制到临时数组，再复制回来，还是不用效率高
         */
        System.arraycopy(data, index, data, index + 1, (size - 1 - index) + 1);
        //(size - 1 - index) + 1  把size拉到和index一个维度，最后把index自己也算上
        data[index] = e;
        size++;
    }

    /**
     * 从数组中删除index位置的元素，并返回删除的元素
     */
    public E remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        E temp = data[index];

        int numMoved = (size - 1 - (index + 1)) + 1;
        if (numMoved > 0)
            System.arraycopy(data, index + 1, data, index, numMoved);
//        for(int i = index + 1; i < size; i++) {
//            data[i - 1] = data[i];
//        }

        data[--size] = null; // clear to let GC do its work
//        size--;
//        data[size] = null;  // loitering objects != memory leak

        /**
         * 1. addLast(E e) 和 removeLast() 本身的操作是O(1), 但因为存在扩缩容，resize(int newCapacity)的复杂度是O(n), 故
         * addLast(E e) 和 removeLast()的复杂度也是O(n)
         *
         * 2. 如果capacity = N, 则N+1次addLast触发1次resize；1次resize要copy N个元素，相当于N次addLast。故addLast的均摊复杂度
         *  = ((N+1)+N)/(N+1) = (2N+1) / (N+1) = (2(N+1) - 1) / (N+1) = 2 - 1/(N+1) --> O(1)
         *
         * 在扩缩容边界，反复调用add和remove。当扩容策略为2倍扩容，缩容策略为2倍缩容的时候，会出现复杂度震荡，
         * 因为数组存满capacity时，再增加一个元素，需要扩容，接着减少一个元素，又需要缩容。
         * 解决策略: 缩容的时候Lazy一下，比如等到实际存储元素只剩1/4时才开始缩容
         * size <= data.length / 4
         *
         * data.length / 2 != 0 指的是当newCapacity = 0时，没必要缩容了
         */
        if(size <= data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return temp;
    }


    //    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
//        E[] newData = (E[])new Object[newCapacity];
//        for(int i = 0; i < size; i++)
//            newData[i] = data[i];
//        data = newData;
        data = Arrays.copyOf(data, newCapacity);
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

    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    public void set(int index, E e) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        data[index] = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        return res.append("]").toString();
    }

    //===================================【其他】==================================
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public void removeElement(E e) {
        int index = indexOf(e); //查索引
        if(index != -1)
            remove(index); //删除对应索引位置的元素
    }

    /**
     * initial: []
     * addLast: 2
     * [2]
     * addLast: 3
     * [2, 3]
     * addLast: 4
     * [2, 3, 4]
     * addLast: 5
     * [2, 3, 4, 5]
     * addLast: 6
     * [2, 3, 4, 5, 6]
     * addLast: 7
     * [2, 3, 4, 5, 6, 7]
     * addLast: 8
     * [2, 3, 4, 5, 6, 7, 8]
     * addLast: 9
     * [2, 3, 4, 5, 6, 7, 8, 9]
     * addLast: 10
     * [2, 3, 4, 5, 6, 7, 8, 9, 10]
     * addFirst: 1
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * size: 10, isEmpty: false
     * removeFirst: 1
     * [2, 3, 4, 5, 6, 7, 8, 9, 10]
     * removeLast: 10
     * [2, 3, 4, 5, 6, 7, 8, 9]
     * remove index 2: 4
     * [2, 3, 5, 6, 7, 8, 9]
     * get index 2: 5
     * set(2,4)
     * [2, 3, 4, 6, 7, 8, 9]
     * indexOf 6: 3
     * contains 5: false
     * removeElement 8
     * [2, 3, 4, 6, 7, 9]
     */
//    public static void main(String[] args) {
//        Array<Integer> array = new Array<>();
//        TestUtils.test(array);
//    }
    //    public E getLast() {
//        return get(size - 1);
//    }
//
//    public E getFirst() {
//        return get(0);
//    }
}
