
import domain.Student;
import domain.basic.Array;
import lombok.val;
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    //balanced binary search tree
//    public TreeNode helper(int[] nums, int lo, int hi) {
//        if ( lo >  hi) return null;
//
//        // 总是选择中间位置左边的数字作为根节点
//        int mid = (lo + hi) / 2;
//
//        TreeNode root = new TreeNode(nums[mid]);
//        root.left = helper(nums, lo, mid - 1);
//        root.right = helper(nums, mid + 1,  hi);
//        return root;
//    }

    public TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;

        TreeNode r = new TreeNode(nums[mid]);
        r.left = helper(nums, lo, mid - 1);
        r.right = helper(nums, mid + 1, hi);
        return r;
    }

    int pre = Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode r) {
        if (r == null) return true;
        if (!inOrder(r.left)) return false;
        if (r.val <= pre) {
            return false;
        }
        pre = r.val;

        if (!inOrder(r.right)) return false;
        return true;
    }

}
