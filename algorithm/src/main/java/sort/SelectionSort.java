package sort;

import domain.Student;
import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * 每次选择还没处理的元素里最小的元素 （原地排序）
 * O(n^2)
 */
public class SelectionSort {
    //循环不变量   arr[0...i)是有序的；arr[i...n)是无序的
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            //选择 arr[i...n)中最小值的索引
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 泛型标记 <T extends Comparable<T>>  约束 T必须实现Comparable<T>接口
     *
     * a.compareTo(b)
     *  < 0 说明 a < b
     *  = 0 即 a == b
     *  > 0 即 a > b
     *
     *  循环不变量   arr[0...i)是有序的；arr[i...n)是无序的
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;   //选择 arr[i...n)中最小值的索引
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * //循环不变量   arr[0...i)是无序的；arr[i...n)是有序的
     * 实现 desc     e.g.  5,4,3,2,1
     */
    public static <T extends Comparable<T>> void oppositeSort(T[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            int minIndex = i;   //选择 arr[0...i)中最小值的索引
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void swap(int[] arr, int minIndex, int j) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        testOppositeSort();
    }

    public static void testIntArr() {
        int[] testArr = ArrayGenerator.generateRandomIntArray(10, 10);
        System.out.println(Arrays.toString(testArr));
        SelectionSort.sort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    public static void testGenericArr1() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        SelectionSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static void testGenericArr2() {
        Student[] students = ArrayGenerator.genetateRandomStudentArray(10, 101);
        System.out.println(Arrays.toString(students));
        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));
    }

    public static void testTimeComplexity() {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize) {
            Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
            SortingHelper.testSort("SelectionSort", integers);
        }
    }

    public static void testOppositeSort() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        SelectionSort.oppositeSort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
