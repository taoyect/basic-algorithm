

public class Main {


   public static <T extends Comparable<T>> void sort(T[] arr) {
       for(int i = arr.length - 1; i >= 0; i--) {
           T temp = arr[i];
           int j = i;
           for(; j + 1 < arr.length; j++) {
               if(arr[j + 1].compareTo(temp) < 0)
                   arr[j] = arr[j + 1];
               else
                   break;
           }
           arr[j] = temp;
       }
   }

   public static <T> void swap(T[] arr, int a, int b) {
       T temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
   }

    public static void main(String[] args) {
//        System.out.println(Objects.equals(null, null));
    }
}
