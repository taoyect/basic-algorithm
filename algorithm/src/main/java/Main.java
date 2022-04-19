import utils.ArrayGenerator;

import java.util.Arrays;

public class Main {

   public static <T extends Comparable<T>> void sort(T[] arr) {
       sort(arr, 0, arr.length - 1);
   }

   public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
       if(lo >= hi) return;
       int p = partition(arr, lo, hi);
       sort(arr, lo, p - 1);
       sort(arr, p + 1, hi);
   }

   public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
       int j = lo;
       for(int i = lo + 1; i < arr.length; i++)
           if(arr[i].compareTo(arr[lo]) < 0)
               swap(arr, ++j, i);
       swap(arr, j, lo);
       return j;
   }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(7, 15);
        System.out.println(Arrays.toString(integers));
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }





}
