package leecode.link;

public class LE_LCR_141 {
    public ListNode trainningPlan(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode subH = trainningPlan(head.next);
        head.next.next = head;
        head.next = null;
        return subH;
    }
}
