import java.util.HashSet;

public class Solution {

    // 前提：1<= n <=1000, 1<= num < n
    // 原理：抽屉原理(一个萝卜一个坑) + "异或"交换
    //时间复杂度O(n) 空间复杂度O(1)
    public static int countDuplicates(int[] arr) {
        HashSet<Integer> duplicateNums = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != (i + 1) && arr[arr[i] - 1] != arr[i])
                swap(arr, i, arr[i] - 1);
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - 1 != i)
                duplicateNums.add(arr[i]);
        }
        System.out.println(duplicateNums);
        return duplicateNums.size();
    }

    public static int x(int[] arr) {
        HashSet<Integer> duplicateSet = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == i + 1) continue;
            int targetIndex = arr[i] - 1;
            if(arr[targetIndex] == arr[i]) continue;
            swap(arr, i, targetIndex);
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - 1 != i)
                duplicateSet.add(arr[i]);
        }
        System.out.println(duplicateSet);
        return duplicateSet.size();
    }

    public static void swap(int[] arr, int a, int b) {
        if(a == b) return;
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 1, 4, 5, 6, 3, 2};
        int[] nums2 = {1,1,2,2,2,3};
        System.out.println(countDuplicates(nums1));
        System.out.println(x(nums1));
        System.out.println(countDuplicates(nums2));
        System.out.println(x(nums2));
    }
}