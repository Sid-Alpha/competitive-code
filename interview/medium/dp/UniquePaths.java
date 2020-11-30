package interview.medium.dp;

import utils.info.Enhance;
import utils.info.Question;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/")
@Enhance(details = "Space complexity - Do with bottom up solution")
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        for(int[] mArr : mem) Arrays.fill(mArr, -1);
        return travelHelper(m-1, n-1, mem);
    }

    private int travelHelper(int currentM, int currentN, int[][] mem) {
        if(currentM < 0 || currentN < 0) return 0;
        if(currentM == 0 && currentN == 0) return 1;
        if(mem[currentM][currentN] != -1) return mem[currentM][currentN];

        return mem[currentM][currentN] = travelHelper(currentM-1, currentN, mem) +
                travelHelper(currentM, currentN-1, mem);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(2,3));
        System.out.println(uniquePaths.uniquePaths(7,3));
        System.out.println(uniquePaths.uniquePaths(250,250));
    }
}
