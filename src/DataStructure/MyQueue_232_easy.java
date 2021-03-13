package DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue_232_easy {
    // stack1用来做中间转换
    // stack2用来存储最终的数据

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue_232_easy() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) return -1;
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) return -1;
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty();
    }

}
