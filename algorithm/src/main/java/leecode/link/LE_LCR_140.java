package leecode.link;

public class LE_LCR_140 {
    public ListNode trainingPlan(ListNode head, int cnt) {
        int size = 0;
        ListNode h = head;
        while(h != null) {
            size ++;
            h = h.next;
        }
        ListNode prev = new ListNode(-1, head);
        for (int i = 0; i <= (size - cnt); i++) {
            prev = prev.next;
        }
        return prev;
    }
}
