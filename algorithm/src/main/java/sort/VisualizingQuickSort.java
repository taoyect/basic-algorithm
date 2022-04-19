package sort;

import utils.ArrayGenerator;

import java.util.Arrays;

public class VisualizingQuickSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1, 0);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi, int depth) {
        // 生成深度字符串
        String depthString = generateDepthString(depth);
        // 打印当前 sort 处理的数组区间信息
        System.out.print(depthString);
        System.out.printf("quicksort arr[%d, %d]%n", lo, hi);

        if(lo >= hi) return;
        int p = partition(arr, lo, hi);
        // 打印这次 partition 要处理的区间范围
        System.out.printf("p = %d, after partition %s%n", p, Arrays.toString(arr));
        sort(arr, lo, p - 1, depth + 1);
        sort(arr, p + 1, hi, depth + 1);
    }

    //arr[lo+1...j] < flag, arr[j+1...i-1] > flag
    public static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        T flag = arr[lo];
        int j = lo;
        for(int i = lo + 1; i <= hi; i++) //一直遍历到结尾
            if(arr[i].compareTo(flag) < 0)
                swap(arr, ++j, i);
        swap(arr, lo, j);
        return j;
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(5, 10);
        System.out.println(Arrays.toString(integers));
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
