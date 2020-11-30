package interview.medium.sortandsearch;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.FoundDifficult;
import utils.info.Question;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/")
@FoundDifficult
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class Searcha2DMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false;
        int colBound = matrix[0].length - 1, rowBound = 0;

        while (rowBound < matrix.length && colBound >= 0) {
            if(matrix[rowBound][colBound] > target) colBound--;
            else if (matrix[rowBound][colBound] < target) rowBound++;
            else if (matrix[rowBound][colBound] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        },
                arr2 = new int[][] {{1,4}, {2,5}},
                arr3 = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},
                arr4 = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},
                arr5 = new int[][] {{1,3,5}};
         ;
        Searcha2DMatrix searcha2DMatrix = new Searcha2DMatrix();
//        System.out.println(searcha2DMatrix.searchMatrix(arr1, 5));
//        System.out.println(searcha2DMatrix.searchMatrix(arr1, 20));
//        System.out.println(searcha2DMatrix.searchMatrix(arr2, 2));
//        System.out.println(searcha2DMatrix.searchMatrix(arr3, 5));
        System.out.println(searcha2DMatrix.searchMatrix(arr4, 19));
        System.out.println(searcha2DMatrix.searchMatrix(arr5, 3));
    }
}
