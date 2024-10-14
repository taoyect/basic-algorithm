package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * O(nlogn)
 */
public class MergeSort {
    public static final int N = 15;

    //自顶向下的方式
    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        if(lo >= hi) return;    //整个区间要么没有元素，要么只有一个元素，此时什么都不做，不需要排序
        int mid = lo + (hi - lo) / 2;  //不使用 (lo + hi) / 2是因为可能lo+hi会溢出
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        //优化点1：当arr[mid]<=arr[mid+1]时，
        //此时对于有序区间[lo, mid]和[mid+1, hi],整合在一起也必然有序，没必要merge
        //对于有序数组arr，算法复杂度变为O(n)
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, lo, mid, hi);
    }

    //合并两个有序区间 arr[lo, mid]、arr[mid + 1, hi]
    private static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi) {
        T[] tmp = Arrays.copyOfRange(arr, lo, hi + 1);
        //每轮循环为arr[k]赋值, 注意arr到tmp存在偏移量lo
        // 从tmp[lo-lo, mid-lo],[mid+1-lo,hi-lo] 两个区间中挑一个最小的覆盖原有数组的[lo, hi]
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid)
                arr[k] = tmp[j++ - lo];
            else if(j > hi)
                arr[k] = tmp[i++ - lo];
            else if(tmp[i - lo].compareTo(tmp[j -lo]) < 0)
                arr[k] = tmp[i++ - lo];
            else
                arr[k] = tmp[j++ - lo];
        }
    }

    //合并两个有序区间 arr[lo, mid]、arr[mid + 1, hi]
    private static <T extends Comparable<T>> void merge2(T[] arr, int lo, int mid, int hi) {
        T[] tmp = Arrays.copyOfRange(arr, lo, hi + 1);
        //每轮循环为arr[k]赋值, 注意arr到tmp存在偏移量lo
        // 从tmp[lo-lo, mid-lo],[mid+1-lo,hi-lo] 两个区间中挑一个最小的覆盖原有数组的[lo, hi]
        int i = 0, j = mid + 1 - lo;
        for(int k = lo; k <= hi; k++) {
            if(i > mid - lo)
                arr[k] = tmp[j++];
            else if(j > hi - lo)
                arr[k] = tmp[i++];
            else if(tmp[i].compareTo(tmp[j]) < 0)
                arr[k] = tmp[i++];
            else
                arr[k] = tmp[j++];
        }
    }

    public static void test1() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        SortingHelper.testSort("MergeSortBU", integers);
        System.out.println(Arrays.toString(integers));
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 5000000;
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
        Integer[] integers1 = Arrays.copyOf(integers, integers.length);
        Integer[] integers2 = Arrays.copyOf(integers, integers.length);
        Thread.sleep(1000);
        SortingHelper.testSort("OptimizeMergeSort", integers2);
        Thread.sleep(1000);
        SortingHelper.testSort("MergeSort", integers1);
        Thread.sleep(1000);
        SortingHelper.testSort("MergeSortBU", integers);
    }

    /**自底向上的方式 （bottom up）
     */
    public static <T extends Comparable<T>> void sortByBU(T[] arr) {
        //遍历"合并的区间长度"
        //sz = 1, 代表合并区间长度为1的小数组; sz = 2, 4, 8
        for(int sz = 1; sz < arr.length; sz += sz) {//sz += sz 翻倍
            //遍历合并的两个区间的起始位置 i
            //合并[i, i + sz - 1], [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            //注意第二个区间可能比第一个区间要小，此时索引i + 2*sz - 1要比 n - 1大，越界了
            //i + sz < n 指的是第一个区间是满的，第二个区间的起始位置还没越界。这种情况才有必要merge
            for(int i = 0; i + sz < arr.length; i += sz + sz) {
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, arr.length - 1));
            }
        }
    }
    public static <T extends Comparable<T>> void sortBU(T[] arr) {
        //遍历"合并的区间长度"
        //sz = 1, 代表合并区间长度为1的小数组; sz = 2, 4, 8
        for(int sz = 1; sz < arr.length; sz *= 2) {//sz += sz 翻倍
            //遍历合并的两个区间的起始位置 i
            //合并[i, i + sz - 1], [i + sz, Math.min(i + 2*sz - 1, n - 1)]
            //注意第二个区间可能比第一个区间要小，此时索引i + 2*sz - 1要比 n - 1大，越界了
            //i + sz < n 指的是第一个区间是满的，第二个区间的起始位置还没越界。这种情况才有必要merge
            for(int i = 0; i + sz < arr.length; i += 2 * sz) {
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + 2 * sz - 1, arr.length - 1));
            }
        }
    }

    /**
     * 在规模较小的"拆分小数组"中可以考虑采用插入排序
     * An^2 和 Bnlogn 在n很小的时候，插入排序的n^2 比归并排序的nlogn小, A<B
     */
    public static <T extends Comparable<T>> void optimizeSort(T[] arr) {
        optimizeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void optimizeSort(T[] arr, int lo, int hi) {
//        if(lo >= hi) return;    //整个区间要么没有元素，要么只有一个元素，此时什么都不做，不需要排序

        if(hi - lo <= N) {
            InsertionSort.sort(arr, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;  //不使用 (lo + hi) / 2是因为可能lo+hi会溢出
        optimizeSort(arr, lo, mid);
        optimizeSort(arr, mid + 1, hi);
        //优化点1：当arr[mid]<=arr[mid+1]时，
        // 此时对于有序区间[lo, mid]和[mid+1, hi],整合在一起也必然有序，没必要merge
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, lo, mid, hi);
    }
}
