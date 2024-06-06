package domain.stack;

import domain.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> arr;

    public ArrayStack(int capacity) {
        arr = new Array<>(capacity);
    }
    public ArrayStack() {
        arr = new Array<>();
    }

    @Override
    public void push(E e) {
        arr.addLast(e);
    }

    @Override
    public E pop() {
        return arr.removeLast();
    }

    @Override
    public E peek() {
        return arr.get(arr.size() - 1);
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for(int i = 0; i < arr.size(); i++) {
            res.append(arr.get(i));
            if(i != arr.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

}
