import utils.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

public class Main {

   public static <T extends Comparable<T>> void sort(T[] arr) {
       sort(arr, 0, arr.length - 1);
   }

   public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
       if(lo >= hi) return;

       int randomIndex = (new Random()).nextInt(hi - lo + 1) + lo;
       swap(arr, lo, randomIndex);

       int lt = lo, i = lo + 1, gt = hi + 1;
       while(i < gt) {
           if(arr[i].compareTo(arr[lo]) < 0)
               swap(arr, ++lt, i++);
           else if(arr[i].compareTo(arr[lo]) > 0)
               swap(arr, --gt, i);
           else
               i++;
       }
       swap(arr, lo, lt);

       sort(arr, lo, lt - 1);
       sort(arr, gt, hi);
   }

   public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
      int randomIndex = (new Random()).nextInt(hi - lo + 1) + lo;
      swap(arr, randomIndex, lo);

      int i = lo + 1, j = hi;
      while(true) {
          while(i <= j && arr[i].compareTo(arr[lo]) < 0) i++;
          while(j >= i && arr[j].compareTo(arr[lo]) > 0) j--;
          if(i >= j) break;
          swap(arr, i++, j--);
      }
      swap(arr, lo, j);
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
