package twopointer.medium;

import utils.info.NewAlgo;
import utils.info.Question;
import utils.info.Unfinished;

@Question(url = "https://leetcode.com/problems/find-the-duplicate-number/")
@NewAlgo(details = "Floyd's Tortoise and Hare (Cycle Detection)",
        learningSource = "https://leetcode.com/problems/find-the-duplicate-number/solution/")
@Unfinished(details = "Try with new algo")
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        return -1;
    }

    public static void main(String[] args) {
        FindtheDuplicateNumber findtheDuplicateNumber = new FindtheDuplicateNumber();
        System.out.println(findtheDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findtheDuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findtheDuplicateNumber.findDuplicate(new int[]{1, 1}));
    }

}
