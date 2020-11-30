package interview.medium.dp;

import utils.info.Enhance;
import utils.info.NewAlgo;
import utils.info.Question;

import java.util.Arrays;

@Question(
        url = "https://leetcode.com/explore/featured/card/top-interview-questions-medium/111/dynamic-programming/810/"
)
@Enhance(details = "Time complexity to n log (n)")
@NewAlgo(details = "n log (n) solution for LIS")
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] aux = new int[nums.length];
        Arrays.fill(aux, 1);
        for(int i = 1 ; i < nums.length; i++) {
            for(int j = 0; j < i; j++)
                if(nums[j] < nums[i] && aux[j] + 1 > aux[i]) aux[i] = aux[j] + 1;
        }
        int max = 0;
        for(int val : aux)
            if (val > max) max = val;
        return max;
    }

}
