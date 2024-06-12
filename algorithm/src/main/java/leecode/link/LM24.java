package leecode.link;

/**
 * @author ct
 * @date 2024-06-11 12:07
 */
public class LM24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy;
        while(prev.next != null) {
            ListNode node1 = prev.next;
            if(node1.next == null) break;
            ListNode node2 = node1.next;
            prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            //move prev
            prev = node1;
        }
        return dummy.next;
    }
}
