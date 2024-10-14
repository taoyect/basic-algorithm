package leecode.link;

import java.util.HashSet;
import java.util.Set;

public class LE141 {
    public boolean hasCycle(ListNode head) {
       //Floyd跑圈算法
       ListNode slow = head;
       ListNode fast = head;
       while(true) {
           if(fast == null || fast.next == null) return false;
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow) return true;
       }
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while (head != null) {
            if(!s.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
