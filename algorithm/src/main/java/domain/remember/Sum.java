package domain.remember;

/**
 * @author ct
 * @date 2024-06-06 17:48
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(0, arr.length - 1, arr);
    }

    private static int sum(int lo, int hi, int[] arr) {
        if(lo > hi) return 0;
        return arr[lo] + sum(lo + 1, hi, arr);
    }

}
