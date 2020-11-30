package twopointer.easy;

import utils.info.Question;

import java.util.ArrayList;
import java.util.Arrays;

@Question(url = "https://leetcode.com/problems/intersection-of-two-arrays/")
public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {   // Sort & 2ptr
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            while (i+1 < nums1.length && nums1[i] == nums1[i+1]) i++;
            while (j+1 < nums2.length && nums2[j] == nums2[j+1]) j++;
            if (nums1[i] == nums2[j]) { answer.add(nums1[i++]); j++; }
            else if (nums1[i] > nums2[j]) j++;
            else i++;
        }

        int[] answerArr = new int[answer.size()];
        int count = 0;
        for (int num : answer)
            answerArr[count++] = num;

        return answerArr;
    }

//    public int[] intersection(int[] nums1, int[] nums2) { // Using set
//        HashSet<Integer> set = new HashSet<>();
//        ArrayList<Integer> answer = new ArrayList<>();
//        for (int num : nums1) set.add(num);
//        for (int num : nums2)
//            if (set.contains(num)) {
//                set.remove(num);
//                answer.add(num);
//            }
//        int[] answerArr = new int[answer.size()];
//        int count = 0;
//        for (int num : answer)
//            answerArr[count++] = num;
//
//        return answerArr;
//    }

    public static void main(String[] args) {
        IntersectionofTwoArrays intersectionofTwoArrays = new IntersectionofTwoArrays();
        System.out.println(Arrays.toString(intersectionofTwoArrays.intersection(new int[]{1,2,2,1}, new int[]{2})));
        System.out.println(Arrays.toString(intersectionofTwoArrays.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
