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
    public static <T extends Comparable<T>> void rawsSort(T[] arr) {
        rawsSort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void rawsSort(T[] arr, int lo, int hi) {
        for(int i = lo; i <= hi; i++)
            for(int j = i; j - 1 >= lo && arr[j - 1].compareTo(arr[j]) > 0; j--)
                swap(arr, j, j - 1);
//            for(int j = i; j - 1 >= 0; j--) {
//                if(arr[j - 1].compareTo(arr[j]) > 0) // 或者arr[j].compareTo(arr[j - 1]) < 0
//                    swap(arr, j - 1, j);
//                else
//                    break;
//            }
    }

    /**
     * 相比于原始的插入排序，swap中的三步操作 优化成了 一步赋值操作
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        for(int i = lo; i <= hi; i++) {
            T temp = arr[i]; //暂存，空间换时间
            int j = i;
            for(; j - 1 >= lo; j--) {
                if(arr[j - 1].compareTo(temp) > 0)
                    arr[j] = arr[j - 1]; //向后平移一个位置
                else
                    break;
            }
            arr[j] = temp;
        }
    }

    /**
     * 从后往前排
     * 循环不变量   arr[0...i]是无序的   arr(i...n)是有序的
     * 把 arr[i] 插入到arr(i...n)中合适的位置
     * order: asc
     */
    public static <T extends Comparable<T>> void oppositeSort(T[] arr) {
        for(int i = arr.length - 1; i >= 0; i--)
            for(int j = i; j + 1 < arr.length && arr[j + 1].compareTo(arr[j]) < 0; j++)
                swap(arr, j, j + 1);
    }

    /**
     * 目标：arr[i]
     * order: asc
     */
    public static <T extends Comparable<T>> void oppositeOptimizeSort(T[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            T temp = arr[i];
            int j = i;
            for(; j + 1 < arr.length && arr[j + 1].compareTo(temp) < 0; j++)
                arr[j] = arr[j + 1];
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
        InsertionSort.rawsSort(integers1);
        System.out.println("integers1 sorted: " + Arrays.toString(integers1));

        Integer[] integers2 = Arrays.copyOf(integers, integers.length);
        System.out.println("integers2: " + Arrays.toString(integers2));
        InsertionSort.sort(integers2);
        System.out.println("integers2 sorted: " + Arrays.toString(integers2));
    }

    /**
     * 插入排序对于已经接近有序的数组的时间性能接近 O(n)
     * 做对比测试，对照组：选择排序
     *
     * 测试结果：
     * SelectionSort, n = 10000, 0.088569 s
     * InsertionSort, n = 10000, 0.101319 s
     *
     * SelectionSort, n = 10000, 0.056758 s
     * InsertionSort, n = 10000, 0.000078 s
     *
     * SelectionSort, n = 100000, 8.059562 s
     * InsertionSort, n = 100000, 14.194851 s
     *
     * SelectionSort, n = 100000, 5.193393 s
     * InsertionSort, n = 100000, 0.000235 s
     */
    public static void testOrderedArrSorting() {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize) {
            Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
            Integer[] integers1 = Arrays.copyOf(integers, integers.length);
            SortingHelper.testSort("SelectionSort", integers);
            SortingHelper.testSort("InsertionSort", integers1);

            Integer[] integers3 = ArrayGenerator.generateOrderedArray(n);
            Integer[] integers4 = Arrays.copyOf(integers3, integers3.length);
            SortingHelper.testSort("SelectionSort", integers3);
            SortingHelper.testSort("InsertionSort", integers4);

        }
    }

    public static void testOppositeSort() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        InsertionSort.oppositeSort(integers);
        System.out.println(Arrays.toString(integers));
    }
    public static void testOppositeOptimizeSort() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        InsertionSort.oppositeOptimizeSort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
