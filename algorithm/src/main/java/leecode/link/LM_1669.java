package leecode.link;

/**
 * @author ct
 * @date 2024-06-21 16:49
 */
public class LM_1669 {
    /**
     * 思路：
     * 1. 找到a前面的节点位置和b的位置
     * 2. 找到list2的尾节点
     * 3. 模拟过程即可
     *
     * 注意：a,b为下标
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dmy = new ListNode(-1, list1);
        ListNode prev = dmy;
        ListNode ap = null; //指向a-1
        for (int i = 0; i <= b; i++) {
            prev = prev.next;
            if(i == a - 1) ap = prev;
        }

        ListNode tail2 = new ListNode(-1, list2);
        while(tail2.next != null) {
            tail2 = tail2.next;
        }

        ap.next = list2;
        tail2.next = prev.next;
        prev.next = null;
        return dmy.next;
    }
}
