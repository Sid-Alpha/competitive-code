package interview.easy.array;

import java.util.Arrays;

public class duplicatesFromSortedArray {


    public static int removeDuplicates(int[] nums) {
        int i = 0, j, totalCount=0;
        while(i < nums.length) {
            j=i;
            while(j+1<nums.length && nums[i] == nums[j+1]) j++;
            System.out.println(i + ":" + j);
            if(i!=j) {
                shiftArray(nums, i, j-i);
                System.out.println(Arrays.toString(nums));
            }
                i++;
        }
        i=0;
        while(i+1 < nums.length && nums[i]!=nums[i+1]) {
            totalCount ++;
            i++;
        }
        return totalCount + 1;
    }

    private static void shiftArray(int[] nums, int startpos, int jump) {
        int s = startpos+1;
        while(s+jump < nums.length) {
            nums[s] = nums[s+jump];
            s++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,1,1,2};
        System.out.println("len " + removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
    }
}
