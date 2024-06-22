package leecode.link;

/**
 * @author ct
 * @date 2024-06-21 16:39
 */
public class LM_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);

        int carry = 0;
        ListNode dmy = new ListNode(-1);
        ListNode prev = dmy;
        while(rl1 != null || rl2 != null) {
            int n1 = rl1 == null ? 0 : rl1.val;
            int n2 = rl2 == null ? 0 : rl2.val;
            int sum = n1 + n2 + carry;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            carry = sum / 10;

            if(rl1 != null) {
                rl1 = rl1.next;
            }
            if(rl2 != null) {
                rl2 = rl2.next;
            }
        }
        if(carry > 0) {
            prev.next = new ListNode(carry);
        }
        return reverse(dmy.next);
    }

    private ListNode reverse(ListNode h) {
        ListNode prev = null;
        ListNode cur = h;
        while (cur != null) {
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        return prev;
    }
}
