package hashtable.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;
import utils.info.UsedHints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Question(url = "https://leetcode.com/problems/brick-wall/")
@Enhance(reduce = Stat.SPACE)
@UsedHints
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> brickEdges = new HashMap<>();

        int max = 0;
        for (List<Integer> row : wall) {
            int curr = 0;
            for (int brickIndex = 0; brickIndex < row.size() - 1; brickIndex++)
                max = Math.max(max, brickEdges.compute(curr += row.get(brickIndex), (k, v) -> (v == null) ? 1 : v + 1));
        }
        return wall.size() - max;
    }


    public static void main(String[] args) {
        BrickWall brickWall = new BrickWall();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,2,1));
        list.add(Arrays.asList(3,1,2));
        list.add(Arrays.asList(1,3,2));
        list.add(Arrays.asList(2,4));
        list.add(Arrays.asList(3,1,2));
        list.add(Arrays.asList(1,3,1,1));
        System.out.println(brickWall.leastBricks(list));
    }
}
