package offer;

import List.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack_30_easy {
    Deque<Integer> mainStack;
    Deque<Integer> assistStack;
    public MinStack_30_easy() {
        mainStack = new LinkedList<>();
        assistStack = new LinkedList<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (assistStack.isEmpty()){
            assistStack.push(x);
        } else if (x < assistStack.peek()){
            assistStack.push(x);
        } else {
            assistStack.push(assistStack.peek());
        }
    }

    public void pop() {
        // 如果弹出的是最小的，那么辅助栈也要弹出,不是最小的也得弹出啊
        mainStack.pop();
        assistStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return assistStack.peek();
    }

}
