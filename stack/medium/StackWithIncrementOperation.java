package stack.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/design-a-stack-with-increment-operation/")
@Enhance(reduce = Stat.TIME, details = "Try removing the pair creation?")
public class StackWithIncrementOperation {
    private static class CustomStack {

        private final Stack<Pair<Integer, Integer>> stack;
        private final int maxSize;

        public CustomStack(int maxSize) {
            this.stack = new Stack<>();
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (stack.size() == maxSize) return;
            stack.push(new Pair<>(x, 0));
        }

        public int pop() {
            if (stack.size() == 0) return -1;
            if (stack.size() != 1) stack.elementAt(stack.size()-2).second += stack.peek().second;
            return stack.peek().first + stack.pop().second;
        }

        public void increment(int k, int val) {
            if (stack.size() == 0) return;
            int i = k;
            if (k > stack.size()) i = stack.size();
            stack.elementAt(i - 1).second += val;
        }
    }

    static class Pair<K, V> {
        public K first;

        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + " : " + second;
        }
    }

    public static void main(String[] args) {
        CustomStack swio = new CustomStack(4);
        swio.push(1);
        swio.push(2);
        System.out.println(swio.pop());
        swio.push(2);
        swio.push(3);
        swio.push(4);
        swio.increment(5, 100);
        swio.increment(2, 100);
        System.out.println(swio.pop());
        System.out.println(swio.pop());
        System.out.println(swio.pop());
        System.out.println(swio.pop());
    }
}
