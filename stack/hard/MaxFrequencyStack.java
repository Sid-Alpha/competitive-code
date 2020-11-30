package stack.hard;

import utils.info.Question;
import utils.info.Unfinished;

@Question(url = "https://leetcode.com/problems/maximum-frequency-stack/")
@Unfinished
public class MaxFrequencyStack {

    public static class FreqStack {
//        push(int x), which pushes an integer x onto the stack.
//        pop(), which removes and returns the most frequent element in the stack.
//        If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
        // Use TreeSet & let freq decide sorting order

        public FreqStack() {

        }

        public void push(int x) {

        }

        public int pop() {
            return 0;
        }

    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
    }

}
