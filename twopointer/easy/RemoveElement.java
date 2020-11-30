package twopointer.easy;

import utils.info.Question;

import java.util.Arrays;

@Question(url = "https://leetcode.com/problems/remove-element/")
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        // if val encountered, count++ && subsequent elements { arr[i-count] = arr[]i}
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == val) count++;
            else nums[i-count] = nums[i];

        return nums.length - count;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] num1 = new int[] {3,2,2,3};
        System.out.println(removeElement.removeElement(num1, 3));
        System.out.println(Arrays.toString(num1));
        int[] num2 = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(removeElement.removeElement(num2, 2));
        System.out.println(Arrays.toString(num2));
    }
}
