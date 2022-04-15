package utils;

import domain.Student;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {}

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个长度为n的随机Integer数组，每个数字的范围为[0, bound)
     */
    public static Integer[] generateRandomIntegerArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
    public static int[] generateRandomIntArray(int n, int bound) {
        int[] arr = new int[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        return arr;
    }

    public static Student[] genetateRandomStudentArray(int n, int bound) {
        Student[] students = new Student[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            students[i] = Student.builder().name("s"+i).score(random.nextInt(bound)).build();
        }
        return students;
    }

}
