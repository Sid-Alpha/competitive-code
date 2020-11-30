package stack.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Arrays;
import java.util.Stack;

@Question(url = "https://leetcode.com/problems/next-greater-element-ii/")
@Enhance(reduce = Stat.SPACE)
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int[] answer = new int[nums.length];
//        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        for (int n = 0; n < nums.length; n++) {
            while (!s.isEmpty() && nums[n] > nums[s.peek()])
                answer[s.pop()] = nums[n];
            s.push(n);
        }

        for (int num : nums)
            while (!s.isEmpty() && num > nums[s.peek()])
                answer[s.pop()] = num;

        while (!s.isEmpty()) answer[s.pop()] = -1;
        return answer;
    }

    public static void main(String[] args) {
        NextGreaterElementII nge2 = new NextGreaterElementII();
        System.out.println(Arrays.toString(nge2.nextGreaterElements(new int[] {1,2,1})));
//        System.out.println(Arrays.toString(nge2.nextGreaterElements(new int[] { })));
//        System.out.println(Arrays.toString(nge2.nextGreaterElements(new int[] { })));
    }
}
