package interview.medium.array;

import utils.info.Question;
import utils.info.Unfinished;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/")
@Unfinished(details = "BS")
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        for(int i = 0; i < nums.length; i++)
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && lis[i] <= lis[j]) {
                    lis[i] = lis[j] + 1;
                    if(lis[i] >= 3) return true;
                }
            }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        System.out.println(i.increasingTriplet(new int[] {1,2,3,4,5})); // true
        System.out.println(i.increasingTriplet(new int[] {5,4,3,2,1})); // false
        System.out.println(i.increasingTriplet(new int[] {0,4,2,1,0,-1,-3}));   // false
        System.out.println(i.increasingTriplet(new int[] {2,1,5,0,4,6}));  // true
    }
}
