package interview.medium.sortandsearch;

import utils.info.Question;
import utils.info.UsedHints;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/801/")
@UsedHints
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int i;
        for(i = 0; i < nums.length - 1; i++) if(nums[i+1] < nums[i]) return i;
        return i;
    }

    public static void main(String[] args) {
        FindPeakElement peakElement = new FindPeakElement();
        System.out.println(peakElement.findPeakElement(new int[] {1,2,3,1}));   // 2
        System.out.println(peakElement.findPeakElement(new int[] {1,2,1,3,5,6,4}));  // 1 or 5
        System.out.println(peakElement.findPeakElement(new int[] {1,1,4}));  // 1 or 5
    }
}
