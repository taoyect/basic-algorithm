package leecode.link;

public class LM_LCR_022 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        ListNode slow2 = head;
        while(slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}
