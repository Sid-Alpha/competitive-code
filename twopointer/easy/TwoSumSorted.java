package twopointer.easy;

import utils.info.Question;

import java.util.Arrays;

@Question(url = "https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/")
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i+1, j+1};
            }
            else if ((numbers[i] + numbers[j]) > target) j--;
            else i++;
        }
        return new int[] {0,0};
    }

    public static void main(String[] args) {
        TwoSumSorted twoSum = new TwoSumSorted();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 3, 4}, 6)));
    }
}
