package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * 希尔排序
 * 基本思想：让数组越来越有序（不能只处理相邻逆序对）
 *  step1: 对元素间距为 n/2 的所有数组元素做插入排序
 *  step2: 对元素间距为 n/4 的所有数组元素做插入排序
 *  step3: 对元素间距为 n/8 的所有数组元素做插入排序
 *  ...
 *  stepN: 对元素间距为 1 的所有数组元素做插入排序
 */
public class ShellSort {

    /**
     * 不用分别处理完每一个子数组，可以 for(int i = h; i < arr.length; i++) 挨个处理，
     * 只不过每次处理的时候，利用 步长 仅和自己所在子数组内的元素进行插入排序
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int h = arr.length / 2; //步长
        while(h >= 1) {
            for(int i = h; i < arr.length; i++)
                for(int j = i; j - h >= 0 && arr[j - h].compareTo(arr[j]) > 0; j -= h)
                    swap(arr, j - h, j);
            h /= 2;
        }
    }

    public static <T extends Comparable<T>> void rawsSort(T[] arr) {
        int h = arr.length / 2; //步长
        while(h >= 1) {
            for(int k = 0; k < h; k++) { //共h组
                // 对 arr[k, k + h, k + 2h, k + 3h, ...] 做 插入排序
                for(int i = k + h; i < arr.length; i += h)
                    for(int j = i; j - h >= 0 && arr[j - h].compareTo(arr[j]) > 0; j -= h)
                        swap(arr, j - h, j);
            }
            h /= 2;
        }
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr1 = ArrayGenerator.generateRandomIntegerArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        SortingHelper.testSort("ShellSort", arr1);
//        SortingHelper.testSort("InsertionSort", arr2);
        SortingHelper.testSort("MergeSort", arr3);
    }

    public void normalTest() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
