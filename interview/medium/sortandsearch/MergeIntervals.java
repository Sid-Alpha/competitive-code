package interview.medium.sortandsearch;

import utils.info.Question;
import utils.info.Unfinished;
import utils.info.UsedHints;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/")
@UsedHints
@Unfinished
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        return null;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(arr1)));
    }
}
