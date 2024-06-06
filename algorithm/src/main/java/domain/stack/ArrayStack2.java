package domain.stack;

import java.util.ArrayList;

public class ArrayStack2<E> implements Stack<E> {

    private final ArrayList<E> list;

    public ArrayStack2(int capacity) {
        list = new ArrayList<>(capacity);
    }

    public ArrayStack2() {
        this(10);
    }

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for(int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
            if(i != list.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

}
