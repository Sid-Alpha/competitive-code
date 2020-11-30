package interview.medium.others;

import utils.info.Question;
import utils.info.UsedHints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Question(url = "https://leetcode.com/problems/queue-reconstruction-by-height/")
@UsedHints
public class QueueReconstructionbyHeight {

    private static final Comparator<int[]> comp = (i1, i2) -> {
        if (i1[0] == i2[0])
            return Integer.compare(i1[1], i2[1]);
        else return -1 * Integer.compare(i1[0], i2[0]);
    };

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return new int[][] {};

        Arrays.sort(people, comp);
        List<int[]> res = new LinkedList<>();
        for(int[] p : people) res.add(p[1], p);

        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] i1 = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        QueueReconstructionbyHeight qRs = new QueueReconstructionbyHeight();
        System.out.println(Arrays.deepToString(qRs.reconstructQueue(i1)));
    }

}
