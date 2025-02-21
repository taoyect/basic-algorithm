
import domain.Student;
import domain.basic.Array;
import lombok.val;
import sun.reflect.generics.tree.Tree;
import utils.TestAlgorithmUtil;

import java.util.*;
import java.util.stream.Collectors;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        Integer[] x = new Integer[]{12, 4, 12, 4, 5, 6, 2, 9};
//        sort(x, 0, x.length - 1);
//        System.out.println(search(x, 0, x.length - 1, 6));
//        System.out.println(search(x, 0, x.length - 1, 7));
//        System.out.println(search(x, 0, x.length - 1, 12));
//        System.out.println(upper(x, -1));
//        System.out.println(upper(x, 2));
//        System.out.println(upper(x, 12));
//        System.out.println(lower(x, 5)); //2
//        System.out.println(lower(x, 2)); //-1
//        System.out.println(lower(x, 21));//7
//        System.out.println(Arrays.toString(x));
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
//        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
//        System.out.println(medianSortedArrays);
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode r) {
        if(r == null) return 0;
        int leftMax = Math.max(maxGain(r.left), 0);
        int rightMax = Math.max(maxGain(r.right), 0);

        maxSum = Math.max(maxSum, leftMax + rightMax + r.val);

        return Math.max(leftMax, rightMax) + r.val;
    }

}

