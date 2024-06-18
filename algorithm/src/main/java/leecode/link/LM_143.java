package leecode.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ct
 * @date 2024-06-18 17:43
 */
public class LM_143 {
    public void reorderList(ListNode head) {
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
