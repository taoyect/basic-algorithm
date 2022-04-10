package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

public class Analysis {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize) {
            Integer[] integers = ArrayGenerator.generateRandomIntegerArray(n, n);
            SortingHelper.testSort("SelectionSort", Arrays.copyOf(integers, integers.length));
            SortingHelper.testSort("InsertionSort", Arrays.copyOf(integers, integers.length));
        }
    }
}
