package leecode.link;


/**
 * @author ct
 * @date 2024-06-11 11:29
 */
public class LH23 {
    //===============================【解法2】========================================

    /**
     * 参考归并排序的全部思路，先递归后merge
     * 耗时约2ms
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] arr, int lo, int hi) {
        if(lo >= hi) return arr[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode list1 = mergeKLists(arr, lo, mid);
        ListNode list2 = mergeKLists(arr, mid + 1, hi);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        while(list1 != null || list2 != null) {
            ListNode cur = null;
            if(list1 == null) {
                cur = new ListNode(list2.val);
                list2 = list2.next;
            } else if(list2 == null) {
                cur = new ListNode(list1.val);
                list1 = list1.next;
            } else if(list1.val <= list2.val) {
                cur = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur = new ListNode(list2.val);
                list2 = list2.next;
            }
            prev.next = cur;
            prev = prev.next;
        }
        return dummy.next;
    }


    //===============================【解法1】========================================

    /**
     * 仅仅参考 归并排序的 merge思路：创建一个新的链表，以dummy开头
     * 每次都遍历一遍lists的每个元素，找出最小的那个链接到dummy，直到全部找完
     * 耗时约206ms
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        while(true) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < min) {
                    minIndex = i;
                    min = lists[i].val;
                }
            }
            if(minIndex >= 0) {
                prev.next = new ListNode(min);
                prev = prev.next;
                lists[minIndex] = lists[minIndex].next;
            } else {
                break;
            }
        }
        return dummy.next;
    }
}
