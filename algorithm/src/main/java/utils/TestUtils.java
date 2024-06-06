package utils;

import domain.BasicRem;
import domain.queue.Queue;
import domain.stack.ArrayStack;
import domain.stack.Stack;

/**
 * @author ct
 * @date 2024-06-06 11:03
 */
public class TestUtils {

    /**
     * initial queue: Queue: front [] tail
     * enqueue:0
     * Queue: front [0] tail, size=1
     * enqueue:1
     * Queue: front [0, 1] tail, size=2
     * enqueue:2
     * Queue: front [0, 1, 2] tail, size=3
     * dequeue:0
     * Queue: front [1, 2] tail, size=2
     * enqueue:3
     * Queue: front [1, 2, 3] tail, size=3
     * enqueue:4
     * Queue: front [1, 2, 3, 4] tail, size=4
     * front: 1
     * isEmpty: false
     */
    public static void test(Queue<Integer> queue) {
        System.out.println("initial queue: " + queue);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println("enqueue:" + i);
            System.out.println(queue + ", size=" + queue.getSize());
            if (i % 3 == 2) {
                System.out.println("dequeue:" + queue.dequeue());
                System.out.println(queue + ", size=" + queue.getSize());
            }
        }
        System.out.println("front: " + queue.getFront());
        System.out.println("isEmpty: " + queue.isEmpty());
    }

    /**
     * initial stack: Stack: [] top
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
        System.out.println("initial stack: " + stack);
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
        System.out.println("size: " + stack.getSize());
        for (int i = 0; i < 5; i++) {
            Integer pop = stack.pop();
            System.out.println("pop次数: " + (i + 1) + ", value = " + pop);
            System.out.println("stack: " + stack);
        }
    }

    public static void testArray(BasicRem<Integer> b) {
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

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        test(stack);
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        test(arrayQueue);
    }
}
