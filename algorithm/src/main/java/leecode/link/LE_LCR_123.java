package leecode.link;

/**
 * @author ct
 * @date 2024-06-21 16:23
 */
public class LE_LCR_123 {
    public int[] reverseBookList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        int s = 0;
        while (cur != null) {
            s++;
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        int[] arr = new int[s];
        int i = 0;
        while (prev != null) {
            arr[i++] = prev.val;
            prev = prev.next;
        }
        return arr;
    }

}
