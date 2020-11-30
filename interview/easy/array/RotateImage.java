package interview.easy.array;

import utils.info.FoundDifficult;
import utils.info.UsedHints;

import java.util.Arrays;

@UsedHints
@FoundDifficult(thinking = "A bit", implementing = "Took a lot of time")
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int frames = matrix.length / 2, size = matrix.length - 1;

        for(int f = 0; f < frames; f++)
            for(int r = 0; r < matrix.length - (2*f) - 1; r++)
            {
                int temp = matrix[f][f+r];
                matrix[f][f+r] = matrix[size-f-r][f];
                matrix[size-f-r][f] = matrix[size-f][size-f-r];
                matrix[size-f][size-f-r] = matrix[f+r][size-f];
                matrix[f+r][size-f] = temp;
            }
    }

    public static void main(String[] args) {
        int[][] arr1 = {
                    {15,13, 2, 5},
                    {14, 3, 4, 1},
                    {12, 6, 8, 9},
                    {16, 7,10,11}
                },
                arr2 = {
                    {7,4,1},
                    {8,5,2},
                    {9,6,3}
                },
                arr3 = {
                        {1,  2,  3,  4,  5},
                        {6,  7,  8,  9,  10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 10},
                        {21, 22, 23, 24, 25},
                }
                // rotation: 3x3-1, 4x4-2, 5x5-2
        ;
        rotate(arr1);
        System.out.println(Arrays.deepToString(arr1));
        rotate(arr2);
        System.out.println(Arrays.deepToString(arr2));
        rotate(arr3);
        System.out.println(Arrays.deepToString(arr3));
    }
}
