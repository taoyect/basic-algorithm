package leecode.link;

/**
 * @author ct
 * @date 2024-06-06 15:50
 */
public class Del203 {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            ListNode delHead = head;
            head = head.next;
            delHead.next = null;
        }

        if(head == null) return null;

        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
