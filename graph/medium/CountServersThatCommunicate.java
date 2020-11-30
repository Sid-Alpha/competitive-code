package graph.medium;


import utils.info.Question;

@Question(url = "https://leetcode.com/problems/count-servers-that-communicate/")
public class CountServersThatCommunicate {

    public static int countServers(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[] col = new int[grid.length], row = new int[grid[0].length];

        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(1 == grid[i][j]) {
                    col[i]++;
                    row[j]++;
                }
        int count = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(1 == grid[i][j] && ( col[i] > 1 || row[j] > 1)) count++;

        return count;
    }

    public static void main(String[] args) {
       int[][] network1 = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}},
        network2 = {{1,0},{1,1}};

        System.out.println(countServers(network1));
        System.out.println(countServers(network2));
    }
}
