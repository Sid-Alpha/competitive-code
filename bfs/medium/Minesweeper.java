package bfs.medium;

import jdk.jfr.Registered;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;
import utils.info.UsedHints;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/minesweeper/")
@UsedHints
@Enhance(reduce = {Stat.TIME, Stat.SPACE})
public class Minesweeper {

    private static final List<Integer> HELPER = Arrays.asList(-1, 0, 1);

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {click[0], click[1]});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int count = 0;
            for (int i : HELPER)
                for (int j : HELPER) {
                    if (i == 0 && j == 0) continue;
                    int currR = current[0] + i, currC = current[1] + j;
                    if (currR < 0 || currR >= board.length || currC < 0 || currC >= board[0].length) continue;
                    if (board[currR][currC] == 'M' || board[currR][currC] == 'X') count++;
                }
            if (count > 0) board[current[0]][current[1]] = (char)('0'+ count);
            else {
                board[current[0]][current[1]] = 'B';
                for (int i : HELPER)
                    for (int j : HELPER) {
                        if (i == 0 && j == 0) continue;
                        int currR = current[0] + i, currC = current[1] + j;
                        if (currR < 0 || currR >= board.length || currC < 0 || currC >= board[0].length) continue;
                        if (board[currR][currC] == 'E' && ((board[currR][currC] = 'B') == 'B')) queue.offer(new int[] {currR, currC});
                    }
            }

        }

        return board;
    }

    public static void main(String[] args) {
        char[][] mineField = new char[][] {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        Minesweeper minesweeper = new Minesweeper();
        System.out.println(Arrays.deepToString(minesweeper.updateBoard(mineField, new int[]{3, 0})));
    }

}
