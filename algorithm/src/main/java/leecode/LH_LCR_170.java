package leecode;

import java.util.Arrays;

/**
 * @author ct
 * @date 2024-06-11 18:59
 */
public class LH_LCR_170 {

    //===================================【解法2：归并排序（空间优化 + 插入排序）】=======================================================
    public int reversePairs(int[] record) {
        int[] tmp = Arrays.copyOfRange(record, 0, record.length);
        return sort(record, 0, record.length - 1, tmp);
    }

    public int sort(int[] arr, int lo, int hi, int[] tmp) {
        if(lo >= hi) return 0;
        if(hi - lo <= 8) {
            return insertSort(arr, lo, hi);
        }
        int mid = lo + (hi - lo) / 2;
        int n1 = sort(arr, lo, mid, tmp);
        int n2 = sort(arr, mid + 1, hi, tmp);
        int n3 = 0;
        if(arr[mid] > arr[mid + 1])
            n3 = merge(arr, lo, mid, hi, tmp);

        return n1 + n2 + n3;
    }

    private int merge(int[] arr, int lo, int mid, int hi, int[] tmp) {
        System.arraycopy(arr, lo, tmp, lo, hi - lo + 1);
        int i = lo, j = mid + 1;
        int reverseN = 0;
        for (int k = lo; k <= hi; k++) {
            if(i > mid) {
                arr[k] = tmp[j++];
            } else if(j > hi) {
                arr[k] = tmp[i++];
            } else if(tmp[i] > tmp[j]) {
                arr[k] = tmp[j++];
                reverseN += mid - i + 1;
            } else {
                arr[k] = tmp[i++];
            }
        }
        return reverseN;
    }

    private int insertSort(int[] arr, int lo, int hi) {
        int reverseN = 0;
        for(int i = lo; i <= hi; i++) {
            int temp = arr[i]; //暂存，空间换时间
            int j = i;
            for(; j - 1 >= lo && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1]; //向后平移一个位置
                reverseN++;
            }
            arr[j] = temp;
        }
        return reverseN;

//        int reverseN = 0;
//        for (int i = lo; i <= hi; i++)
//            for(int j = i; j - 1 >= lo && arr[j - 1] > arr[j]; j--) {
//                swap(arr, j - 1, j);
//                reverseN++;
//            }
//        return reverseN;
    }

//    private void swap(int[] arr, int a, int b) {
//        if(a == b) return;
//        arr[a] = arr[a] ^ arr[b];
//        arr[b] = arr[a] ^ arr[b];
//        arr[a] = arr[a] ^ arr[b];
//    }

//===================================【解法1：普通归并排序】=======================================================
    public int reversePairs1(int[] record) {
        return reversePairs1(record, 0, record.length - 1);
    }

    private int reversePairs1(int[] arr, int lo, int hi) {
        if(lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;

        int n1 = reversePairs1(arr, lo, mid);
        int n2 = reversePairs1(arr, mid + 1, hi);
        int n3 = 0;
        if(arr[mid] > arr[mid + 1]) {
            n3 = mergeCalc(arr, lo, mid, hi);
        }
        return n1 + n2 + n3;
    }

    private int mergeCalc(int[] arr, int lo, int mid, int hi) {
        int[] tmp = Arrays.copyOfRange(arr, lo, hi + 1);
        int i = lo, j = mid + 1;
        int reverseN = 0;
        for (int k = lo; k <= hi; k++) {
            if(i > mid) {
                arr[k] = tmp[j++ - lo];
            } else if(j > hi) {
                arr[k] = tmp[i++ - lo];
            } else if(tmp[i - lo] > tmp[j - lo]) {
                arr[k] = tmp[j++ - lo];
                reverseN += mid - i + 1;
            } else {
                arr[k] = tmp[i++ - lo];
            }
        }
        return reverseN;
    }

    public static void main(String[] args) {
        int[] x = {7,5,6,4};
        int i = new LH_LCR_170().reversePairs(x);
        System.out.println(i);
    }
}
