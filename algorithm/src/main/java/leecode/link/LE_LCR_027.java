package leecode.link;

/**
 * @author ct
 * @date 2024-06-21 16:27
 */
public class LE_LCR_027 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid = getMid(head);
        ListNode revH = reverse(mid.next);
        mid.next = null;
        while(head != null && revH != null) {
            if(head.val != revH.val) return false;
            head = head.next;
            revH = revH.next;
        }
        return true;
    }

    private ListNode reverse(ListNode h) {
        ListNode prev = null;
        ListNode cur = h;
        while(cur != null) {
            ListNode nx = cur.next;
            cur.next = prev;
            prev =cur;
            cur = nx;
        }
        return prev;
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
