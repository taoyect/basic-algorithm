import utils.ArrayGenerator;

import java.util.Arrays;

public class Main {

   public static <T extends Comparable<T>> void sort(T[] arr) {
    sort(arr, 0, arr.length - 1);
   }

   public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
       if(lo >= hi) return;
       int mid = lo + (hi - lo) / 2;
       sort(arr, lo, mid);
       sort(arr, mid + 1, hi);
       if(arr[mid].compareTo(arr[mid + 1]) > 0)
           merge(arr, lo, mid, hi);
   }

   public static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi) {
       T[] tempArr = Arrays.copyOfRange(arr, lo, hi + 1);
       int i = lo, j = mid + 1;
       for(int k = lo; k <= hi; k++) {
           if(i > mid)
               arr[k] = tempArr[j++ - lo];
           else if(j > hi)
               arr[k] = tempArr[i++ - lo];
           else if(tempArr[i - lo].compareTo(tempArr[j - lo]) < 0)
               arr[k] = tempArr[i++ - lo];
           else
               arr[k] = tempArr[j++ - lo];
       }
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
