package twopointer.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

@Question(url = "https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/")
@Enhance(reduce = {Stat.SPACE})
public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int slowPtr = 0, fastPtr = 0, currentNum = nums.length == 0 ? -1 : nums[0], currCount = 0;
        for (int n : nums) {
            if (currentNum != n) {
                currCount = 1;
                currentNum = n;
                nums[slowPtr++] = nums[fastPtr++];
            }
            else if (currCount < 2) {
                nums[slowPtr++] = nums[fastPtr++];
                currCount++;
            }
            else fastPtr++;
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII remove = new RemoveDuplicatesfromSortedArrayII();
        System.out.println(remove.removeDuplicates(new int[] {1,1,1,2,2,3}));   // 5
        System.out.println(remove.removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3})); // 7
        System.out.println(remove.removeDuplicates(new int[] {}));     // 0
    }
}
