package sort;

import utils.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

public class SelectK {
    public static <T extends Comparable<T>> T findKthLargest(T[] arr, int k) {
        return findKthMin(arr, 0, arr.length - 1, arr.length - k + 1 - 1);
    }

    public static <T extends Comparable<T>> T findKthMin(T[] arr, int lo, int hi, int index) {
        if(lo > hi) return null;

        int p = partition(arr, lo, hi);
        if(index == p) return arr[p];
        else if(index < p) return findKthMin(arr, lo, p - 1, index);
        else return findKthMin(arr, p + 1, hi, index);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        int randomIndex = (new Random()).nextInt(hi - lo + 1) + lo;
        swap(arr, lo, randomIndex);

        int i = lo + 1, j = hi;
        while(true) {
            while(i <= j && arr[i].compareTo(arr[lo]) < 0) i++;
            while(j >= i && arr[j].compareTo(arr[lo]) > 0) j--;
            if(i >= j) break;
            swap(arr, i++, j--);
        }
        swap(arr, j, lo);
        return j;
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(5, 10);
        System.out.println(Arrays.toString(integers));
        Integer kthLargest1 = findKthLargest(integers, 1);
        Integer kthLargest2 = findKthLargest(integers, 2);
        Integer kthLargest3 = findKthLargest(integers, 3);
        Integer kthLargest4 = findKthLargest(integers, 4);
        Integer kthLargest5 = findKthLargest(integers, 5);
        System.out.println(kthLargest1);
        System.out.println(kthLargest2);
        System.out.println(kthLargest3);
        System.out.println(kthLargest4);
        System.out.println(kthLargest5);
    }

}
