package search;

import sort.QuickSort;
import utils.ArrayGenerator;

import java.util.Arrays;

public class BinarySearch {

    //迭代版本
    public static <T extends Comparable<T>> int search(T[] arr, T target) {
        if(target == null) return -1;
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(target.compareTo(arr[mid]) == 0) return mid;
            if(target.compareTo(arr[mid]) > 0)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
    //递归实现 recursive
    public static <T extends Comparable<T>> int searchR(T[] arr, T target) {
        if(target == null) return -1;
        return searchR(arr, 0, arr.length - 1, target);
    }

    public static <T extends Comparable<T>> int searchR(T[] arr, int lo, int hi, T target) {
        if(lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if(target.compareTo(arr[mid]) < 0) return searchR(arr, lo, mid - 1, target);
        if(target.compareTo(arr[mid]) > 0) return searchR(arr, mid + 1, hi, target);
        return mid;
    }

    public static void main(String[] args) {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(5, 10);
        System.out.println(Arrays.toString(integers));
        QuickSort.sort3Ways(integers);
        System.out.println(Arrays.toString(integers));
        int search = search(integers, 5);
        System.out.println(search);
    }
}
