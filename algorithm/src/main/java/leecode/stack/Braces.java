package leecode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Braces {
    public static String[] braces(String[] arr) {
        String[] retArr = new String[arr.length];
        for(int i = 0; i < arr.length; i++)
            retArr[i] = brace(arr[i]);
        return retArr;
    }

    private static String brace(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if('(' == c || '{' == c || '[' == c)
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return "NO";
                Character top = stack.pop();
                if('(' == top && ')' != c)
                    return "NO";
                if('{' == top && '}' != c)
                    return "NO";
                if('[' == top && ']' != c)
                    return "NO";
            }
        }
        if(stack.isEmpty())
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        String[] strings = {"{}[]()", "{[}]}"};
        System.out.println(Arrays.toString(braces(strings)));
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(scanner.nextLine());
            while (n < 1 || n > 15) {
                System.out.println("numbers of array must >=1 and <=15, please input it again!");
                n = Integer.parseInt(scanner.nextLine());
            }
            String[] arrA = new String[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = scanner.nextLine();
                while (arrA[i] != null
                        && (arrA[i].length() < 1 || arrA[i].length() > 100)) {
                    System.out.println("the string length must >=1 and <=100, please input it again!");
                    arrA[i] = scanner.nextLine();
                }
            }
            System.out.println(Arrays.toString(braces(arrA)));
        }
    }

    static class Stack<E> {
        private final ArrayList<E> arrayList;

        public Stack(int capacity) {
            arrayList = new ArrayList<>(capacity);
        }
        public Stack() {
            this(10);
        }
        public int getSize() {
            return arrayList.size();
        }
        public boolean isEmpty() {
            return getSize() == 0;
        }

        public void push(E e) {
            arrayList.add(e);
        }
        public E pop() {
            return arrayList.remove(arrayList.size() - 1);
        }
        public E peek() {
            return arrayList.get(arrayList.size() - 1);
        }
    }
}
