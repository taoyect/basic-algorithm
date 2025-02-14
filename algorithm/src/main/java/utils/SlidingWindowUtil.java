package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ct
 * @date 2025-02-13 10:33
 */
public class SlidingWindowUtil {

    public static int elementMaxFrequencySubLength(char[] arr, int maxFrequency) {
        int ans = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int left = 0, right = 0; right < arr.length; right++) {
            countMap.merge(arr[right], 1, Integer::sum);
            while (countMap.get(arr[right]) > maxFrequency) {
                countMap.merge(arr[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static int elementMaxFrequencySubLength(int[] arr, int maxFrequency) {
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int left = 0, right = 0; right < arr.length; right++) {
            countMap.merge(arr[right], 1, Integer::sum);
            while (countMap.get(arr[right]) > maxFrequency) {
                countMap.merge(arr[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static <T> int elementMaxFrequencySubLength(T[] arr, int maxFrequency) {
        int ans = 0;
        Map<T, Integer> countMap = new HashMap<>();
        for (int left = 0, right = 0; right < arr.length; right++) {
            countMap.merge(arr[right], 1, Integer::sum);
            while (countMap.get(arr[right]) > maxFrequency) {
                countMap.merge(arr[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static Character[] toCharacterArray(String s) {
        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }
        return charArray;
    }
}
