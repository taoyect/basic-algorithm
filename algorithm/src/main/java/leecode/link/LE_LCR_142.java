package leecode.link;

public class LE_LCR_142 {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode dmy = new ListNode(-1);
        ListNode prev = dmy;
        while (l1 != null || l2 != null) {
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
}
