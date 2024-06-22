package leecode.link;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LM_725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }
        ListNode h = head;
        int s = 0;
        while (h != null) {
            s++;
            h = h.next;
        }

        int n = s % k;
        ListNode[] arr = new ListNode[k];
        ListNode prev = new ListNode(-1, head);
        for (int i = 0; i < arr.length; i++) {
            int split = s / k;
            if (n > 0) {
                split++;
                n--;
            }
            if (split <= 0) break;

            arr[i] = prev.next;
            for (int j = 1; j <= split; j++) {
                prev = prev.next;
            }
            ListNode tail = prev;
            prev = new ListNode(-1, prev.next);
            tail.next = null;
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3});
        ListNode[] nodes = new LM_725().splitListToParts(listNode, 5);
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i]);
        }
    }
}
