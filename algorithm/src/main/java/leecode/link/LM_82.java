package leecode.link;

public class LM_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dmy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dmy;
        while(prev.next != null) {
            ListNode cur = prev.next;
            boolean curDel = false;
        //循环删除和当前元素重复的后续元素，如果存在重复元素，标记当前元素为“需要删除”
            while(cur.next != null) {
                if(cur.val == cur.next.val) {
                   curDel = true;
                   cur.next = cur.next.next;
                } else {
                    break;
                }
            }
            if(curDel) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
        }
        return dmy.next;
    }
}
