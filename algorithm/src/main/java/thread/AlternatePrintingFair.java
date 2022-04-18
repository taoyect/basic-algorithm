package thread;

import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrintingFair {
    static ReentrantLock lock = new ReentrantLock(true);
    static int count = 1;

    public static void print() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ":" +count++);
        lock.unlock();
    }

    public static void main(String[] args) {
        int number = 100;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count <= number) {
                    print();
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e) {
                        System.out.println("sleep error");
                    }

                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count <= number) {
                    print();
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e) {
                        System.out.println("sleep error");
                    }

                }
            }
        }).start();
    }
}
