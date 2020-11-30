package graph.easy;

import utils.info.Enhance;
import utils.info.NewAlgo;
import utils.info.Question;
import utils.info.UsedHints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Question(url = "https://leetcode.com/problems/flower-planting-with-no-adjacent/")
@Enhance(details = "15ms current time")
@UsedHints
@NewAlgo(details = "Graph Coloring")
public class FloweringPlantWithNoAdjacent {

    public static int[] gardenNoAdj(int N, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>();
        IntStream.range(0,N).forEach(s -> graph.add(new ArrayList<>()));
        int[] color = new int[N];
        for(int [] path : paths) {
            graph.get(path[0]-1).add(path[1]-1);
            graph.get(path[1]-1).add(path[0]-1);
        }
        boolean[] available = new boolean[4];
        Arrays.fill(available, true);
        for(int nodeCount = 0; nodeCount < N; nodeCount++) {
            graph.get(nodeCount).forEach(s -> {if(color[s]!=0) available[color[s]-1]=false;});
            int i;
            for(i=0;i<4;i++) if (available[i]) break;
            color[nodeCount] = i+1;
            Arrays.fill(available, true);
        }
        return color;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(gardenNoAdj(3, new int[][]{
                {1, 2},
                {2, 3},
                {3, 1}
        })));
        System.out.println(Arrays.toString(gardenNoAdj(4, new int[][]{
                {1, 2},
                {3, 4},
        })));
        System.out.println(Arrays.toString(gardenNoAdj(4, new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1},
                {1, 3},
                {2, 4},
        })));
    }
}
