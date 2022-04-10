package search;

import utils.ArrayGenerator;

import java.util.Objects;

/**
 * 泛型： 不可以是基本数据类型，只能应用于引用类型
 * byte, short, int, long, float, double, char, boolean
 * Byte, Short, Integer, Long, Float, Double, Character, Boolean
 */
public class LinearSearch {

    /**
     * 泛型标记<T> 应放置在方法的返回类型前
     * static 可以放置在泛型标记前的任意位置
     */
   public static <T> int search(T[] arr, T target) {
        for(int i = 0; i < arr.length; i++) {
            if(Objects.equals(arr[i], target)) {
                return i;
            }
        }
        return -1;
   }

    public static void main(String[] args) {
//        Integer[] arr = new Integer[] {24, 18, 12, 9, 16, 66, 32, 4};
//        System.out.println(LinearSearch.search(arr, 16));
        int[] dataSize = {1000000, 10000000};
        for(int n : dataSize) {
            Integer[] testArr = ArrayGenerator.generateOrderedArray(n);
            long start = System.nanoTime();
            int runs = 100;
            for(int i = 0; i < runs; i++) {
                int search = LinearSearch.search(testArr, n);
            }
            long end = System.nanoTime();
            double usedTime = (end - start) / 1000000000.0;
            System.out.printf("规模n: %s, 循环次数runs: %s, 用时usedTime(秒): %s%n", n, runs, usedTime);
        }

    }
}
