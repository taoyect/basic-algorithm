package leecode.link;

/**
 * @author ct
 * @date 2024-06-20 18:42
 */
public class LE_243 {
    /**
     * 思路：先找中点，后半段链表翻转，依次比较前半段和后半段的每个节点
     *
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid = getMidBefore(head);
        ListNode right = reverse(mid.next);
        mid.next = null;

        while (head != null && right != null) {
            if(head.val != right.val) return false;
            head = head.next;
            right = right.next;
        }
        return true;
    }

    private ListNode getMidBefore(ListNode h) {
        ListNode s = h;
        ListNode f = h.next;
        while(true) {
            if(f == null || f.next == null) return s;
            s = s.next;
            f = f.next.next;
        }
    }

    private ListNode reverse(ListNode h) {
        ListNode prev = null;
        ListNode cur = h;
        while(cur != null) {
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        return prev;
    }
}
