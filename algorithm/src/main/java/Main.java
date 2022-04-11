import utils.ArrayGenerator;

import java.util.Arrays;

public class Main {


    public static <T extends Comparable<T>> void sort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            T temp = arr[i];
            int j = i;
            for(; j - 1 >= 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
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
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
