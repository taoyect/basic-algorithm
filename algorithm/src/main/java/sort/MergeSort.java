package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        if(lo >= hi) return;    //整个区间要么没有元素，要么只有一个元素，此时什么都不做，不需要排序
        int mid = lo + (hi - lo) / 2;  //不使用 (lo + hi) / 2是因为可能lo+hi会溢出
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    //合并两个有序区间 arr[lo, mid]、arr[mid + 1, hi]
    private static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi) {
        T[] tempArr = Arrays.copyOfRange(arr, lo, hi + 1);
        //每轮循环为arr[k]赋值, 注意arr到tempArr存在偏移量lo
        // 从tempArr[lo-lo, mid-lo],[mid+1-lo,hi-lo] 两个区间中挑一个最小的覆盖原有数组的[lo, hi]
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid)
                arr[k] = tempArr[j++ - lo];
            else if(j > hi)
                arr[k] = tempArr[i++ - lo];
            else if(tempArr[i - lo].compareTo(tempArr[j -lo]) < 0)
                arr[k] = tempArr[i++ - lo];
            else
                arr[k] = tempArr[j++ - lo];
        }

    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
        SortingHelper.testSort("MergeSort", integers);
    }
}
