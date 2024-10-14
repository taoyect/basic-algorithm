package leecode.link;

public class LH_LCR_078 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] arr, int lo, int hi) {
        if(lo >= hi) return arr[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeSort(arr, lo, mid);
        ListNode right = mergeSort(arr, mid + 1, hi);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dmy = new ListNode(Integer.MAX_VALUE);
        ListNode prev = dmy;
        while(left != null || right != null) {
            int n1 = left == null ? Integer.MAX_VALUE : left.val;
            int n2 = right == null ? Integer.MAX_VALUE : right.val;
            if(n1 < n2) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        return dmy.next;
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        return mergeKLists(lists, 0, lists.length - 1);
//    }
//
//    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
//        if(lo > hi) return null;
//        int mid = lo + (hi - lo) / 2;
//        ListNode l1 = mergeKLists(lists, lo, mid);
//        ListNode l2 = mergeKLists(lists, mid + 1, hi);
//        return merge(l1, l2);
//    }
//
//    private ListNode merge(ListNode l1, ListNode l2) {
//        ListNode list = new ListNode(Integer.MIN_VALUE);
//        ListNode prev = list;
//        while (l1 != null || l2 != null) {
//            if(l1 == null) {
//                prev.next = l2;
//                l2 = l2.next;
//            } else if(l2 == null) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else if(l1.val > l2.val) {
//                prev.next = l2;
//                l2 = l2.next;
//            } else {
//                prev.next = l1;
//                l1 = l1.next;
//            }
//            prev = prev.next;
//        }
//        return list.next;
//    }
}
