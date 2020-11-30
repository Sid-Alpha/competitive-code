package interview.medium.graph;

import utils.graph.DisjointUnion;
import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.HashSet;

@Question(url = "https://leetcode.com/explore/featured/card/top-interview-questions-medium/108/trees-and-graphs/792/")
@Enhance(complexity = Stat.TIME, details = "w/o using disjoint set union")
public class NumberOfIslands {

    static int colCount = 0;
    static DisjointUnion disjointUnion;
    final static int[] adj = new int[] {-1,+1};
    static char[][] gridS;

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        disjointUnion = new DisjointUnion(grid.length * grid[0].length);
        colCount = grid[0].length;
        gridS = grid;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++)
            for (int colIndex = 0; colIndex < grid[0].length; colIndex++)
                dfsAndUnion(rowIndex, colIndex);

        HashSet<Integer> hs = new HashSet<>();
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++)
            for (int colIndex = 0; colIndex < grid[0].length; colIndex++)
                if(grid[rowIndex][colIndex] == '1')
                    hs.add(disjointUnion.find(computeIndex(rowIndex, colIndex)));

        return hs.size();
    }

    private static void dfsAndUnion(int rowIndex, int colIndex) {
        if(gridS[rowIndex][colIndex] == '0') return;
        for(int i : adj) {
            if(withinBounds(rowIndex+i, colIndex) && disjointUnion.find(computeIndex(rowIndex + i, colIndex))
                    != disjointUnion.find(computeIndex(rowIndex, colIndex)) && gridS[rowIndex+i][colIndex] == '1'){
                disjointUnion.union(computeIndex(rowIndex, colIndex), computeIndex(rowIndex+i, colIndex));
                dfsAndUnion(rowIndex+i, colIndex);
            }
            if(withinBounds(rowIndex, colIndex+i) && disjointUnion.find(computeIndex(rowIndex, colIndex + i))
                    != disjointUnion.find(computeIndex(rowIndex, colIndex)) && gridS[rowIndex][colIndex+i] == '1'){
                disjointUnion.union(computeIndex(rowIndex, colIndex), computeIndex(rowIndex, colIndex + i));
                dfsAndUnion(rowIndex, colIndex+i);
            }
        }
    }

    private static boolean withinBounds(int rowIndex, int colIndex) {
        return rowIndex >= 0 && rowIndex < gridS.length && colIndex >= 0 && colIndex < gridS[0].length;
    }

    private static int computeIndex(int rowIndex, int colIndex) {
        return colCount * rowIndex + colIndex;
    }

    public static void main(String[] args) {
    char[][] grid1 = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
    };
    char[][] grid2 = new char[][] {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }

}
