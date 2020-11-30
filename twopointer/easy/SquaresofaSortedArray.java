package twopointer.easy;

import utils.info.Question;

import java.util.Arrays;

@Question(url = "https://leetcode.com/problems/squares-of-a-sorted-array/")
public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        int i = 0;
        while (i < A.length && A[i] < 0) i++;
        int j = i-1, count = 0;
        int[] answer = new int[A.length];
        while (i < A.length && j >= 0)
            if (Math.abs(A[j]) > A[i]) answer[count++] = A[i] * A[i++];
            else answer[count++] = A[j] * A[j--];
        while (j >= 0) answer[count++] = A[j] * A[j--];
        while (i < A.length) answer[count++] = A[i] * A[i++];

        return answer;
    }

    public static void main(String[] args) {
        SquaresofaSortedArray sortedArray = new SquaresofaSortedArray();
        System.out.println(Arrays.toString(sortedArray.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
