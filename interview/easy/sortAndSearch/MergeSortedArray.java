package interview.easy.sortAndSearch;

import utils.info.Enhance;

import java.util.Arrays;

@Enhance(details = "Reduce time")
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) return;
        int i = 0, j = 0;
        while(true) {
            if (i == m) {
                while (i < nums1.length) nums1[i++] = nums2[j++];
                return;
            }
            if(nums1[i] > nums2[j]) {
                swapAndArrange(nums1, i++, nums2, j);
                continue;
            }
            i++;
        }

    }

    private static void swapAndArrange(int [] nums1, int m, int[] nums2, int n) {
        int swapVar = nums1[m];
        nums1[m] = nums2[n];
        nums2[n] = swapVar;
        while(n+1 < nums2.length && nums2[n] > nums2[n+1]) {
            swapVar = nums2[n];
            nums2[n] = nums2[n+1];
            nums2[n+1] = swapVar;
            n++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 8, 10, 0, 0, 0, 0};
        int[] b = new int[] {1, 1, 1, 1};
        merge(a, 4, b, 4);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

        int[] wrong = new int[]{-10,-10,-9,-9,-9,-8,-8,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-3,-3,-2,-2,-1,-1,0,1,1,1,2,2,2,3,3,3,4,5,5,6,6,6,6,7,7,7,7,8,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] wrong2 = new int[]{-10,-10,-9,-9,-9,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-7,-7,-7,-7,-6,-6,-6,-6,-5,-5,-5,-5,-5,-4,-4,-4,-4,-4,-3,-3,-3,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,0,0,0,0,0,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,4,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,7,8,8,8,8,9,9,9,9};
        merge(wrong, 55, wrong2, 99);
        System.out.println(Arrays.toString(wrong));
    }
}
