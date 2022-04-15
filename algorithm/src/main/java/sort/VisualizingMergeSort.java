package sort;

import utils.ArrayGenerator;

import java.util.Arrays;

public class VisualizingMergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1, 0);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi, int depth) {
        // 生成深度字符串
        String depthString = generateDepthString(depth);
        // 打印当前 sort 处理的数组区间信息
        System.out.print(depthString);
        System.out.printf("mergesort arr[%d, %d]%n", lo, hi);
        if(lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid, depth + 1);
        sort(arr, mid + 1, hi, depth + 1);

        // 打印这次 merge 要处理的区间范围
        System.out.print(depthString);
        System.out.printf("merge arr[%d, %d] and arr[%d, %d]%n", lo, mid, mid + 1, hi);

        merge(arr, lo, mid, hi);

        // 打印 merge 后的数组
        System.out.print(depthString);
        System.out.printf("after mergesort arr[%d, %d] :", lo, hi);
        for(T t: arr) System.out.print(t + " ");
        System.out.println();
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi) {
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

    private static String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
        System.out.println(Arrays.toString(integers));
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
