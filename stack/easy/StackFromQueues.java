package stack.easy;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.LinkedList;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/implement-stack-using-queues/")
@Enhance(reduce = Stat.SPACE, updated = true)
public class StackFromQueues {

    Queue<Integer> primary, secondary, temp;

    /** Initialize your data structure here. */
    StackFromQueues() {
        primary = new LinkedList<>();
        secondary = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        primary.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        temp = primary;
        while (primary.size() > 1) secondary.add(primary.poll());
        primary = secondary;
        secondary = temp;
        return temp.poll();
    }

    /** Get the top element. */
    public int top() {
        temp = primary;
        int i;
        while (primary.size() > 1) secondary.add(primary.poll());
        i = primary.peek();
        secondary.add(primary.poll());
        primary = secondary;
        secondary = temp;

        return i;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return primary.isEmpty();
    }


    public static void main(String[] args) {
        StackFromQueues stackFromQueues = new StackFromQueues();
        stackFromQueues.push(1);
        stackFromQueues.push(2);
        System.out.println(stackFromQueues.top());
        System.out.println(stackFromQueues.pop());
        System.out.println(stackFromQueues.empty());
        System.out.println(stackFromQueues.top());
        System.out.println(stackFromQueues.pop());

        stackFromQueues.push(1);
        stackFromQueues.push(2);
        System.out.println(stackFromQueues.top());
        stackFromQueues.push(3);
        stackFromQueues.push(4);
        System.out.println(stackFromQueues.top());
        System.out.println(stackFromQueues.pop());
        System.out.println(stackFromQueues.pop());
        System.out.println(stackFromQueues.pop());
        System.out.println(stackFromQueues.pop());
    }
}
