package leecode.link;

import lombok.val;

public class LM_LCR_077 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode right = mergeSort(mid.next);
        mid.next = null;
        ListNode left = mergeSort(head);
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

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(true) {
            if(fast == null || fast.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}
