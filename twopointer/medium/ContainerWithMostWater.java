package twopointer.medium;

import utils.info.*;

@Question(url = "https://leetcode.com/problems/container-with-most-water/")
@UsedHints
@Enhance(reduce = Stat.SPACE)
@NewAlgo(details = "See how pointers inc/dec leads to optimal answer")
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] == height[j]) break;
            else if (height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));    // 49
        System.out.println(containerWithMostWater.maxArea(new int[] {1,1}));  //  1
        System.out.println(containerWithMostWater.maxArea(new int[] {4,3,2,1,4}));    // 16
        System.out.println(containerWithMostWater.maxArea(new int[] {1,2,1}));    // 2
        System.out.println(containerWithMostWater.maxArea(new int[] {2,3,4,5,18,17,6}));    // 17
    }
}
