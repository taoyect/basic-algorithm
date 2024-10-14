package leecode.link;

import java.util.*;

public class LM_1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<int[]> list = new ArrayList<>();    // 存储已找到“下一个更大节点"的节点编号和更大值{id, greaterVal}
        Deque<int[]> stack = new ArrayDeque<>(); // 单调栈，存储还没有找到下一个更大节点的节点编号和节点值{id, val}
        int idx = 0;
        while (head != null) {
            while (!stack.isEmpty() && stack.peek()[1] < head.val) { // 栈不为空且栈顶节点值小于当前节点值
                list.add(new int[]{stack.pop()[0], head.val}); //当前节点即是栈顶节点的下一个更大节点，弹出栈顶元素
            }
            stack.push(new int[]{idx, head.val});   // 将当前节点压入栈，它是当前栈内的最小值
            head = head.next;
            idx++;
        }
        int[] arr = new int[idx];
        for(int[] item : list) {
            arr[item[0]] = item[1]; //list列表中每个二元数组都存储编号为item[0]的节点的下一个更大节点值item[1]
        }   //编号不在list中的节点就是没有下一个更大节点值，默认为0
        return arr;
    }



    /**
     * 超时
     */
    public int[] nextLargerNodes1(ListNode head) {
        ListNode h = head;
        int s = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (h != null) {
            map.put(s, h);
            s++;
            h = h.next;
        }
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            int max = map.get(i).val;
            for (int j = i + 1; j < s; j++) {
                if (map.get(j).val > max) {
                    max = map.get(j).val;
                    break;
                }
            }
            arr[i] = max > map.get(i).val ? max : 0;
        }
        return arr;
    }
}
