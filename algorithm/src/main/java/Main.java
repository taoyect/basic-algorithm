import java.util.Random;

public class Main {
   public static <T extends Comparable<T>> T findKthMin(T[] arr, int k) {
       return findKthMin(arr, 0, arr.length - 1, k - 1);
   }

   public static <T extends Comparable<T>> T findKthMin(T[] arr, int lo, int hi, int index) {
        if(lo > hi) return null;
        int p = partition(arr, lo, hi);
        if(p == index) return arr[p];
        if(p > index)
            return findKthMin(arr, lo, p - 1, index);
        return findKthMin(arr, p + 1, hi, index);
   }

   public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
       int randomIndex = (new Random()).nextInt(hi - lo + 1) + lo;
       swap(arr, randomIndex, lo);
       int i = lo + 1, j = hi;
       while(true) {
           while(i <= j && arr[i].compareTo(arr[lo]) < 0) i++;
           while(j >= i && arr[j].compareTo(arr[lo]) > 0) j--;
           if(i > j) break;
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
        System.out.println(Integer.toHexString(0x23 & 0x34));
    }





}
