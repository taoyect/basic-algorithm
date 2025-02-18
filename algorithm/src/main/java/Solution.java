
import domain.Student;
import domain.basic.Array;
import lombok.val;
import utils.TestAlgorithmUtil;

import java.util.*;
import java.util.stream.Collectors;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] decode = new int[code.length];
        if (k == 0) return decode;
        int right = k > 0 ? k + 1 : code.length;
        k = Math.abs(k);
        int s = 0;
        for (int i = right - k; i < right; i++) {
            s += code[i];
        }
        for (int i = 0; i < decode.length; i++) {
            decode[i] = s;
            s += code[right % code.length] - code[(right - k) % code.length];
        }
        return decode;
    }

    public boolean hasAllCodes(String s, int k) {
        char[] cArr = s.toCharArray();
        Set<String> uniqueSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cArr.length; i++) {
            sb.append(cArr[i]);
            if (i < (k - 1)) continue;
            uniqueSet.add(sb.toString());
            sb.deleteCharAt(0);
        }
        return !(uniqueSet.size() < Math.pow(2, k));
    }

    public int minSwaps(int[] nums) {
        int wl = 0;
        for (int num : nums) {
            wl += num;
        }
        if (wl == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int exCount = 0;
        for (int i = 0; i < nums.length + wl; i++) {
            if (nums[i % nums.length] == 0) exCount++;
            if (i < (wl - 1)) continue;
            ans = Math.min(ans, exCount);
            if (nums[(i - (wl - 1)) % nums.length] == 0) exCount--;
        }
        return ans;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] cArr = s.toCharArray();
        int wl = minSize;
        Map<String, Integer> strCountMap = new HashMap<>();
        Map<Character, Integer> letterCountMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < cArr.length; i++) {
            //1. 进入窗口
            sb.append(cArr[i]);
            letterCountMap.merge(cArr[i], 1, Integer::sum);
            if (i < (wl - 1)) continue;
            //2. handle
            if (letterCountMap.size() <= maxLetters) {
                String subStr = sb.toString();
                strCountMap.merge(subStr, 1, Integer::sum);
                ans = Math.max(ans, strCountMap.get(subStr));
            }
            //3. 离开窗口
            char out = cArr[i - (wl - 1)];
            sb.deleteCharAt(0);
            if (letterCountMap.merge(out, -1, Integer::sum) == 0) {
                letterCountMap.remove(out);
            }
        }
        return ans;
    }
