package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * O(n^2)
 */
public class InsertionSort {
    /**
     * 循环不变量   arr[0...i)是有序的   arr[i...n)是无序的
     * 把 arr[i] 插入到[0, i)中合适的位置
     * order: asc
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
//            for(int j = i; j - 1 >= 0; j--) {
//                if(arr[j - 1].compareTo(arr[j]) > 0) // 或者arr[j].compareTo(arr[j - 1]) < 0
//                    swap(arr, j - 1, j);
//                else
//                    break;
//            }
            for(int j = i; j - 1 >= 0 && arr[j - 1].compareTo(arr[j]) > 0; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    /**
     * 相比于原始的插入排序，swap中的三步操作 优化成了 一步赋值操作
     */
    public static <T extends Comparable<T>> void optimizeSort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            T temp = arr[i]; //暂存，空间换时间
            int j = i;
            for(; j - 1 >= 0; j--) {
                if(arr[j - 1].compareTo(temp) > 0)
                    arr[j] = arr[j - 1]; //向后平移一个位置
                else
                    break;
            }
            arr[j] = temp;
        }
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        testOptimizeSort();
    }

    public static void testGenericArr() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        InsertionSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static void testTimeComplexity() {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize) {
            Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
            SortingHelper.testSort("InsertionSort", integers);
        }
    }

    public static void testOptimizeSort() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));

        Integer[] integers1 = Arrays.copyOf(integers, integers.length);
        System.out.println("integers1: " + Arrays.toString(integers1));
        InsertionSort.sort(integers1);
        System.out.println("integers1 sorted: " + Arrays.toString(integers1));

        Integer[] integers2 = Arrays.copyOf(integers, integers.length);
        System.out.println("integers2: " + Arrays.toString(integers2));
        InsertionSort.optimizeSort(integers2);
        System.out.println("integers2 sorted: " + Arrays.toString(integers2));
    }
}
