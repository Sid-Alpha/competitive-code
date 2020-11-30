package interview.easy.array;

import utils.info.Enhance;

@Enhance(details = "use single loop")
public class ValidSudoku {
    public static boolean isValidSudoku(final char[][] board) {
        for(int i = 0; i < 9; i ++) {
            if(!isValid(board, true, i)) return false;
            if(!isValid(board, false, i)) return false;
        }
        final int[] range = {0, 1, 2};
        for(int i : range)
            for (int j : range) {
                if(!validCube(board, i, j)) return false;
            }

        return true;
    }

    private static boolean validCube(final char[][] board, int rowStart, int colStart) {
        boolean[] helper = new boolean[9];
        for(int i = 3*rowStart; i < 3*(rowStart+1); i++)
            for(int j = 3*colStart; j < 3*(colStart+1); j++) {
                if(board[i][j] == '.') continue;
                if(helper[board[i][j] - '1']) return false;
                helper[board[i][j] - '1'] = true;
            }
            return true;
    }

    static boolean isValid(final char[][] board, boolean isRow, int constantOfOtherVertical) {
        boolean[] helper = new boolean[9];
        for(int i = 0; i < 9; i++) {

            if(isRow) {
                if(board[constantOfOtherVertical][i] == '.') continue;
                if(helper[(board[constantOfOtherVertical][i] - '1')]) return false;
                else helper[(board[constantOfOtherVertical][i] - '1')] = true;
            }
            else {
                if(board[i][constantOfOtherVertical] == '.') continue;
                if(helper[(board[i][constantOfOtherVertical] - '1')]) return false;
                else helper[(board[i][constantOfOtherVertical] - '1')] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] puzzle1 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    },
                puzzle2 = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(puzzle1));
        System.out.println(isValidSudoku(puzzle2));
    }
}
