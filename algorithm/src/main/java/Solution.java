import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, nums.length - k + 1 - 1);
    }

    public int find(int[] arr, int lo, int hi, int k) {
        if(lo > hi) return Integer.MIN_VALUE;
        while(lo <= hi) {
            int p = partition(arr, lo, hi);
            if(p == k) return arr[p];
            if(p < k) lo = p + 1;
            else hi = p - 1;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int kthLargest = new Solution().findKthLargest(nums, 1);
        System.out.println(kthLargest);
    }

    //二路快排的partition
    public int partition(int[] arr, int lo, int hi) {
        int randomIndex = (new Random()).nextInt(hi - lo + 1) + lo;
        swap(arr, lo, randomIndex);

        int i = lo + 1, j = hi;
        while(true) {
            while(i <= j && arr[i] < arr[lo]) i++;
            while(j >= i && arr[j] > arr[lo]) j--;
            if(i >= j) break;
            swap(arr, i++, j--);
        }
        swap(arr, lo, j);
        return j;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}