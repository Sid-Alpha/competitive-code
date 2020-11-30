package graph.easy;

import utils.info.Enhance;
import utils.info.Question;

@Question(url = "https://leetcode.com/problems/find-the-town-judge/")
@Enhance(details = "Time complexity")
public class FindTheTownJudge {

    private static int findJudge(int N, int[][] trust) {
        int[] trustCount = new int[N];

        for(int [] trust1: trust) {
            trustCount[trust1[0]-1]--;
            trustCount[trust1[1]-1]++;
        }

        for(int i = 0; i < trustCount.length; i++)
            if(trustCount[i] == N-1) return i+1;
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust1 = new int[][] {{1,4}, {1,3}, {2,3}, {2,4}, {4,3}};
        System.out.println(findJudge(4, trust1));
    }
}
