package leecode.link;

/**
 * @author ct
 * @date 2024-06-20 19:29
 */
public class LE_LCR_024 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sub = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return sub;
    }
}
