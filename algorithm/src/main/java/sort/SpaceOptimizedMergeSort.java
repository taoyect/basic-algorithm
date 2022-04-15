package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

public class SpaceOptimizedMergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        T[] temp = Arrays.copyOf(arr, arr.length); //只在顶层开辟一次空间
        sort(arr, 0, arr.length - 1, temp);
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi, T[] temp) {
        if( lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid, temp);
        sort(arr, mid + 1, hi, temp);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, lo, mid, hi, temp);
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi, T[] temp) {
        System.arraycopy(arr, lo, temp, lo, hi - lo + 1);
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid)
                arr[k] = temp[j++];
            else if(j > hi)
                arr[k] = temp[i++];
            else if(temp[i].compareTo(temp[j]) < 0)
                arr[k] = temp[i++];
            else
                arr[k] = temp[j++];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 1000000;
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
        Integer[] integers1 = Arrays.copyOf(integers, integers.length);
        Thread.sleep(1000);
        SortingHelper.testSort("SpaceOptimizedMergeSort", integers1);
        SortingHelper.testSort("MergeSort", integers);
    }
}
