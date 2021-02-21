import java.util.Stack;

class MinStack {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stackOfMins = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        stack1.push(x);

        if (stackOfMins.isEmpty() || x <= stackOfMins.peek()) {
            stackOfMins.push(x);
        } else {
            stackOfMins.push(stackOfMins.peek());
        }
    }

    public void pop() {
        stackOfMins.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stackOfMins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */