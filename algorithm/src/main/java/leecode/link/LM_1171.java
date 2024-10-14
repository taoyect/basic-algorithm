package leecode.link;

import java.util.HashMap;
import java.util.Map;

public class LM_1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        for (ListNode h = head; h != null; h = h.next) {
            sum += h.val;
            if(sum == 0) {
                return removeZeroSumSublists(h.next);
            }
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }

    public ListNode removeZeroSumSublists1(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();   //<前缀和,节点>
        ListNode dmy = new ListNode(0, head);   //因为要删除 总和 值为 0 的连续节点组成的序列，所以dmy的val设置为0
        ListNode cur = dmy;  // 必须从伪节点开始遍历，不然碰到[-1,1]这种会删除不了
        int preSum = 0;       // 记录的前缀和
        //一次遍历
        while (cur != null) {
            preSum += cur.val;
            map.put(preSum, cur);
            cur = cur.next;
        }
        //二次遍历
        cur = dmy;
        preSum = 0;
        while (cur != null) {
            preSum += cur.val;
            if (map.containsKey(preSum)) {
                cur.next = map.get(preSum).next; //即便map中的映射节点是cur，该条也没问题
            }
            cur = cur.next;
        }
        return dmy.next;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {1,2,-3,3,1};
        ListNode case1List = new ListNode(case1);
        ListNode listNode = new LM_1171().removeZeroSumSublists(case1List);
        System.out.println(listNode);
    }

}
