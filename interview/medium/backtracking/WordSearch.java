package interview.medium.backtracking;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

@Question(
        url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/",
        theresACatch= "The same letter cell may not be used more than once")
@Enhance(complexity = {Stat.TIME, Stat.SPACE})
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder(word);
        for(int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (existenceHelper(board, i, j, sb)) return true;

        return false;
    }

    private boolean existenceHelper(char[][] board, int i, int j, StringBuilder remainingString) {
        if(remainingString.length() == 0) return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        if(remainingString.charAt(0) == board[i][j]) {
            char matchedChar = remainingString.charAt(0);
            board[i][j] = '0';
            remainingString.deleteCharAt(0);

            if(existenceHelper(board, i+1, j, remainingString) ||
               existenceHelper(board, i-1, j, remainingString) ||
               existenceHelper(board, i, j-1, remainingString) ||
               existenceHelper(board, i, j+1, remainingString)) return true;

            remainingString.insert(0, matchedChar);
            board[i][j] = matchedChar;
        }

        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(wordSearch.exist(board, "ABCCED"));  // true
        System.out.println(wordSearch.exist(board, "SEE"));     // true // Issue in local for some reason, board [2][2] gets overridden for some reason
        System.out.println(wordSearch.exist(board, "ABCB"));    // false
    }
}
