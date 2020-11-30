package stack.easy;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

@Question(url = "https://leetcode.com/problems/next-greater-element-i/")
@Enhance(reduce = Stat.TIME, updated = true)
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < nums1.length; i ++) hashMap.put(nums1[i], i);

        for (int i : nums2) {
            while (!stack.isEmpty() && i > stack.peek()) {
                if (hashMap.containsKey(stack.peek())) answer[hashMap.get(stack.peek())] = i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            if (hashMap.containsKey(stack.peek())) answer[hashMap.get(stack.peek())] = -1;
            stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        NextGreaterElementI nGE = new NextGreaterElementI();
        System.out.println(Arrays.toString(nGE.nextGreaterElement(new int[] {4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nGE.nextGreaterElement(new int[] {2,4}, new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(nGE.nextGreaterElement(new int[] {}, new int[]{1,2,3,4})));
    }
}
