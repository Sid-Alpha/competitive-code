package interview.medium.sortandsearch;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.NewAlgo;
import utils.info.Question;

import java.util.Arrays;

@Question(
        url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/",
        details= "Could you come up with a one-pass algorithm using only constant space?"
)
@NewAlgo(details = "Counting sort")
@Enhance(complexity = Stat.TIME, details = "Make it single pass")
public class SortColors {

    public void sortColors(int[] nums) {
        int [] counts = new int[3];
        for(int num : nums) counts[num]++;

        int countIndex = 0, arrIndex = 0;
        while(countIndex < 3) {
            while (counts[countIndex]-- > 0) {
                nums[arrIndex++] = countIndex;
            }
            countIndex++;
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[]   arr1 = {2,0,2,1,1,0},
                arr2 = {1,0};

        sortColors.sortColors(arr1);
        sortColors.sortColors(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr1));
    }

}
