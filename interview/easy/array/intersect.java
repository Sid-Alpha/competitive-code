package interview.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);
        List<Integer> finalArr = new ArrayList<>();
        int i=0, j=0;
        while(i<nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                finalArr.add(nums1[i]); i++; j++;
            }
            else if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        int[] arr = new int[finalArr.size()];
        // ArrayList to Array Conversion
        for (int k = 0; k < finalArr.size(); k++)
            arr[k] = finalArr.get(k);

        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,9,5}, arr2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(arr1, arr2)));

        int[] arr3 = {1,2,2,1}, arr4 = {2,2};
        System.out.println(Arrays.toString(intersect(arr3, arr4)));
    }
}
