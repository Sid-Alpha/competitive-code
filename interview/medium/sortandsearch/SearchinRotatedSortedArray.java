package interview.medium.sortandsearch;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/804/")
@Enhance(complexity = {Stat.TIME, Stat.SPACE}, details = "Remove the recursion")
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return hydraSearch(nums, target, 0, nums.length-1);
    }

    private int hydraSearch(int[] nums, int target, int low, int high) {
        while(high >= low) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[high] < nums[low])
                return Math.max(hydraSearch(nums, target, low, mid-1), hydraSearch(nums, target, mid+1, high));
            else if (nums[mid] > target) return hydraSearch(nums, target, low, mid-1);
            else return hydraSearch(nums, target, mid+1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray search = new SearchinRotatedSortedArray();
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 4));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 5));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 6));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 7));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 1));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 2));
        System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 99));
    }

}
