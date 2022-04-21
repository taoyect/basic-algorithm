import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, nums.length - k + 1 - 1);
    }

    public int find(int[] arr, int lo, int hi, int index) {
        if(lo > hi)
            return Integer.MIN_VALUE;

        int p = partition(arr, lo, hi);

        if(index == p)
            return arr[p];
        else if(index < p)
            return find(arr, lo, p - 1, index);
        else
            return find(arr, p + 1, hi, index);
    }

    public int partition(int[] arr, int lo, int hi) {
        int randomIndex = (new Random()).nextInt(hi - lo + 1) + lo;
        swap(arr, randomIndex, lo);

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

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 1};
        int kthLargest = new Solution().findKthLargest(arr, 2);
        System.out.println(kthLargest);
    }
}