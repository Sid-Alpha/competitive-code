package interview.easy.dp;

import utils.info.Enhance;


@Enhance(details = "Solve as divide & conquer")
public class maxSubArray {

    public int maxSubArrayDP(int[] nums) {
        int lastMax, max = nums[0];
        lastMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lastMax = (nums[i] > lastMax + nums[i]) ? nums[i] : nums[i] + lastMax;
            if(lastMax > max) max = lastMax;
//            System.out.println(lastMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[]
                arr1 = {-2,1,-3,4,-1,2,1,-5,4},
                arr2 = {1, 2}
        ;

        System.out.println(new maxSubArray().maxSubArrayDP(arr1));
        System.out.println(new maxSubArray().maxSubArrayDP(arr2));
    }
}
