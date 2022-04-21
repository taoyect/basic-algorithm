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

    // > target 的最小值索引
    public static <T extends Comparable<T>> int upper(T[] arr, T target) {
        int lo = 0, hi = arr.length; //注意hi的定义
        //在data[lo, hi]中寻找解决
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid].compareTo(target) <= 0)
                lo = mid + 1;
            else
                hi = mid; //大于target的最小值也有可能是mid
        }
        return hi;
    }

    //如果数组中存在该元素，则返回相同元素的最大索引； 如果不存在，返回upper
    //Math.ceil(5.0) = 5.0, Math.ceil(5.5) = 6.0
    public static <T extends Comparable<T>> int upperCeil(T[] arr, T target) {
        int u = upper(arr, target);
        if(u - 1 >= 0 && arr[u - 1].compareTo(target) == 0)
            return u - 1;
        return u;
    }

    //如果数组中存在该元素，则返回相同元素的最小索引； 如果不存在，返回upper
    //即 找出 >= target 的最小索引
    //Math.ceil(5.0) = 5.0, Math.ceil(5.5) = 6.0
    public static <T extends Comparable<T>> int lowerCeil(T[] arr, T target) {
        int u = upper(arr, target);
        if(u - 1 >= 0 && arr[u - 1].compareTo(target) == 0) {
            int k = u - 2;
          while(k >= 0 && arr[k].compareTo(target) == 0){
              k--;
          }
          return k + 1;
        }
        return u;
    }

    //  < target的最大值  e.g. 查找小于85分的最大值
    public static <T extends Comparable<T>> int lower(T[] arr, T target) {
        int lo = -1, hi = arr.length - 1;
        while(lo < hi) {
            // 注意此处 hi - lo + 1，用的是向上取整，写hi - lo会陷入死循环
            int mid = lo + (hi - lo + 1) / 2;
            if(arr[mid].compareTo(target) >= 0)
                hi = mid - 1;
            else
                lo = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        testLowerCeil();
    }
    public static void testLower() {
        Integer[] arr = {1, 1, 3, 3 ,5, 5};
        for(int i = 0; i <= 6; i++)
            System.out.print(lower(arr, i) + " ");
        System.out.println();
    }

    public static void testUpper() {
        Integer[] arr = {1, 1, 3, 3 ,5, 5};
        for(int i = 0; i <= 6; i++)
            System.out.print(upper(arr, i) + " ");
        System.out.println();
    }

    public static void testUpperCeil() {
        Integer[] arr = {1, 1, 3, 3 ,5, 5};
        for(int i = 0; i <= 6; i++)
            System.out.print(upperCeil(arr, i) + " ");
        System.out.println();
    }

    public static void testLowerCeil() {
        Integer[] arr = {1, 1, 3, 3 ,5, 5};
        for(int i = 0; i <= 6; i++)
            System.out.print(lowerCeil(arr, i) + " ");
        System.out.println();
    }

    public static void testNormalSearch() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(5, 10);
        System.out.println(Arrays.toString(integers));
        QuickSort.sort3Ways(integers);
        System.out.println(Arrays.toString(integers));

        int search = search(integers, 5);

        System.out.println(search);
    }
}
