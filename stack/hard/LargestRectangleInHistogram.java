package stack.hard;

import javafx.util.Pair;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Stack;

@Question(
        url = "https://leetcode.com/problems/largest-rectangle-in-histogram/",
        details = "Try other solutions"
)
@Enhance(reduce = Stat.TIME, complexity = Stat.TIME, details = "Optimal substructure")
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int max = 0, killCount;
        stack.push(new Pair<>(0, 0));
        for (int i = 1; i < heights.length; i++) {
            killCount = 0;
            while (!stack.isEmpty() && heights[i] < heights[stack.peek().getKey()]) {
                max = Math.max(max, heights[stack.peek().getKey()] * (i - stack.peek().getKey() + stack.peek().getValue()));
                killCount += 1 + stack.pop().getValue();
            }

            stack.push(new Pair<>(i, killCount));
        }
        while (!stack.isEmpty())
            max = Math.max(max, heights[stack.peek().getKey()] * (heights.length - stack.peek().getKey() + stack.pop().getValue()));

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[] {2,1,5,6,2,3}));  //10
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[] {1}));    // 1
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[] {2,1,2}));    // 3
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[] {3,6,5,7,4,8,1,0}));  // 20
    }

}