//
//    public void sortColorsRaw(int[] nums) {
//        int[] cnt = new int[3]; //统计0,1,2三个值出现的次数
//        for (int num : nums) {
//            cnt[num]++;
//        }
//        for (int i = 0; i < cnt[0]; i++) {  //[0, cnt[0])的位置放0
//            nums[i] = 0;
//        }
//        for (int i = cnt[0]; i < cnt[0] + cnt[1]; i++) { //[cnt[0], cnt[0] + cnt[1])的位置放1
//            nums[i] = 1;
//        }
//        for (int i = cnt[0] + cnt[1]; i < nums.length; i++) { //[cnt[0] + cnt[1], nums.length)的位置放2
//            nums[i] = 2;
//        }
//    }
//
//    public void sortColors(int[] nums) {
//        int R = 3;  //元素取值范围:[0,R)
//        int[] cnt = new int[R]; //统计0,1,2三个值出现的次数
//        int[] index = new int[R + 1];
//        for (int num : nums) {
//            cnt[num]++;
//        }
//        //[index[i], index[i+1])    index[i]表示值为i的起始索引
//        for (int i = 0; i < R; i++) {
//            index[i + 1] = index[i] + cnt[i];
//        }
//        for (int i = 0; i + 1 < index.length; i++) {
//            for (int j = index[i]; j < index[i + 1]; j++) {
//                nums[j] = i;
//            }
//        }
//    }


  /*  public static void main(String[] args) {
//        int[] nums = new int[] {2,0,2,1,1,0};
//        new Solution().sortColors(nums);
//        System.out.println(Arrays.toString(nums));
        int n = 26*26*26*26;
        Student[] students = new Student[n];
        int k = 0;
        Random rnd = new Random();
        for (char c1 = 'a'; c1 <= 'z'; c1++)
            for (char c2 = 'a'; c2 <= 'z'; c2++)
                for (char c3 = 'a'; c3 <= 'z'; c3++)
                    for (char c4 = 'a'; c4 <= 'z'; c4++)
                        students[k++] = Student.builder().name("" + c1+c2+c3+c4).score(rnd.nextInt(101)).build();
        int R = 101;
        int[] cnt = new int[R];
        //O(n)
        for (Student student : students) {
            cnt[student.getScore()] ++;
        }

        int[] index = new int[R + 1];
        //O(R)
        for (int i = 0; i < R; i++) {
            index[i + 1] = index[i] + cnt[i];
        }
        Student[] tmp = new Student[n];
        //O(n)
        for (Student student : students) {
            tmp[index[student.getScore()]] = student;
            index[student.getScore()] ++;
        }
        //O(n)
        for (int i = 0; i < n; i++) {
            students[i] = tmp[i];
        }

        //结果O(n + R)
    }*/

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int wl = k;     //滑动窗口长度window length = k
        int BIAS = 50;  //偏移量, 用于计数排序
        int[] cnt = new int[BIAS * 2 + 1];  //因为值域: -50 <= nums[i] <= 50

        for (int i = 0; i < wl - 1; i++) {  // 先往窗口内添加 k-1 个数
            cnt[nums[i] + BIAS]++;
        }
        for (int i = wl - 1; i < n; i++) {  //开始滑动
            cnt[nums[i] + BIAS]++; //1. 第i个元素进入窗口
            int left = x;
            for (int j = 0; j < BIAS; j++) {    // 暴力枚举负数范围 [-50,-1]
                left -= cnt[j];
                //如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数
                if (left <= 0) { //找到美丽值
                    ans[i - (wl - 1)] = j - BIAS;
                    break;
                }
            }
            cnt[nums[i - (wl - 1)] + BIAS]--; // 离开窗口
        }
        return ans;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];
            if (s >= target) {
                ans = 1;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                s += nums[j];
                if (s >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        char[] cArr = s.toCharArray();
        boolean[] has = new boolean[128];
        int ans = 0;
        for (int left = 0, right = 0; right < cArr.length; right++) {
            while (has[cArr[right]]) {
                has[cArr[left++]] = false;
            }
            has[cArr[right]] = true;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int maximumLengthSubstring(String s) {
        char[] cArr = s.toCharArray();
        Map<Character, Integer> cntMap = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < cArr.length; right++) {
            while (cntMap.get(cArr[right]) != null && cntMap.get(cArr[right]) > 1) {
                cntMap.merge(cArr[left++], -1, Integer::sum);
            }
            cntMap.merge(cArr[right], 1, Integer::sum);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int equalSubstring(String s, String t, int maxCost) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int ans = 0;
        int cost = 0;
        for (int left = 0, right = 0; right < sArr.length; right++) {
            cost += Math.abs(sArr[right] - tArr[right]);    //处理当前元素
            while (cost > maxCost) {
                cost -= Math.abs(sArr[left] - tArr[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);  //统计
        }
        return ans;
    }

    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 0;
        char[] sArr = s.toCharArray();
        int preNum = -1;
        int duplicateIndex = -1;
        for (int left = 0, right = 0; right < sArr.length; right++) {
            boolean findDuplicate = preNum == sArr[right];
            if (findDuplicate && duplicateIndex < 0) {   //第一次找到
                duplicateIndex = right; //记录第一次重复的索引下标
            }
            if (findDuplicate && duplicateIndex != right) { //非第一次找到
                left = duplicateIndex;  //移动左指针到 第一次找到的索引处
                duplicateIndex = right; //更新索引
            }
            ans = Math.max(ans, right - left + 1);
            preNum = sArr[right];
        }
        return ans;
    }

    public int totalFruit(int[] fruits) {
        int ans = 0;
        final int FRUIT_BASKET_THRESHOLD = 2;
        Map<Integer, Integer> cntMap = new HashMap<>(); //果篮
        for (int left = 0, right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];   //当前要摘的苹果
            while (!cntMap.containsKey(currentFruit) && cntMap.size() >= FRUIT_BASKET_THRESHOLD) {
                //当果篮中不存在这个种类的水果, 同时果篮已满时
                if (cntMap.merge(fruits[left], -1, Integer::sum) == 0) {
                    cntMap.remove(fruits[left]);
                }
                left++;
            }
            cntMap.merge(currentFruit, 1, Integer::sum);    //将新摘的水果放入果篮
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int s = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (cntMap.containsKey(nums[right])) {
                if (cntMap.merge(nums[left], -1, Integer::sum) == 0) {
                    cntMap.remove(nums[left]);
                }
                s -= nums[left];
                left++;
            }
            cntMap.merge(nums[right], 1, Integer::sum);
            s += nums[right];
            ans = Math.max(ans, s);
        }
        return ans;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int left = 0, right = 0; right < nums.length; right++) {
            while (cntMap.containsKey(nums[right]) && cntMap.get(nums[right]) >= k) {
                if (cntMap.merge(nums[left], -1, Integer::sum) == 0) {
                    cntMap.remove(nums[left]);
                }
                left++;
            }
            cntMap.merge(nums[right], 1, Integer::sum);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            while ((nums[right] - nums[left]) > 2 * k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] cArr = answerKey.toCharArray();
        int ans = 0;
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int left = 0, right = 0; right < cArr.length; right++) {
            cntMap.merge(cArr[right], 1, Integer::sum);
            while (cntMap.getOrDefault('T', 0) > k && cntMap.getOrDefault('F', 0) > k) {
                cntMap.merge(cArr[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int[] cnt = new int[2];
        for (int left = 0, right = 0; right < nums.length; right++) {
            cnt[nums[right]]++;
            while (cnt[0] > k) {
                cnt[nums[left++]]--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int restSum = totalSum - x;
        if (restSum < 0) return -1;
        int ans = -1;
        int s = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            s += nums[right];
            while (s > restSum) s -= nums[left++];
            if (s == restSum) ans = Math.max(ans, right - left + 1);
        }
        return ans < 0 ? ans : nums.length - ans;
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); //排序，升序
        long op = 0;
        int ans = 1;    //1 <= nums.length <= 10^5, 这里right=0, 指向第一个元素
        for (int left = 0, right = 1; right < nums.length; right++) {
            //right指向的元素加入窗口后，增加的操作数
            op += (long) (nums[right] - nums[right - 1]) * (right - left);
            while (op > k) {
                //left指向的元素离开窗口后，减少的操作数
                op -= (nums[right] - nums[left++]);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     * 必须剩下每种字符最多sum-k个，求最长字串
     */
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> totalMap = new HashMap<>();
        for (char c : arr) {
            totalMap.merge(c, 1, Integer::sum);
        }
        if (totalMap.getOrDefault('a', 0) < k || totalMap.getOrDefault('b', 0) < k || totalMap.getOrDefault('c', 0) < k)
            return -1;
        int maxSub = 0;
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int left = 0, right = 0; right < arr.length; right++) {
            cntMap.merge(arr[right], 1, Integer::sum);
            while (cntMap.get(arr[right]) > (totalMap.get(arr[right]) - k)) {
                cntMap.merge(arr[left++], -1, Integer::sum);
            }
            maxSub = Math.max(maxSub, right - left + 1);
        }
        return arr.length - maxSub;
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        //窗口：谁是等值标的，剩余元素个数<=k
        Map<Integer, Integer> cntMap = new HashMap<>();
        int maxCnt = 0;
        int ans = 0;
        for (int left = 0, right = 0; right < nums.size(); right++) {
            //handle current
            cntMap.merge(nums.get(right), 1, Integer::sum);
            maxCnt = Math.max(maxCnt, cntMap.get(nums.get(right)));
            while ((right - left + 1 - maxCnt) > k) {
                cntMap.merge(nums.get(left), -1, Integer::sum);
                left++;
            }
            ans = Math.max(ans, maxCnt);
        }
        return ans;
    }

    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));
//        System.out.println(Arrays.deepToString(tiles));
        int ans = 0;
        int s = 0;
        for (int left = 0, right = 0; right < tiles.length; right++) {
            //加上当前right指向的瓷砖段的瓷砖数
            s += tiles[right][1] - tiles[right][0] + 1;
            //减1是要把覆盖在right自身的除去
            int carpetLeftIndex = tiles[right][1] - (carpetLen - 1);
            while (carpetLeftIndex > tiles[left][1]) {
                s -= tiles[left][1] - tiles[left][0] + 1;
                left++;
            }
            int uncover = Math.max(carpetLeftIndex - tiles[left][0], 0);
            ans = Math.max(ans, s - uncover);
        }
        return ans;
    }

//    public static void main(String[] args) {
////        int[][] titles = TestAlgorithmUtil.parse2DIntArray("[[1,5],[10,11],[12,18],[30,32],[20,25]]");
//        int[][] titles = TestAlgorithmUtil.parse2DIntArray("[[10,11],[1,1]]");
//        int i = maximumWhiteTiles(titles, 2);
//        System.out.println(i);
//    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0;
        int s = 0;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            s += fruits[right][1];
            int posRight = fruits[right][0];
            while (left <= right &&
                    (posRight - fruits[left][0] +
                            Math.min(Math.abs(posRight - startPos), Math.abs(fruits[left][0] - startPos)) > k)) {
                s -= fruits[left][1];
                left++;
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }


    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        char[] cArr = s.toCharArray();
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int left = 0, right = 0; right < cArr.length; right++) {
            cntMap.merge(cArr[right], 1, Integer::sum);
            while (cntMap.get(cArr[right]) > 1) {
                cntMap.merge(cArr[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);

        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, lo, mid, hi);
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi) {
        T[] tmpArr = Arrays.copyOfRange(arr, lo, hi + 1);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                arr[k] = tmpArr[j++ - lo];
            else if (j > hi)
                arr[k] = tmpArr[i++ - lo];
            else if (tmpArr[i - lo].compareTo(tmpArr[j - lo]) < 0)
                arr[k] = tmpArr[i++ - lo];
            else
                arr[k] = tmpArr[j++ - lo];
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = matrix[mid / n][mid % n];
            if(target < midValue) hi = mid - 1;
            else if(target > midValue) lo = mid + 1;
            else return true;
        }
        return false;
    }

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < nums[hi]) hi = mid;
            else lo = mid + 1;
        }
        return nums[hi]; //或者return nums[lo];
    }

    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        int lo = minIndex, hi = minIndex + nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(target < nums[mid % nums.length]) hi = mid - 1;
            else if(target > nums[mid % nums.length]) lo = mid + 1;
            else return mid % nums.length;
        }
        return -1;
    }

    public int findMinIndex(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[arr.length - 1] < arr[mid]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] tmp = new int[totalLength];
        int mid = (tmp.length - 1) / 2;
        int i = 0, j = 0;
        for (int k = 0; k < tmp.length; k++) {
            if(i >= nums1.length)
                tmp[k] = nums2[j++];
            else if(j >= nums2.length)
                tmp[k] = nums1[i++];
            else if(nums1[i] < nums2[j])
                tmp[k] = nums1[i++];
            else
                tmp[k] = nums2[j++];

            if(tmp.length % 2 == 0) {
                if(k == mid + 1) {
                    return (tmp[mid] + tmp[mid + 1]) * 1.0 / 2;
                }
            } else {
                if(k == mid) {
                    return tmp[mid];
                }
            }
        }
        return Double.NaN;
    }

    public static void main(String[] args) {
//        Integer[] x = new Integer[]{12, 4, 12, 4, 5, 6, 2, 9};
//        sort(x, 0, x.length - 1);
//        System.out.println(search(x, 0, x.length - 1, 6));
//        System.out.println(search(x, 0, x.length - 1, 7));
//        System.out.println(search(x, 0, x.length - 1, 12));
//        System.out.println(upper(x, -1));
//        System.out.println(upper(x, 2));
//        System.out.println(upper(x, 12));
//        System.out.println(lower(x, 5)); //2
//        System.out.println(lower(x, 2)); //-1
//        System.out.println(lower(x, 21));//7
//        System.out.println(Arrays.toString(x));
        int[] nums1 = new int[] {1,2};
        int[] nums2 = new int[] {3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
//    public List<Integer> preorder(Node root) {
//        List<Integer> res = new ArrayList<>();
//        preOrderInner(root, res);
//        return res;
//    }
//
//    private void preOrderInner(Node root, List<Integer> res) {
//        if (root == null) return;
//        res.add(root.val);
//        for(Node child : root.children) {
//            preOrderInner(child, res);
//        }
//    }

    public void preorder(Node r) {
        if (r == null) return;
        System.out.print(r.val + " "); // 先访问根节点

        // 然后递归遍历所有子节点
        for (Node child : r.children) {
            preorder(child);
        }
    }


    public List<Integer> postorder(Node r) {
        List<Integer> res = new ArrayList<>();
        postOrderInner(r, res);
        return res;
    }

    private void postOrderInner(Node r, List<Integer> res) {
        if(r == null) return;
        for (Node child : r.children) {
            postOrderInner(child, res);
        }
        res.add(r.val);
    }



}
