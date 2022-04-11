package leecode.stack;


import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('(' == c || '{' == c || '[' == c) {
                stack.push(c);
            } else {
                //不能直接pop，空的时候会抛EmptyStackException
                if(stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if(c == ')' && top != '(')
                    return false;
                if(c == '}' && top != '{')
                    return false;
                if(c == ']' && top != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid( "()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}