package leecode.stack;

import java.util.ArrayDeque;
import java.util.Objects;

class MinStack {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> helper;

    public MinStack() {
        stack = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if(helper.isEmpty() || (helper.peek() >= val)) {
            helper.push(val);
        }
    }

    public void pop() {
        if (Objects.equals(stack.pop(), helper.peek()))
            helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
