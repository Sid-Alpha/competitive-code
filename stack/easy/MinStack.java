package stack.easy;

import javafx.util.Pair;
import utils.info.Question;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/min-stack/")
public class MinStack {

    Stack<Pair<Integer, Integer>> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(new Pair<>(x, stack.isEmpty() ? x : Math.min(x, stack.peek().getValue())));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
    }

    public static void main(String[] args) {

         MinStack obj = new MinStack();
         obj.push(-2);
         obj.push(0);
         obj.push(-3);
        System.out.println(obj.getMin());
         obj.pop();
         System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

}
