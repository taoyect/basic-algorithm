package domain.stack;

import java.util.LinkedList;

public class LinkedListStack2<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack2() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.pop();
    }

    @Override
    public E peek() {
        return list.peek();
    }

    @Override
    public String toString() {
        return "Stack: top " + list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
