package sort;

import utils.ArrayGenerator;

import java.util.Arrays;

/**
 * O(n^2)
 */
public class BubbleSort {

    /**
     * 基本思想：每次比较两个相邻的元素，如果是逆序对，就交换位置
     * 循环不变量：
     *    第 i 轮开始，arr[n - i, n)已排好序
     *    第 i 轮的目的：在arr[n - i - 1]的位置上放上合适的元素
     *    第 i 轮结束，arr[n - i - 1, n)已排好序
     *
     *    i:轮数，也表示已经有多少个元素排好序了
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        //for(int i = 0; i < arr.length; i++) 也可以
        // 最后一轮 i = arr.length - 1, 只有一个元素，可以直接不进行bubble的过程，所以i < arr.length - 1也可以
        for(int i = 0; i < arr.length - 1; i++)
            for(int j = 0; j + 1 < arr.length - i; j++)
                if(arr[j].compareTo(arr[j + 1]) > 0)
                    swap(arr, j, j + 1);
    }

    public static <T extends Comparable<T>> void oppositeSort(T[] arr) {
        for(int i = 0; i < arr.length - 1; i++)
            for(int j = arr.length - 1; j - 1 >= i; j--)
                if(arr[j].compareTo(arr[j - 1]) < 0)
                    swap(arr, j, j - 1);
    }

    /**
     * 对于已经排好序的arr，可以优化到 O(n)
     */
    public static <T extends Comparable<T>> void sort2(T[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for(int j = 0; j + 1 < arr.length - i; j++)
                if(arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            if(!isSwapped) break;
        }
    }

    /**
     * 对于已经排好序的arr，可以优化到 O(n)
     *  i也表示已经有多少个元素排好序了
     */
    public static <T extends Comparable<T>> void sort3(T[] arr) {
        for(int i = 0; i < arr.length - 1; ) {
            int lastSwappedIndex = 0;
            for(int j = 0; j + 1 < arr.length - i; j++)
                if(arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    lastSwappedIndex = j + 1; //最后一次交换逆序对，后者元素的索引
                }
//            if(lastSwappedIndex == 0) break;
            i = arr.length - lastSwappedIndex;
        }
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        testOppositeSort();
    }

    public static void testOppositeSort() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        oppositeSort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
