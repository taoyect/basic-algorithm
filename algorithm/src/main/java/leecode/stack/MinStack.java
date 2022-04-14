package leecode.stack;

import java.util.Objects;
import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
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
