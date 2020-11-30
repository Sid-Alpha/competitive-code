package twopointer.medium;

import utils.info.NewAlgo;
import utils.info.Question;

@Question(url = "https://leetcode.com/problems/max-consecutive-ones-iii/")
@NewAlgo(details = "Simple sliding window methods")
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        int start = 0, end;
        for (end = 0; end < A.length; end++) {
            if (A[end] == 0) K--;
            if (K < 0 && A[start++] == 0) K++;
        }

        return end - start;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1}, 0));
    }
}
