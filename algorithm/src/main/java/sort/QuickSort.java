package sort;

import utils.ArrayGenerator;

import java.util.Arrays;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    /**
     * 当前观察量 i
     * 循环不变量：
     *      arr[lo+1...j] < flag     arr[j+1...i-1] > flag
     * 当 arr[i] >= flag, 直接 i++;
     * 当arr[i] < flag, 先让j++，接着 交换arr[j]和 arr[i],  处理完后 i++
     * index : 0  1  2  3  4  5  6  7
     *         4  6  5  2  3  8  7  1
     *         |  |
     *         |  |
     *         j  i
     * start flag = arr[0] = 4, j = 0, i = j + 1
     * 1. j = 0, i = 1;  arr[i] = 6 > flag --> i++
     * 2. j = 0, i = 2;  arr[i] = 5 > flag --> i++
     * 3. j = 0, i = 3;  arr[i] = 2 < flag --> j++, swap(i, j), i++
     *        4 6 5 2 3 8 7 1
     * j++      j   i
     * swap   4 2 5 6 3 8 7 1
     * i++      j     i
     * 4. j = 1, i = 4; arr[i] = 3 < flag --> j++, swap(i, j), j++
     *        4 2 3 6 5 8 7 1
     *            j     i
     * ....
     */
    public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        T flag = arr[lo];
        int j = lo;
        for(int i = lo + 1; i <= hi; i++) { //一直遍历到结尾
            if(arr[i].compareTo(flag) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, lo, j);
        return j;
    }

    public static <T extends Comparable<T>> int partition1(T[] arr, int lo, int hi) {
        T flag = arr[lo];
        int i = lo, j = hi + 1;
        while(true) {
            while(arr[++i].compareTo(flag) < 0) {
                if(i == hi) break;
            }
            while(arr[--j].compareTo(flag) > 0);
            if(i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        QuickSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
