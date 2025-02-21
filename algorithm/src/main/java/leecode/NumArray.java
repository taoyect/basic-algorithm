package leecode;

/**
 * @author ct
 * @date 2025-02-21 16:35
 */
public class NumArray {
    int[] s;

    public NumArray(int[] nums) {
        s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}
