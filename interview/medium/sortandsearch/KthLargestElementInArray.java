package interview.medium.sortandsearch;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/")
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        KthLargestElementInArray k = new KthLargestElementInArray();
        System.out.println(k.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(k.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

}
