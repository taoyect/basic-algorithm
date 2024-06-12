package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static Random random = new Random();

/////////////////////////////////////////////////////////////////////////////////////////
    public static <T extends Comparable<T>> void sort3Ways(T[] arr) {
        sort3Ways(arr, 0, arr.length - 1);
    }
    private static <T extends Comparable<T>> void sort3Ways(T[] arr, int lo, int hi) {
        if(lo >= hi) return;

        //生成[lo, hi]之间的随机索引
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        swap(arr, randomIndex, lo);

        //arr[lo+1, lt] < v, arr[lt+1, i-1] == v, arr[gt, hi] > v
        int lt = lo, i = lo + 1, gt = hi + 1;
        while(i < gt) {
            if(arr[i].compareTo(arr[lo]) < 0)
                swap(arr, ++lt, i++);
            else if(arr[i].compareTo(arr[lo]) > 0)
                swap(arr, --gt, i);
            else //arr[i] == arr[lo]
                i++;
        }
        swap(arr, lo, lt);
        //arr[lo, lt - 1] < v, arr[lt, gt-1] == v, arr[gt, hi] > v

        sort3Ways(arr, lo, lt - 1);
        sort3Ways(arr, gt, hi);
    }


////////////////////////////////////////////////////////////////////////////////////////
    public static <T extends Comparable<T>> void sort2Ways(T[] arr) {
        sort2Ways(arr, 0, arr.length - 1);
    }
    private static <T extends Comparable<T>> void sort2Ways(T[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int p = partition2(arr, lo, hi);
        sort2Ways(arr, lo, p - 1);
        sort2Ways(arr, p + 1, hi);
    }

    /**
     * 解决 “存在较多重复元素的数组，排序性能大幅下降的问题
     * arr[lo+1,i-1] <= flag, arr[j+1, hi] >= flag
     */
    public static <T extends Comparable<T>> int partition2(T[] arr, int lo, int hi) {
        //通过随机处理，避免在数组近乎或完全有序的极端情况下，算法退化成O(n^2)，
        // 且递归深度为O(n)，导致栈溢出
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        swap(arr, randomIndex, lo);

        int i = lo + 1, j = hi;
        while(true) {
            while(i <= j && arr[i].compareTo(arr[lo]) < 0) i++; //此处不能改为<=0, 否则重复元素数组排序性能差
            while(j >= i && arr[j].compareTo(arr[lo]) > 0) j--; //此处不能改为>=0, 否则重复元素数组排序性能差
            if(i >= j) break;
            swap(arr, i++, j--);
        }
        swap(arr, lo, j); //因为j是从后往前遍历，最终i==j或者j落在 <v 的区间末尾
        return j;
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        if(lo >= hi) return;
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    /**
     * 对于有很多重复元素的数组，性能会大幅下降，排序有且只有一个重复元素的数组会退化到O(n^2)
     */
    public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        //通过随机处理，避免在数组近乎或完全有序的极端情况下，算法退化成O(n^2)，且递归深度为O(n)，导致栈溢出
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        swap(arr, randomIndex, lo);

        T flag = arr[lo];
        int j = lo;
        for(int i = lo + 1; i <= hi; i++) //一直遍历到结尾
            if(arr[i].compareTo(flag) < 0)
                swap(arr, ++j, i);
        swap(arr, lo, j);
        return j;
    }

    public static <T extends Comparable<T>> int partitionV2(T[] arr, int lo, int hi) {
        //通过随机处理，避免在数组近乎或完全有序的极端情况下，算法退化成O(n^2)，且递归深度为O(n)，导致栈溢出
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        swap(arr, randomIndex, lo);

        T flag = arr[lo];
        int j = lo;
        for(int i = lo + 1; i <= hi; i++) //一直遍历到结尾
            if(arr[i].compareTo(flag) < 0)
                swap(arr, ++j, i);
        swap(arr, lo, j);
        return j;
    }

    /**
     * 当前观察量 i
     * 循环不变量：
     *      arr[lo+1...j] < flag     arr[j+1...i-1] > flag
     * 当 arr[i] >= flag, 直接 i++;
     * 当arr[i] < flag, 先让j++，接着 交换arr[j]和 arr[i],  处理完后 i++
     * index : 0  1  2  3  4  5  6  7
     *         4  6  5  2  3  8  7  1
     *         |  |
     *         |  |
     *         j  i
     * start flag = arr[0] = 4, j = 0, i = 0 + 1 = 1
     * 1. j = 0, i = 1;  arr[i] = 6 > flag --> i++
     * 2. j = 0, i = 2;  arr[i] = 5 > flag --> i++
     * 3. j = 0, i = 3;  arr[i] = 2 < flag --> j++, swap(i, j), i++
     * j++    4 6 5 2 3 8 7 1
     *          j   i
     * swap   4 2 5 6 3 8 7 1
     *          j   i
     * i++    4 2 5 6 3 8 7 1
     *          j     i
     * 4. j = 1, i = 4; arr[i] = 3 < flag --> swap(i, ++j), i++
     *        4 2 3 6 5 8 7 1
     *            j     i
     * ....
     *
     */
    //arr[lo+1...j] < v, arr[j+1...i-1] > v
    //v = flag
    public static <T extends Comparable<T>> int partitionV1(T[] arr, int lo, int hi) {
        T flag = arr[lo];
        int j = lo;
        for(int i = lo + 1; i <= hi; i++) //一直遍历到结尾
            if(arr[i].compareTo(flag) < 0)
                swap(arr, ++j, i);
        swap(arr, lo, j);
        return j;
    }

    public static <T> void swap(T[] arr, int a, int b) {
        if(a == b) return;
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        scaleTestAll();
    }

    /**
     *      Random Array
     *      QuickSort, n = 100000, 0.022609 s
     *      QuickSort2Ways, n = 100000, 0.020286 s
     *      QuickSort3Ways, n = 100000, 0.041141 s
     *
     *      Ordered Array
     *      QuickSort, n = 100000, 0.006180 s
     *      QuickSort2Ways, n = 100000, 0.004482 s
     *      QuickSort3Ways, n = 100000, 0.010336 s
     *
     *      Same Value Array
     *      QuickSort, n = 100000, 4.808847 s
     *      QuickSort2Ways, n = 100000, 0.005187 s
     *      QuickSort3Ways, n = 100000, 0.000111 s
     */
    public static void scaleTestAll() {
        int n = 100000;
        Integer[] arr1 = ArrayGenerator.generateRandomIntegerArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        System.out.println("Random Array");
        SortingHelper.testSort("QuickSort", arr1);
        SortingHelper.testSort("QuickSort2Ways", arr2);
        SortingHelper.testSort("QuickSort3Ways", arr3);

        Integer[] arr4 = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr5 = Arrays.copyOf(arr4, arr4.length);
        Integer[] arr6 = Arrays.copyOf(arr4, arr4.length);
        System.out.println("Ordered Array");
        SortingHelper.testSort("QuickSort", arr4);
        SortingHelper.testSort("QuickSort2Ways", arr5);
        SortingHelper.testSort("QuickSort3Ways", arr6);

        Integer[] allSameArr1 = ArrayGenerator.generateRandomIntegerArray(n, 1);
        Integer[] allSameArr2 = Arrays.copyOf(allSameArr1, allSameArr1.length);
        Integer[] allSameArr3 = Arrays.copyOf(allSameArr1, allSameArr1.length);
        System.out.println("Same Value Array");
        SortingHelper.testSort("QuickSort", allSameArr1);
        SortingHelper.testSort("QuickSort2Ways", allSameArr2);
        SortingHelper.testSort("QuickSort3Ways", allSameArr3);
    }

    /**
     * 使用时需切换到 partitionV2
     * 修改VM Options -Xss128m  否则 java.lang.StackOverflowError
     * QuickSort, n = 100000, 3.390068 s
     * 对于10万个0的这种数组，仍会退化到O(n^2)，需改进
     */
    public static void scaleTest() {
        int n = 100000;
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, 1);
        SortingHelper.testSort("QuickSort", integers);
    }

    /**
     * 使用时需切换到 partitionV1
     * MergeSort, n = 50000, 0.030339 s
     * QuickSort, n = 50000, 0.013080 s
     *
     * MergeSort, n = 50000, 0.000615 s
     * QuickSort, n = 50000, 1.014096 s    修改VM Options -Xss128m  否则 java.lang.StackOverflowError
     */
    public static void scaleTestV1() {
        int n = 50000;
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
        Integer[] integers1 = Arrays.copyOf(integers, integers.length);
        SortingHelper.testSort("MergeSort", integers1);
        SortingHelper.testSort("QuickSort", integers);

        Integer[] integers3 = ArrayGenerator.generateOrderedArray(n);
        Integer[] integers4 = Arrays.copyOf(integers3, integers3.length);
        SortingHelper.testSort("MergeSort", integers3);
        SortingHelper.testSort("QuickSort", integers4);//此处会溢出java.lang.StackOverflowError，
        // 可通过Run -> Edit Configurations...修改VM Options -Xss128m
    }

    public static void normalTest() {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(10, 10);
        System.out.println(Arrays.toString(integers));
        QuickSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
