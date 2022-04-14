package domain.stack;

import java.util.ArrayList;

public class ArrayStack2<E> implements Stack<E> {

    private final ArrayList<E> arrayList;

    public ArrayStack2(int capacity) {
        arrayList = new ArrayList<>(capacity);
    }

    public ArrayStack2() {
        this(10);
    }

    @Override
    public int getSize() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public void push(E e) {
        arrayList.add(e);
    }

    @Override
    public E pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    @Override
    public E peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for(int i = 0; i < arrayList.size(); i++) {
            res.append(arrayList.get(i));
            if(i != arrayList.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack2<Integer> stack = new ArrayStack2<>();
        for(int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
    }
}
