package interview.easy.array;

import utils.info.Enhance;

import java.util.Arrays;

@Enhance(details = "Decrease exec time")
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
//        int[] finalArr = new int[nums.length];
//        int counter = 0;
//        for(int num : nums) {
//           if(num != 0) {
//               finalArr[counter++] = num;
//           }
//        }
//

//        #2
        int zeroFinder = 0, nonZeroFinder= 0;
        while(zeroFinder < nums.length) {
            while(zeroFinder < nums.length && nums[zeroFinder] != 0) zeroFinder++;
            nonZeroFinder = zeroFinder;

            while(nonZeroFinder < nums.length && nums[nonZeroFinder] == 0) nonZeroFinder++;
            if(nonZeroFinder >= nums.length) break;
            swap(nums, zeroFinder, nonZeroFinder);
            zeroFinder++;
        }

    }


    public static void swap(int[] arr, int swapIndex1, int swapIndex2) {
        int temp;
        temp = arr[swapIndex1];
        arr[swapIndex1] = arr[swapIndex2];
        arr[swapIndex2] = temp;

    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {0,1,0,3,12}; // {1,3,12,0,0}
        int[] arr2 = new int[] {1,0,3,0,5}; // {1,3,5,0,0}
        moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr1));
    }
}
