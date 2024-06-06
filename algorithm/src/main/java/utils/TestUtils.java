package utils;

import domain.BasicRem;
import domain.queue.LoopQueue;
import domain.queue.Queue;
import domain.stack.Stack;

/**
 * @author ct
 * @date 2024-06-06 11:03
 */
public class TestUtils {

    /**
     * initial: front [] tail
     * enqueue:0
     * front [0] tail, size=1
     * enqueue:1
     * front [0, 1] tail, size=2
     * enqueue:2
     * front [0, 1, 2] tail, size=3
     * dequeue:0
     * front [1, 2] tail, size=2
     * enqueue:3
     * front [1, 2, 3] tail, size=3
     * enqueue:4
     * front [1, 2, 3, 4] tail, size=4
     * front: 1
     * isEmpty: false
     */
    public static void test(Queue<Integer> queue) {
        System.out.println("initial: " + queue);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println("enqueue:" + i);
            System.out.println(queue + ", size=" + queue.size());
            if (i % 3 == 2) {
                System.out.println("dequeue:" + queue.dequeue());
                System.out.println(queue + ", size=" + queue.size());
            }
        }
        System.out.println("front: " + queue.getFront());
        System.out.println("isEmpty: " + queue.isEmpty());
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
        test(arrayQueue);
    }

    /**
     * initial: Stack: [] top
     * push: 0
     * push: 1
     * push: 2
     * push: 3
     * push: 4
     * Stack: [0, 1, 2, 3, 4] top
     * pop: 4
     * after pop: Stack: [0, 1, 2, 3] top
     * peek: 3
     * after peek: Stack: [0, 1, 2, 3] top
     * isEmpty: false
     * size: 4
     * pop次数: 1, value = 3
     * stack: Stack: [0, 1, 2] top
     * pop次数: 2, value = 2
     * stack: Stack: [0, 1] top
     * pop次数: 3, value = 1
     * stack: Stack: [0] top
     * pop次数: 4, value = 0
     * stack: Stack: [] top
     * Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: -1, Size: 0
     * at domain.Array.rangeCheck(Array.java:168)
     * at domain.Array.remove(Array.java:80)
     * at domain.Array.removeLast(Array.java:119)
     * at domain.stack.ArrayStack.pop(ArrayStack.java:33)
     * at utils.TestUtils.test(TestUtils.java:60)
     * at utils.TestUtils.main(TestUtils.java:68)
     */
    public static void test(Stack<Integer> stack) {
        System.out.println("initial: " + stack);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println("push: " + i);
        }
        System.out.println(stack);
        System.out.println("pop: " + stack.pop());
        System.out.println("after pop: " + stack);
        System.out.println("peek: " + stack.peek());
        System.out.println("after peek: " + stack);
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("size: " + stack.size());
        for (int i = 0; i < 5; i++) {
            Integer pop = stack.pop();
            System.out.println("pop次数: " + (i + 1) + ", value = " + pop);
            System.out.println("stack: " + stack);
        }
    }

    /**
     * 链表
     * initial:
     * addLast: 2
     * 2
     * addLast: 3
     * 2 -> 3
     * addLast: 4
     * 2 -> 3 -> 4
     * addLast: 5
     * 2 -> 3 -> 4 -> 5
     * addLast: 6
     * 2 -> 3 -> 4 -> 5 -> 6
     * addLast: 7
     * 2 -> 3 -> 4 -> 5 -> 6 -> 7
     * addLast: 8
     * 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
     * addLast: 9
     * 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
     * addLast: 10
     * 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
     * addFirst: 1
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
     * size: 10, isEmpty: false
     * removeFirst: 1
     * 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
     * removeLast: 10
     * 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
     * remove index 2: 4
     * 2 -> 3 -> 5 -> 6 -> 7 -> 8 -> 9
     * get index 2: 5
     * set(2,4)
     * 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9
     * indexOf 6: 3
     * contains 5: false
     * removeElement 8
     * 2 -> 3 -> 4 -> 6 -> 7 -> 9
     */
    public static void test(BasicRem<Integer> b) {
        System.out.println("initial: " + b);
        for (int i = 2; i <= 10; i++) {
            b.addLast(i);
            System.out.println("addLast: " + i);
            System.out.println(b);
        }
        b.addFirst(1);
        System.out.println("addFirst: 1");
        System.out.println(b);
        System.out.println("size: " + b.size() + ", isEmpty: " + b.isEmpty());
        System.out.println("removeFirst: " + b.removeFirst());
        System.out.println(b);
        System.out.println("removeLast: " + b.removeLast());
        System.out.println(b);
        System.out.println("remove index 2: " + b.remove(2));
        System.out.println(b);
        System.out.println("get index 2: " + b.get(2));
        System.out.println("set(2,4)");
        b.set(2, 4);
        System.out.println(b);
        System.out.println("indexOf 6: " + b.indexOf(6));
        System.out.println("contains 5: " + b.contains(5));
        System.out.println("removeElement 8");
        b.removeElement(8);
        System.out.println(b);
    }

}
