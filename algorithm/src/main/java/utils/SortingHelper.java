package utils;

import sort.InsertionSort;
import sort.MergeSort;
import sort.SelectionSort;

public class SortingHelper {
    private SortingHelper(){}

    /**
     * 检查数组是否是有序的
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] arr, boolean asc) {
        return asc ? isAscSorted(arr) : isDescSorted(arr);
    }

    private static <T extends Comparable<T>> boolean isAscSorted(T[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        }
        return true;
    }

    private static <T extends Comparable<T>> boolean isDescSorted(T[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1].compareTo(arr[i]) < 0)
                return false;
        }
        return true;
    }

    public static <T extends Comparable<T>> void testSort(String sortName, T[] arr) {
        long start = System.nanoTime();

        if("SelectionSort".equals(sortName)) {
            SelectionSort.sort(arr);
        } else if("InsertionSort".equals(sortName)) {
            InsertionSort.sort(arr);
        } else if("MergeSort".equals(sortName)) {
            MergeSort.sort(arr);
        }

        long end = System.nanoTime();
        if(!SortingHelper.isSorted(arr, true)) {
            throw new RuntimeException("algorithm failed");
        }
        double usedTime = (end - start) / 1000000000.0;
        System.out.printf("%s, n = %d, %f s%n", sortName, arr.length, usedTime);
    }
}
