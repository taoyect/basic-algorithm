

public class Main {

    public static <T extends Comparable<T>> int upper(T[] arr, T target) {
        if(target == null) return -1;
        int lo = 0, hi = arr.length;
        while(lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if(arr[mid].compareTo(target) <= 0)
                lo = mid + 1;
            else
                hi = mid;
        }
        return hi;
    }

    public static <T extends Comparable<T>> int search(T[] arr, int lo, int hi, T target) {
        if(lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if(arr[mid].compareTo(target) > 0)
            return search(arr, lo, mid - 1, target);
        else if(arr[mid].compareTo(target) < 0)
            return search(arr, mid + 1, hi, target);
        return mid;
    }




    public static void main(String[] args) {
//        Integer[] integers = ArrayGenerator.generateRandomIntegerArray(7, 10);
//        QuickSort.sort3Ways(integers);
//        System.out.println(Arrays.toString(integers));
        Integer[] integers1 = {0, 0, 0, 2, 2, 7, 8};
        System.out.println(upper(integers1, 3));
//        System.out.println(Arrays.toString(integers));
    }





}
