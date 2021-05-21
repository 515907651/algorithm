package offer;

import List.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack_30_easy {
    // 思路就是建立两个栈，一个栈a用来存放所有数据，另一个栈b存放最小值
    // 当加入值时，如果比最小值小，就加入最小栈，否则最小栈再加入一个最小值
    // pop时，两栈都pop
    // gettop就返回a的栈顶数据，getmin就返回b的栈顶元素
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
