package interview.medium.array;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/")
@UsedHints
@Enhance(complexity = Stat.TIME)
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean row1Zero = false, col1Zero = false;
        for(int i = 0; i < matrix.length; i++) if(matrix[i][0] == 0) col1Zero = true;
        for(int i = 0; i < matrix[0].length; i++) if(matrix[0][i] == 0) row1Zero = true;
        for(int i=1; i < matrix.length; i++)
            for (int j=1; j < matrix[0].length; j++)
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        for(int i=1; i < matrix.length; i++)
            for (int j=1; j < matrix[0].length; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
        if(row1Zero) for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        if(col1Zero) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] i1 = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeroes.setZeroes(i1);
        System.out.println(Arrays.deepToString(i1));
    }

}
