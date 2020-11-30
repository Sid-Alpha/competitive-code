package twopointer.medium;

import javafx.util.Pair;
import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Question(url = "https://leetcode.com/problems/interval-list-intersections/")
@Enhance(reduce = Stat.TIME)
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<Pair<Integer, Integer>> answer = new LinkedList<>();

        while (i < A.length && j < B.length) {
            if (!(A[i][1] < B[j][0] || B[j][1] < A[i][0]))
                answer.add(new Pair<>(Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])));

            if (A[i][1] > B[j][1]) j++;
            else if (A[i][1] < B[j][1]) i++;
            else { i++; j++; }
        }

        int[][] answerArr = new int[answer.size()][2];
        int count = 0;
        for (Pair<Integer, Integer> p : answer) {
            answerArr[count][0] = p.getKey();
            answerArr[count++][1] = p.getValue();
        }

        return answerArr;
    }

    public static void main(String[] args) {
        IntervalListIntersections ili = new IntervalListIntersections();
        System.out.println(Arrays.deepToString(ili.intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1,5},{8,12},{15,24},{25,26}})));
    }
}
