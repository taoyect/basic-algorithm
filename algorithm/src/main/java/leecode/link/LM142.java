package leecode.link;

import java.util.HashSet;

public class LM142 {
        public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }

        //到此说明一定有环
        ListNode slow2 = head;   // 再找一只乌龟，从头开始爬
        while(slow2 != slow) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,0,-4};
        ListNode list = new ListNode(arr);
        ListNode listNode = new LM142().detectCycle(list);
        System.out.println(listNode);
    }


    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> s = new HashSet<>();
        while (head != null) {
            if(!s.add(head)) {  //Returns: true if this set did not already contain the specified element

                return head;
            }
            head = head.next;
        }
        return null;
    }
}
