package leecode.link;

import java.util.HashSet;
import java.util.Set;

public class LM_817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int n = 0;
        while(true) {
            boolean flag = false;
            while(head != null && s.contains(head.val)) {
                flag = true;
                head = head.next;
            }
            if(flag) n++;
            if(head == null) break;
            head = head.next;
        }
        return n;
    }
}
