package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ct
 * @date 2025-02-13 14:16
 */
public class TestAlgorithmUtil {

    public static int[][] parse2DIntArray(String input) {
        // 去掉最外层的 []
        input = input.trim().replaceAll("^\\[\\[|\\]\\]$", "");

        // 拆分每一组 [a,b]
        String[] pairs = input.split("\\],\\[");

        List<int[]> list = new ArrayList<>();
        for (String pair : pairs) {
            // 拆分 a,b 并转换为 int
            String[] nums = pair.split(",");
            int[] arr = {Integer.parseInt(nums[0]), Integer.parseInt(nums[1])};
            list.add(arr);
        }

        // 转换为 int[][] 数组
        return list.toArray(new int[0][]);
    }
}
