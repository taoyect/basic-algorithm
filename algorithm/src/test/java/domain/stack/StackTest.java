package domain.stack;

import java.util.Random;

public class StackTest {
    public static void testStack(Stack<Integer> s, int count) {
        long start = System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < count; i++) {
            s.push(random.nextInt(Integer.MAX_VALUE));
        }
        long operation1End = System.nanoTime();
        while(!s.isEmpty()) s.pop();

        long operation2End = System.nanoTime();
        System.out.println(s.getClass().getSimpleName() +
                " push used：" + (operation1End - start) / 1000000000.0 + "s" +
                " pop used：" + (operation2End - operation1End) / 1000000000.0 + "s"
        );
    }

    public static void main(String[] args) {
        testStack(new ArrayStack<>(), 2000000);
        testStack(new ArrayStack2<>(), 2000000);
        testStack(new LinkedListStack2<>(), 2000000);
        testStack(new LinkedListStack<>(), 2000000);

    }
}
