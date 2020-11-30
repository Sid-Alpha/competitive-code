package other.medium;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.deepToString;

@Question(url = "https://leetcode.com/problems/k-closest-points-to-origin/")
@Enhance(complexity = {Stat.TIME})
public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) return points;
        Map<Integer, Double> dist = new HashMap<>();

        int i = 0;
        for (int[] point : points)
            dist.put(i++, Math.sqrt((point[0] * point[0]) + (point[1] * point[1])));

        return dist.entrySet().stream().sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .limit(K).map(k -> points[k.getKey()]).toArray(s -> new int[K][2]);
    }

    public static void main(String[] args) {
        KClosestPointstoOrigin kClosestPointstoOrigin = new KClosestPointstoOrigin();
        System.out.println(deepToString(kClosestPointstoOrigin.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }

}
