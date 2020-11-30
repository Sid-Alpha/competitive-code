package interview.easy.array;

import java.util.Arrays;

public class singleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums) {
            res = res ^ i;
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,2,1,2}, arr2 = {2,2,1};
        System.out.println(singleNumber(arr1));
        System.out.println(singleNumber(arr2));
    }
}
