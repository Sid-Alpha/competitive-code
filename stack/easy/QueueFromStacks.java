package stack.easy;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(url = "https://leetcode.com/problems/implement-queue-using-stacks/")
@Enhance(reduce = Stat.SPACE, updated = true)
public class QueueFromStacks {

        private Stack<Integer> primary, secondary;
        private boolean pushed = false, popped = false;

        /**
         * Initialize your data structure here.
         */
        public QueueFromStacks() {
            primary = new Stack<>();
            secondary = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (!primary.isEmpty() && !pushed) transfer();

            primary.push(x);
            pushed = true;
            popped = false;
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!primary.isEmpty() && !popped) transfer();
            pushed = false;
            popped = true;

            return primary.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!primary.isEmpty() && !popped) transfer();
            pushed = false;
            popped = true;

            return primary.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return primary.isEmpty();
        }

        public void transfer() {
            Stack<Integer> temp;
            while (!primary.isEmpty()) secondary.push(primary.pop());
            temp = primary;
            primary = secondary;
            secondary = temp;
        }

    public static void main(String[] args) {
        QueueFromStacks queue = new QueueFromStacks();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
