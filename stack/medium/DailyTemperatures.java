package stack.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Arrays;
import java.util.Stack;

@Question(url = "https://leetcode.com/problems/daily-temperatures/")
@Enhance(reduce = {Stat.TIME, Stat.SPACE})
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] answer = new int[T.length];
        Stack<Integer> tempStack = new Stack<>();
        for (int t = 0; t < T.length; t++) {
            while (!tempStack.isEmpty() && T[tempStack.peek()] < T[t]) answer[tempStack.peek()] = t - tempStack.pop();
            tempStack.push(t);
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures dT = new DailyTemperatures();
        System.out.println(Arrays.toString(dT.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

}
