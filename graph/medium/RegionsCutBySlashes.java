package graph.medium;

import utils.graph.DisjointUnion;
import utils.info.Unfinished;

@Unfinished
public class RegionsCutBySlashes {
    public static int regionsBySlashes(String[] grid) {
        DisjointUnion disjointUnion = new DisjointUnion(grid.length * grid[0].length());
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length(); j ++) {
                if(i-1 >= 0) disjointUnion.union(i-1, i);
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
