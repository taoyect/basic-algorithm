import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <T extends Comparable<T>> List<T> sort(List<T> list1, List<T> list2) {
        int length = list1.size() + list2.size();
        ArrayList<T> res = new ArrayList<>();
        int i = 0, j = 0;
        for(int k = 0; k < length; k++) {
            if(i >= list1.size()) {
                res.add(list2.get(j++));
            } else if(j >= list2.size()) {
                res.add(list1.get(i++));
            } else if(list1.get(i).compareTo(list2.get(j)) < 0) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(4);
        integers1.add(6);
        integers1.add(8);
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(5);
        integers2.add(7);
        List<Integer> list = sort(integers1, integers2);
        System.out.println(list);
    }





}
