package leecode.link;

/**
 * @author ct
 * @date 2024-06-21 15:57
 */
public class LM_147 {

    //懒得写了

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j - 1 > 0 && arr[j - 1].compareTo(arr[j]) > 0; j--)
                swap(arr, j, j - 1);
    }

    private static <T> void swap(T[] arr, int a, int b) {

    }

    private ListNode mergeSort(ListNode h) {
        if(h == null || h.next == null) return h;
        ListNode mid = getMid(h);
        ListNode right = mergeSort(mid.next);
        mid.next = null;
        ListNode left = mergeSort(h);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dmy = new ListNode(-1);
        ListNode prev = dmy;
        while(l1 != null || l2 != null) {
            int n1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int n2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if(n1 < n2) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        return dmy.next;
    }

    private ListNode getMid(ListNode h) {
        ListNode s = h;
        ListNode f = h.next;
        while(true) {
            if(f == null || f.next == null) return s;
            s = s.next;
            f = f.next.next;
        }
    }
}
