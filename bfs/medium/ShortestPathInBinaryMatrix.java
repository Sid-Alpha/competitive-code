package bfs.medium;

import javafx.util.Pair;
import utils.info.Enhance;
import utils.info.Question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/shortest-path-in-binary-matrix/")
@Enhance(details = "Don't create Pairs")
public class ShortestPathInBinaryMatrix {

    private static final List<Integer> TRAVERSE = Arrays.asList(-1, 0 ,1);

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair<Integer, Integer>> traverser = new LinkedList<>();

        if (grid[0][0] == 0 && grid[grid.length-1][grid.length-1] == 0) traverser.offer(new Pair<>(0, 0));
        grid[0][0] = 1;

        int count = 1;
        while (!traverser.isEmpty()) {
            int toProcessCount = traverser.size();

            while (toProcessCount-- > 0) {
                Pair<Integer, Integer> current = traverser.poll();
                int row = current.getKey(), column = current.getValue();
                if (current.getKey() == grid.length - 1 && current.getValue() == grid[0].length - 1) return count;

                for (int r : TRAVERSE)
                    for (int c : TRAVERSE) {
                        int finalRow = r + row, finalColumn = c + column;
                        if ((r == 0 && c == 0) || finalRow < 0 || finalColumn < 0 ||
                                finalRow >= grid.length || finalColumn >= grid[0].length ||
                                grid[finalRow][finalColumn] == 1) continue;
                        grid[finalRow][finalColumn] = 1;
                        traverser.offer(new Pair<>(finalRow, finalColumn));
                    }
            }

            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        System.out.println(shortestPathInBinaryMatrix.shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}}));
        System.out.println(shortestPathInBinaryMatrix.shortestPathBinaryMatrix(new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}}));
    }

}