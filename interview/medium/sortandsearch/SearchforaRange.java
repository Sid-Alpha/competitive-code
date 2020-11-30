package interview.medium.sortandsearch;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/")
@Enhance(complexity = Stat.SPACE)
public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        if(nums.length == 1 && nums[0] == target) return new int[] {0, 0};

        int left = -1, right = -1;

        compute: {
            int low = 0, high = nums.length-1, mid;
            // binary left
            while(low <= high) {
                mid = (low + high)/2;
                if(nums[mid] == target && (mid - 1 < 0 || nums[mid-1] != nums[mid])) { left = mid; break;}
                else if(nums[mid] > target) high = mid - 1;
                else if(nums[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
            if (left == -1) break compute;

            // binary right
            low = 0;
            high = nums.length-1;

            while(low <= high) {
                mid = (low + high)/2;
                if(nums[mid] == target && (mid + 1 >= nums.length || nums[mid+1] != nums[mid]))
                { right = mid; break;}
                else if(nums[mid] > target) high = mid - 1;
                else if(nums[mid] < target) low = mid + 1;
                else low = mid + 1;
            }
        }

        return new int[] {left, right};
    }

    public static void main(String[] args) {
        SearchforaRange searchforaRange = new SearchforaRange();
        System.out.println(Arrays.toString(searchforaRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchforaRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchforaRange.searchRange(new int[]{2, 2}, 2)));
    }


}
