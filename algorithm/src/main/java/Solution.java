
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

    public int lengthOfLongestSubstring(String s) {
        char[] cArr = s.toCharArray();
        Map<Character, Integer> cntMap = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < cArr.length; right++) {
            while (cntMap.get(cArr[right]) != null && cntMap.get(cArr[right]) > 0) {
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


//    private void swap(int[] nums, int a, int b) {
//        if (a == b) return;
//        nums[a] = nums[a] ^ nums[b];
//        nums[b] = nums[a] ^ nums[b];
//        nums[a] = nums[a] ^ nums[b];
//    }
//
//    public static <T> void swap(T[] arr, int a, int b) {
//        T tmp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = tmp;
//    }

//    public void sortColors(int[] nums) {
//        if(nums == null) return;
//        sort(nums, 0, nums.length);
//    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargest(int[] arr, int lo, int hi, int k) {
        while(lo <= hi) {
            int p = partition(arr, lo, hi);
            if(k == p) return arr[p];
            if(k > p) lo = p + 1;
            else hi  = p - 1;
        }
        return Integer.MIN_VALUE;
    }
//    public int findKthLargest(int[] arr, int lo, int hi, int k) {
//        if(lo > hi) return Integer.MIN_VALUE;
//        int p = partition(arr, lo, hi);
//        if(k == p) return arr[p];
//        if(k > p) return findKthLargest(arr, p + 1, hi, k);
//        else return findKthLargest(arr, lo, p - 1, k);
//    }

    public int partition(int[] arr, int lo, int hi) {
        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if(arr[i] < arr[lo])
                swap(arr, i, ++j);
        }
        swap(arr, lo, j);
        return j;
    }
    public void swap(int[] arr, int a, int b) {

        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }

//    public void moveZeroes(int[] nums) {
//        int i = 0, j = 0;
//        while (j < nums.length) {
//            if(nums[j] != 0)
//                swap(nums, i++, j);
//            j++;
//        }
//    }

    public static void main(String[] args) {
        int[] x = new int[]{0,1,0,3,12};
//        new Solution().moveZeroes(x);
        System.out.println(Arrays.toString(x));
    }

    public static int partition(int[] arr, int lo, int hi) {
        //通过随机处理，避免在数组近乎或完全有序的极端情况下，算法退化成O(n^2)，且递归深度为O(n)，导致栈溢出
        int randomIndex = new Random().nextInt(hi - lo + 1) + lo;
        swap(arr, randomIndex, lo);

        int flag = arr[lo];
        int j = lo;
        for(int i = lo + 1; i <= hi; i++) //一直遍历到结尾
            if(arr[i] < flag)
                swap(arr, ++j, i);
        swap(arr, lo, j);
        return j;
    }
}
