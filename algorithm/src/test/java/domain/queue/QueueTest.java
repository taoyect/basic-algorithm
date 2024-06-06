package domain.queue;

import domain.remember.RLoopQueue;

import java.util.Random;

public class QueueTest {
    public static void testQueue(Queue<Integer> q, int count) {
        long start = System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < count; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        long enqueueEnd = System.nanoTime();
        while(!q.isEmpty()) q.dequeue();

        long dequeueEnd = System.nanoTime();
        System.out.println(q.getClass().getSimpleName() +
                " enqueue used：" + (enqueueEnd - start) / 1000000000.0 + "s" +
                " dequeue used：" + (dequeueEnd - enqueueEnd) / 1000000000.0 + "s"
        );
    }

    public static void main(String[] args) {
//        testQueue(new ArrayQueue<>(), 200000);
//        testQueue(new LoopQueue2<>(), 200000);
        testQueue(new RLoopQueue<>(), 200000);
        testQueue(new LinkedListQueue<>(), 200000);

    }
}
