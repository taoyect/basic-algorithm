package leecode.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ct
 * @date 2024-06-18 17:43
 */
public class LM_143 {
    public void recordList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = getMid(head);
        ListNode sub = reverse(mid.next);
        mid.next = null;
        merge(head, sub);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode tmp1, tmp2;
        while(l1 != null && l2 != null) {
            tmp1 = l1.next;
            tmp2 = l2.next;

            l1.next = l2;
            l1 = tmp1;

            l2.next = l1;
            l2 = tmp2;
        }
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

    private ListNode reverse(ListNode h) {
        ListNode prev = null;
        ListNode cur = h;
        while(cur != null) {
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        return prev;
    }



    public void reorderList1(ListNode head) {
        if(head == null) return;
        Map<Integer, ListNode> map = new HashMap<>();
        int s = 0;
        ListNode h = head;
        while(h != null) {
            s++;
            map.putIfAbsent(s, h);
            h = h.next;
        }
        for (int i = 0;; i++) {
            ListNode cur = map.get(i + 1);
            ListNode last = map.get(s - i);
            if(cur == last || cur.next == last) {
                last.next = null;
                break;
            }
            last.next = cur.next;
            cur.next = last;
        }
    }
}
